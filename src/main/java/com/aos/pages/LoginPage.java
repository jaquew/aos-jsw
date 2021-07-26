package com.aos.pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	AppiumDriver<MobileElement> driver;

	public LoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);

	}

	@AndroidFindBy(id = "imageViewMenu")
	MobileElement menu;

	@AndroidFindBy(id = "linearLayoutLogin")
	MobileElement linkLogin;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginUserName']/android.widget.EditText")
	MobileElement cmpUsername;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLoginPassword']/android.widget.EditText")
	MobileElement cmpPass;

	@AndroidFindBy(id = "buttonLogin")
	MobileElement btnLogin;

	@AndroidFindBy(id = "textViewForgetPassword")
	MobileElement txtForgetPass;

	@AndroidFindBy(id = "textViewDontHaveAnAccount")
	MobileElement txtDontHaveAcc;

	@AndroidFindBy(id = "textViewSingUpToday")
	MobileElement linkSingUp;

	@AndroidFindBy(xpath = "//*[@resource-id='android:id/button2']")
	MobileElement btn2;
	
	@AndroidFindBy(id = "textViewMenuUser")
	MobileElement nomeUser;
	
	@AndroidFindBy(id = "textViewMenuSignOut")
	MobileElement btnSignOut;
	
	public void verificaTelaInicial() {
		Assert.assertTrue(menu.isDisplayed());
	}

	public void abreMenu() {
		menu.click();
	}

	public void acessaOpLogin() {
		linkLogin.click();
	}

	public void validaTelaLogin() {
		Assert.assertTrue("Validação campo Username", cmpUsername.isDisplayed());
		Assert.assertTrue("Validação campo Password", cmpPass.isDisplayed());
		Assert.assertTrue("Validação botao Login", btnLogin.isDisplayed());
		Assert.assertTrue("Validação link Forgot Password", txtForgetPass.isDisplayed());
		Assert.assertTrue("Validação text Don't have an acc", txtDontHaveAcc.isDisplayed());
		Assert.assertTrue("Validação link Sign Up", linkSingUp.isDisplayed());
	}

	public void preencheDados(String user, String pass) {
		cmpUsername.sendKeys(user);
		cmpPass.click();
		cmpPass.sendKeys(pass);
	}

	public void clicaLogin() {
		btnLogin.click();
	}

	public void trataPopUp() {
		if (!driver.findElementsByXPath("//*[@resource-id='android:id/message']").isEmpty()) {
			btn2.isDisplayed();
			btn2.click();
		}
	}

	public void validaLoginFeito(String user) {
		Assert.assertEquals(nomeUser.getText(), user);
	}

	public void clicaSignOut() {
		btnSignOut.click();
		
	}

	public void validaOpcaoLogin() {
		Assert.assertTrue("Validação opçao Login", linkLogin.isDisplayed());
		
	}

	public void clicaSignUp() {
		linkSingUp.click();
		
	}

}
