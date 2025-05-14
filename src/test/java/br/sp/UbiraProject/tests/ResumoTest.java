package br.sp.UbiraProject.tests;

import static br.sp.UbiraProject.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.sp.UbiraProject.CoreTest.BaseTest;
import br.sp.UbiraProject.core.DriverFactory;
import br.sp.UbiraProject.page.MenuPage;
import br.sp.UbiraProject.page.ResumoPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	
//	@Test
	public void teste1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimenta��o removida com sucesso!", resumoPage.obterMensagemSucesso());

	}
	
	@Test()
	public void teste2_ResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		List<WebElement> elementosEncontrados =
				DriverFactory.getDriver().findElements(By.xpath(".//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(1, elementosEncontrados.size());
		
		/*try {
		DriverFactory.getDriver().findElement(By.xpath(".//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.fail();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}*/
		
		//@Test(expected=NoSuchElementException.class)
		
	}

}
