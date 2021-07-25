package com.aos.steps;

import org.openqa.selenium.support.PageFactory;

import com.aos.utils.DriverSetup;
import org.junit.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	AppiumDriver<MobileElement> driver;

//	public LoginSteps() {
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//	}

	@Before
	public void setUp() throws Exception {
		driver = new DriverSetup().driverSetup();
		PageFactory.initElements(new AppiumFieldDecorator(driver), LoginSteps.class);
	}

	@After
	public void tear() {
//		driver.closeApp();
	}

	@AndroidFindBy(id = "imageViewMenu")
	MobileElement menu;

//	
//	@AndroidFindBy(id = "linearLayoutLogin")
//    MobileElement loginMenu;

	@Given("Que estou na tela inicial do app")
	public void que_estou_na_tela_inicial_do_app() throws Exception {
		Thread.sleep(2000);
		System.out.println("Que estou na tela inicial do app");
		Assert.assertTrue(driver.findElementById("imageViewMenu").isDisplayed());
	}

	@When("Acessar a opção login do menu")
	public void acessar_a_opção_login_do_menu() throws Exception {
		System.out.println("Acessar a opção login do menu");
		Thread.sleep(2000);
		driver.findElementById("imageViewMenu").click();
		driver.findElementById("linearLayoutLogin").click();

	}

	@Then("Valido o layout da tela Login")
	public void valido_o_layout_da_tela_login() throws Exception {
		System.out.println("Valido o layout da tela Login");
		Thread.sleep(2000);
		Assert.assertTrue("Validação campo Username", driver.findElementByXPath(
				"//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginUserName']/android.widget.EditText")
				.isDisplayed());
		Assert.assertTrue("Validação campo Password", driver.findElementByXPath(
				"//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginPassword']/android.widget.EditText")
				.isDisplayed());
		Assert.assertTrue("Validação botao Login", driver.findElementById("buttonLogin").isDisplayed());
		Assert.assertTrue("Validação link Forgot Password",
				driver.findElementById("textViewForgetPassword").isDisplayed());
		Assert.assertTrue("Validação text Don't have an acc",
				driver.findElementById("textViewDontHaveAnAccount").isDisplayed());
		Assert.assertTrue("Validação link Sign Up", driver.findElementById("textViewSingUpToday").isDisplayed());

	}

	@Given("Que estou na tela de login")
	public void que_estou_na_tela_de_login() throws Exception {
		acessar_a_opção_login_do_menu();
	}

	@When("Preencher meus dados de acesso")
	public void preencher_meus_dados_de_acesso() throws Exception {
		Thread.sleep(1000);
		driver.findElementByXPath(
				"//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginUserName']/android.widget.EditText")
				.sendKeys("branca");
		driver.findElementByXPath(
				"//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginPassword']/android.widget.EditText")
				.click();
		driver.findElementByXPath(
				"//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginPassword']/android.widget.EditText")
				.sendKeys("Senha1234");

	}

	@When("Clicar no botao login")
	public void clicar_no_botao_login() throws Exception {
		MobileElement botao = driver.findElementById("buttonLogin");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(2000);
		if (!driver.findElementsByXPath("//*[@resource-id='android:id/message']").isEmpty()) {
			driver.findElementByXPath("//*[@resource-id='android:id/button2']").click();
		}
	}

	@Then("Valido o username da conta no menu")
	public void valido_o_username_da_conta_no_menu() throws Exception {
		Thread.sleep(2000);
		driver.findElementById("imageViewMenu").click();
		Assert.assertEquals(driver.findElementById("textViewMenuUser").getText(), "branca");
	}

	@Given("Que estou logado na tela inicial do app")
	public void que_estou_logado_na_tela_inicial_do_app() throws Exception {
		Thread.sleep(2000);
		driver.findElementById("imageViewMenu").click();
		if (driver.findElementsById("textViewMenuSignOut").isEmpty()) {
			driver.findElementById("linearLayoutLogin").click();
			preencher_meus_dados_de_acesso();
			clicar_no_botao_login();
			driver.findElementById("imageViewMenu").click();
		}
	}

	@When("Acessar a opcao sign out do menu")
	public void acessar_a_opcao_sign_out_do_menu() {
		driver.findElementById("textViewMenuSignOut").click();
		driver.findElementByXPath("//*[@resource-id='android:id/button2']").click();
		
	}

	@Then("Valido a opção login no menu")
	public void valido_a_opção_login_no_menu() {
		driver.findElementById("imageViewMenu").click();
		Assert.assertTrue("Validação opçao Login", driver.findElementById("linearLayoutLogin").isDisplayed());
	}

}
