package br.sp.UbiraProject.tests;

import static br.sp.UbiraProject.utils.DataUtils.ObterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.sp.UbiraProject.CoreTest.BaseTest;
import br.sp.UbiraProject.page.MenuPage;
import br.sp.UbiraProject.page.MovimentacaoPage;
import br.sp.UbiraProject.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(ObterDataFormatada(new Date()));
		movPage.setDataPagamento(ObterDataFormatada(new Date()));
		movPage.setDescricao("Teste do Biratchan");
		movPage.setInteressado("Ubiratan Oliveira");
		movPage.setValor("1000");
		movPage.setConta("NOME_CONTA_ALTERADA");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();

		
		List<String> erros = movPage.obterErros();
		//Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0)); -- Se a ordem do erro muda, o teste quebra
		//Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio")); -- Nao estou mais preocupado com a ordem, somente com o erro
		
		System.out.println("Mensagens de erro retornadas: " + erros);
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório", 
				"Descrição é obrigatório", "Interessado é obrigatório", 
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size()	);
	}
	
	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(ObterDataFormatada(dataFutura));
		movPage.setDataPagamento(ObterDataFormatada(dataFutura));
		movPage.setDescricao("Teste do Biratchan");
		movPage.setInteressado("Ubiratan Oliveira");
		movPage.setValor("1000");
		movPage.setConta("NOME_CONTA_ALTERADA");
		movPage.setStatusPago();
		movPage.salvar();
		
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size()	);
		
	}
	

}
