package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver navegador) {
		super(navegador);
		PageFactory.initElements(navegador, this);
	}

	@FindBy(id = "login--input--email")
	private WebElement inputemail;
	
	@FindBy(id="login--input--password")
	private WebElement inputsenha;
	
	@FindBy(id="login--button--submit")
	private WebElement buttonEntrar;
	
	
	public LoginPage inputEmail(String email) {
		inputemail.sendKeys(email);
		return this;
	}
	
	public LoginPage inputSenha(String senha) {
		inputsenha.sendKeys(senha);
		return this;
	}
	
	public InicioPage clickButtonEntrar() {
		buttonEntrar.click();
		return new InicioPage(navegador);
	}
}
