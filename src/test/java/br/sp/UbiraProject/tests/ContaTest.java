package br.sp.UbiraProject.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.sp.UbiraProject.CoreTest.BaseTest;
import br.sp.UbiraProject.page.ContasPage;
import br.sp.UbiraProject.page.MenuPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContaTest extends BaseTest {
	
	
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void teste1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	
	@Test
	public void teste2_AlterarConta() {
		menuPage.acessarListaConta();
		
		contasPage.clicaAlterarConta("Conta do Teste");
		contasPage.setNome("NOME_CONTA_ALTERADA");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void teste3_InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("NOME_CONTA_ALTERADA");
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
		
	}
	
	

}
