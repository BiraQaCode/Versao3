package br.sp.UbiraProject.tests;

import org.junit.Assert;
import org.junit.Test;

import br.sp.UbiraProject.CoreTest.BaseTest;
import br.sp.UbiraProject.page.HomePage;
import br.sp.UbiraProject.page.MenuPage;

public class SaldoTeste extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testeSaldoConta() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("1000.00", page.obterSaldoConta("NOME_CONTA_ALTERADA"));
		
	}
}
