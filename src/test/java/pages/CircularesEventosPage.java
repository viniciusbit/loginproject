package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class CircularesEventosPage extends BasePage{

	public CircularesEventosPage(WebDriver navegador) {
		super(navegador);
		PageFactory.initElements(navegador, this);
	}

	@FindBy(id="create-announcement")
	private WebElement buttonCriarCircular;
	
	public NewCircularPage clickButtonCriarCircular() {
		buttonCriarCircular.click();
		return new NewCircularPage(navegador);
	}
	
	
}