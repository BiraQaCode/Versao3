package br.sp.UbiraProject.page;

import br.sp.UbiraProject.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String nome) {
			return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();		
	}
}
