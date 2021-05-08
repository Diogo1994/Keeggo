package metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Metodos {

	private static final String RandomStringUtils = null;
	public static WebDriver driver;

	public void abrirNavegador(String site) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(site);
		driver.manage().window().maximize();
	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public void pausa(int tempo) throws InterruptedException {
		Thread.sleep(tempo);

	}

	public void esperarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}

	public void fechar() {
		driver.quit();
	}

	private static Random rand = new Random();
	private static char[] letras = "abcdefghijlmnopqrstuvxz".toCharArray();

	public String getNome() {

		StringBuffer generatedString = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			int ch = rand.nextInt(letras.length);
			generatedString.append(letras[ch]);
		}
		return generatedString.toString();

	}
	
	public void ScrenShot(String nome) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/evidencias/"+nome+".png");
		FileUtils.copyFile(scrFile, destFile);
	}
	
}