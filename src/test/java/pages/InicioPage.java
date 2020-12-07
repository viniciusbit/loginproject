package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class InicioPage extends BasePage {

	public InicioPage(WebDriver navegador) {
		super(navegador);
		PageFactory.initElements(navegador, this);
	}

	@FindBy(id="menu-news-events")
	private WebElement menuCircularesEEventos;
	
	
	public CircularesEventosPage clickMenuCircularesEEventos() {
		menuCircularesEEventos.click();
		return new CircularesEventosPage(navegador);
	}
	

}
