package br.sp.UbiraProject.core;

import static br.sp.UbiraProject.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	/******TextField e TextArea******/
	public void escrever(By by,String texto ) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}	
	
	public void escrever(String id_campo,String texto ) {
		escrever(By.id(id_campo), texto);
	}
	
	public void escreverArea(String id_tag,String texto ) {
		escrever(By.tagName(id_tag), texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/******Radio e Check******/
	
	public void clicarRadio(By by){
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id){
		clicarRadio(By.id(id));
	}
	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id){
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	
	/******Combo******/
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
		
	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esporte"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao:allSelectedOptions) {
			valores.add (opcao.getText());
			}
		return valores;
		
		}	
	
	public int obterQuantidadeOpcoesCombo (String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
		
	}
	
	
	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)) {
				return true;
			}
		}
		
		return false;	
	}
	
	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='"+radical+"']//div[2]/span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"']//li[.='"+valor+"']"));
	}
	
	/******Botao******/
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	
//	public void clicarBotao(String name) {
//		getDriver().findElement(By.name(name));
//	}
	
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");	
	}
	
	public void clicarBotaoPorTexto(String texto) {
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}
	
	/******Link******/
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/******Textos******/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	
	/******Alert******/
	
	public String alertaObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;	
	}
	
	public String alertaObterTextoENega() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	
	/******Frames e Janelas******/
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	public void fecharJanela() {
		getDriver().close();
	}
	
	
	
	/******JS******/
	public Object executarJS (String cmd, Object... param){
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	
	/******Tabelas******/
	/*public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTab) {
		
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTab+"']"));
		//WebElement tabela = getDriver().findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]"));
		
		//WebElement tabela = getDriver().findElement(By.cssSelector("#" + idTab)); // Busca pelo ID da tabela
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do bot�o
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		
		//clicar no botao da celular encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
				
	}
	
	/*public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTab) {
	    // Procurar a tabela
	    WebElement tabela = getDriver().findElement(By.xpath("//*[@id='" + idTab + "']"));

	    // Obter índices das colunas e da linha
	    int idColuna = obterIndiceColuna(colunaBusca, tabela);
	    int idLinha = obterIndiceLinha(valor, tabela, idColuna);
	    int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

	    // Debugging: Verificar valores calculados
	    System.out.println("Tabela ID: " + idTab);
	    System.out.println("Índice da Coluna de Busca: " + idColuna);
	    System.out.println("Índice da Linha: " + idLinha);
	    System.out.println("Índice da Coluna do Botão: " + idColunaBotao);

	    // XPath ajustado para encontrar o botão de edição dentro da célula
	    By xpathBotao = By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]//button");

	    // Espera explícita para garantir que o botão esteja visível e clicável
	    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
	    WebElement botaoEditar = wait.until(ExpectedConditions.elementToBeClickable(xpathBotao));

	    return botaoEditar;
	}
		
		public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTab) {			
			//clicar no botao da celular encontrada
			WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTab);
			celula.findElement(By.xpath(".//input")).click();
		
		
	}


	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i=0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
	}
		return idLinha;
		
	}


	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i=0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}*/

	/******Tabelas ******/
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTab) {
	    // Procurar a tabela pelo ID
	    WebElement tabela = getDriver().findElement(By.id(idTab));

	    // Obter índice da coluna de busca
	    int idColuna = obterIndiceColuna(colunaBusca, tabela);
	    if (idColuna == -1) {
	        throw new RuntimeException("Coluna '" + colunaBusca + "' não encontrada na tabela.");
	    }

	    // Encontrar a linha do registro
	    int idLinha = obterIndiceLinha(valor, tabela, idColuna);
	    if (idLinha == -1) {
	        throw new RuntimeException("Valor '" + valor + "' não encontrado na coluna '" + colunaBusca + "'.");
	    }

	    // Obter índice da coluna do botão
	    int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
	    if (idColunaBotao == -1) {
	        throw new RuntimeException("Coluna do botão '" + colunaBotao + "' não encontrada.");
	    }

	    // Retornar a célula que contém o botão
	    return tabela.findElement(By.xpath(".//tbody/tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
	}

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTab) {
	    WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTab);

	    // No seu HTML, os botões são <a> dentro da <td>
	    WebElement botaoEditar = celula.findElement(By.xpath(".//a[contains(@href,'editarConta')]"));
	    botaoEditar.click();
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
	    List<WebElement> linhas = tabela.findElements(By.xpath(".//tbody/tr/td[" + idColuna + "]"));
	    for (int i = 0; i < linhas.size(); i++) {
	        if (linhas.get(i).getText().trim().equals(valor)) {
	            return i + 1;
	        }
	    }
	    return -1;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
	    List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
	    for (int i = 0; i < colunas.size(); i++) {
	        if (colunas.get(i).getText().trim().equals(coluna)) {
	            return i + 1;
	        }
	    }
	    return -1;
	}

	
}
