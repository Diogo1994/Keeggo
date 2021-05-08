package steps;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.CreateNewAccount;
import metodos.LoginUser;
import metodos.Metodos;

public class Steps {
	
	Metodos metodos = new Metodos();
	CreateNewAccount account = new CreateNewAccount();
	LoginUser login = new LoginUser();

	
	@Given("que eu acessar o site")
	public void que_eu_acessar_o_site() {
		
		metodos.abrirNavegador("http://advantageonlineshopping.com/");
		
	}

	@When("cadatrar uma nova conta")
	public void cadatrar_uma_nova_conta() throws InterruptedException {
		
		account.criarConta("e2e@e2e.com.br", "E@E1010a", "E@E1010a", "Lorenzo", "Barbosa", "11940053248", "Brazil",
				"São Paulo", "rua e2e", "SP", "06414000");
	}

	@Then("eu valido essa informacoes")
	public void eu_valido_essa_informacoes() throws IOException, InterruptedException {
		account.ScrenShot("Evidencias");
		account.validarUser();
	}

	@When("eu fazer o login")
	public void eu_fazer_o_login() throws InterruptedException, IOException {
	    login.fazerLogin();
	}

	@Then("valido as informacoes")
	public void valido_as_informacoes() throws IOException, InterruptedException {
	    login.validaInformação();
	}

	
	
	
}
