package br.sp.UbiraProject.CoreTest;

import static br.sp.UbiraProject.core.DriverFactory.getDriver;
import static br.sp.UbiraProject.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.sp.UbiraProject.core.Propriedades;
import br.sp.UbiraProject.page.LoginPage;

public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa(){
		page.acessarTelaInicial();
		page.setEmail("ubiratan.oliveira@sp.br");
		page.setSenha("1234");
		page.Entrar();
		
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File ("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}