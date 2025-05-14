package br.sp.UbiraProject.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
	
	//private static WebDriver driver; //instancia estatica do Webdriver
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
			
		}
	};//instancia da Thread
	
	private DriverFactory (){} //construtor privado
	
	//criando nova implementaçao do GetDriver
	//assim que a thread inicia, ela chama o initDriver que vai criar uma instancia do webdriver propria para a thread
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
			switch (Propriedades.browser) {
			case FIREFOX: driver = new FirefoxDriver(); break;
			case CHROME: driver = new ChromeDriver(); break;
		}
			
		driver.manage().window().setSize(new Dimension (1200, 765));
		
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
		driver.quit();
		driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}


}
