package metodos;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

public class CreateNewAccount extends Metodos {

	Metodos metodo = new Metodos();

	By user = By.id("menuUser");

	By createAccount = By.xpath("//a[contains(text(),\"CREATE NEW ACCOUNT\")]");

	By userName = By.name("usernameRegisterPage");
	By email = By.name("emailRegisterPage");
	By password = By.name("passwordRegisterPage");
	By confPassword = By.name("confirm_passwordRegisterPage");
	By firstName = By.name("first_nameRegisterPage");
	By lastName = By.name("last_nameRegisterPage");
	By phone = By.name("phone_numberRegisterPage");
	By country = By.name("countryListboxRegisterPage");
	By city = By.name("cityRegisterPage");
	By address = By.name("addressRegisterPage");
	By province = By.name("state_/_province_/_regionRegisterPage");
	By postalCode = By.name("postal_codeRegisterPage");

	By promocoes = By.name("nanallowOffersPromotion");
	By concordo = By.name("i_agree");
	By register = By.id("register_btnundefined");

	String usuario;

	public void criarConta(String email, String password, String confirmPassword, String firstName, String lastName,
			String phoneNumber, String country, String city, String adress, String province, String postalCode) throws InterruptedException {

		this.usuario = metodo.getNome();

		metodo.esperarElemento(user);
		metodo.clicar(user);

		metodo.pausa(3000);
		metodo.clicar(createAccount);

		metodo.esperarElemento(this.userName);
		metodo.escrever(this.userName, this.usuario);
		System.out.println(this.usuario);
		metodo.escrever(this.email, email);
		metodo.escrever(this.password, password);
		metodo.escrever(this.confPassword, confirmPassword);
		metodo.escrever(this.firstName, firstName);
		metodo.escrever(this.lastName, lastName);
		metodo.escrever(this.country, country);
		metodo.escrever(this.city, city);
		metodo.escrever(this.address, adress);
		metodo.escrever(this.province, province);
		metodo.escrever(this.postalCode, postalCode);
		metodo.clicar(concordo);
		metodo.clicar(register);

	}

	public void validarUser() throws InterruptedException {
		metodo.pausa(10000);
		String loginName = driver.findElement(By.cssSelector("#menuUserLink > span")).getText(); 
		System.out.println("O nome retornado é: " + loginName);
		assertEquals(this.usuario, loginName);
		metodo.fechar();
	}
	

}