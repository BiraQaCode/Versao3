package br.sp.UbiraProject.tests;

import org.junit.Assert;
import org.junit.Test;

import br.sp.UbiraProject.CoreTest.BaseTest;
import br.sp.UbiraProject.page.ContasPage;
import br.sp.UbiraProject.page.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeExcluirContaComMovimentacao() {
		menuPage.acessarListaConta();
		
		contasPage.clicaExcluirConta("NOME_CONTA_ALTERADA");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
		
	}
}
