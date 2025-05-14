package br.sp.UbiraProject.page;

import br.sp.UbiraProject.core.BasePage;

public class MenuPage extends BasePage {
	
		public void acessarTelaInserirConta (){
			clicarLink("Contas");
			clicarLink("Adicionar");
		}
		
		public void acessarListaConta() {
			clicarLink("Contas");
			clicarLink("Listar");
			
		}
		
		public void acessarTelaInserirMovimentacao() {
			clicarLink("Criar Movimentação");
			
		}
		
		public void acessarTelaResumo() {
			clicarLink("Resumo Mensal");
		}
		
		public void acessarTelaPrincipal() {
			clicarLink("Home");
		}
		
		
}
