package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BasePage;

public class NewCircularPage extends BasePage {

	public NewCircularPage(WebDriver navegador) {
		super(navegador);
		PageFactory.initElements(navegador, this);
	}

	@FindBy(id = "alert-title")
	private WebElement inputTitulo;

	@FindBy(id = "alert-description")
	private WebElement inputDescricao;

	@FindBy(id = "confirm-button")
	private WebElement buttonCriar;

	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div/div[2]")
	private WebElement message;

	public NewCircularPage inputTituloCircular(String titulo) {
		inputTitulo.sendKeys(titulo);
		return this;
	}

	public NewCircularPage inputDescricaoCircular(String descricao) {
		inputDescricao.sendKeys(descricao);
		return this;
	}

	public NewCircularPage clickButtonCriar() {
		buttonCriar.click();
		return this;
	}

	public String verifyMessage() {
		new WebDriverWait(navegador, 10)
				.until(ExpectedConditions.textToBePresentInElement(message, "Circular criada com sucesso."));
		return message.getText();
	}

	public boolean verifyButton() {
		try {
			new WebDriverWait(navegador, 2)
					.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(buttonCriar)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
