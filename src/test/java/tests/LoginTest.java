package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.net.MalformedURLException;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.CreatedWebDriver;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InfTestData.csv")
public class LoginTest {
	@Rule 
	public  final  TestName name =  new  TestName ();
	private WebDriver navegador;
	private LoginPage loginpage;
	
	@Before
	public void setUp() throws MalformedURLException {
		navegador = CreatedWebDriver.createdChrome();
		loginpage = new LoginPage(navegador);
	}
	
	
	@Test
	public void testCriacaoCircularComSucesso(@Param (name="email")String email, @Param (name="senha")String senha,
			@Param (name="titulocircular")String titulocircular,
			@Param (name="descricaocircular")String descricaocircular) {
		String returnmessage = 
				loginpage
		.inputEmail(email)
		.inputSenha(senha)
		.clickButtonEntrar()
		.clickMenuCircularesEEventos()
		.clickButtonCriarCircular()
		.inputTituloCircular(titulocircular)
		.inputDescricaoCircular(descricaocircular)
		.clickButtonCriar()
		.verifyMessage()
		;
		assertEquals("Circular criada com sucesso.", returnmessage);		
		
	}
	

	@Test
	public void testCriacaoCircularSemTitulo(@Param (name="email")String email, @Param (name="senha")String senha,
			@Param (name="descricaocircular")String descricaocircular) {
		boolean returnbuttondisabled = 
				loginpage
		.inputEmail(email)
		.inputSenha(senha)
		.clickButtonEntrar()
		.clickMenuCircularesEEventos()
		.clickButtonCriarCircular()
		.inputDescricaoCircular(descricaocircular)
		.verifyButton()
		;
		assertTrue(returnbuttondisabled);		
		
	}
	

	@Test
	public void testCriacaoCircularSemDescricao(@Param (name="email")String email, @Param (name="senha")String senha,
			@Param (name="titulocircular")String titulocircular) {
		boolean returnbuttondisabled = 
				loginpage
		.inputEmail(email)
		.inputSenha(senha)
		.clickButtonEntrar()
		.clickMenuCircularesEEventos()
		.clickButtonCriarCircular()
		.inputTituloCircular(titulocircular)
		.verifyButton()
		;
		assertTrue(returnbuttondisabled);		
		
	}
	
	@Test
	public void testCriacaoCircularSemTituloESemDescricao(@Param (name="email")String email, @Param (name="senha")String senha
			) {
		boolean returnbuttondisabled = 
				loginpage
		.inputEmail(email)
		.inputSenha(senha)
		.clickButtonEntrar()
		.clickMenuCircularesEEventos()
		.clickButtonCriarCircular()
		.verifyButton()
		;
		assertTrue(returnbuttondisabled);		
		
	}
	
	@After
	public void tearDown() {
		CreatedWebDriver.screenShot(name.getMethodName().toString());
		navegador.quit();
	}
	
	
	
}
