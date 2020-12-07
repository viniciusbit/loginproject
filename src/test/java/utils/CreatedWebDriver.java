package utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatedWebDriver {

	private static String url = "https://qa.townsq.io/login";
	private static WebDriver navegador;

	public static WebDriver createdChrome() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"src\\test\\resources\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		navegador.get(url);
		return navegador;
	}

	public static void screenShot(String nome) {

		try {
			TakesScreenshot scrShot = ((TakesScreenshot) navegador);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("imagens", nome +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
