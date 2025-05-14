package br.sp.UbiraProject.page;

import br.sp.UbiraProject.core.BasePage;
import br.sp.UbiraProject.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");
	}

	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha (String senha) {
		escrever("senha", senha);
	}
	
	public void Entrar() {
		clicarBotaoPorTexto("Entrar");
	}
	
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		Entrar();
	}
}
