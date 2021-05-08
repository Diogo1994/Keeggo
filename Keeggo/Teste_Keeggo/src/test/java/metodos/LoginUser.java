package metodos;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

public class LoginUser extends CreateNewAccount {

	Metodos metodo = new Metodos();
	
	By username = By.name("username");
	By passWrod = By.name("password");
	By signIn = By.id("sign_in_btnundefined");
	
	String usuario;
	
	public void fazerLogin() throws InterruptedException, IOException {
	
		this.usuario = metodo.getNome();
	
	metodo.esperarElemento(user);
	metodo.clicar(user);
	
	metodo.pausa(3000);
	metodo.esperarElemento(username);
	metodo.escrever(username, "Lorenzo");
	metodo.escrever(passWrod, "E@E1010a");
	metodo.esperarElemento(signIn);
	metodo.clicar(signIn);
	metodo.pausa(3000);
	
	}
	
	public void validaInformação() throws IOException, InterruptedException {
		
		metodo.pausa(3000);
		String loginName = driver.findElement(By.cssSelector("#menuUserLink > span")).getText(); 
		System.out.println("O nome retornado é: " + loginName);
		assertEquals("Lorenzo", loginName);
		
		metodo.ScrenShot("Evidencias1");
		metodo.fechar();
	}

}