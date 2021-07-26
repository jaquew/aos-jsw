package com.aos.pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class CadastroPage {
	AppiumDriver<MobileElement> driver;
	int y;

	public CadastroPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
		y = (driver.manage().window().getSize().getHeight() - 400);

	}

	@AndroidFindBy(id = "textViewAccountDetails")
	MobileElement txtAccDet;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/android.widget.EditText")
	MobileElement cmpUsername;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/android.widget.EditText")
	MobileElement cmpEmail;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/android.widget.EditText")
	MobileElement cmpPass;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/android.widget.EditText")
	MobileElement cmpConfPass;

	@AndroidFindBy(xpath = "//*[@text='FIRST NAME']/preceding-sibling::android.widget.EditText")
	MobileElement cmpFirsName;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/android.widget.EditText")
	MobileElement cmpLastName;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/android.widget.EditText")
	MobileElement cmpPhoneNum;

	@AndroidFindBy(id = "textViewCountries")
	MobileElement cmbCountries;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/android.widget.EditText")
	MobileElement cmpState;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/android.widget.EditText")
	MobileElement cmpAdress;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/android.widget.EditText")
	MobileElement cmpCity;

	@AndroidFindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/android.widget.EditText")
	MobileElement cmpZip;

	@AndroidFindBy(id = "switchLocation")
	MobileElement selLocation;

	@AndroidFindBy(id = "checkBoxRecieveOffers")
	MobileElement chkOffers;

	@AndroidFindBy(id = "checkBoxAgreeConditions")
	MobileElement chkAccept;

	@AndroidFindBy(id = "buttonRegister")
	MobileElement btnRegister;

	@AndroidFindBy(id = "textViewMenuUser")
	MobileElement txtUser;

	public void validaTelaCadastro() {
		Assert.assertTrue("Validação campo Username", cmpUsername.isDisplayed());
		Assert.assertTrue("Validação campo Email", cmpEmail.isDisplayed());
		Assert.assertTrue("Validação campo Password", cmpPass.isDisplayed());
		Assert.assertTrue("Validação campo Confirm Password", cmpConfPass.isDisplayed());
		Assert.assertTrue("Validação campo First Name", cmpFirsName.isDisplayed());
		Assert.assertTrue("Validação campo Last Name", cmpLastName.isDisplayed());
		swipeDown();
		swipeDown();
		Assert.assertTrue("Validação campo Phone number", cmpPhoneNum.isDisplayed());
		Assert.assertTrue("Validação combo Country", cmbCountries.isDisplayed());
		Assert.assertTrue("Validação campo State", cmpState.isDisplayed());
		Assert.assertTrue("Validação campo Adress", cmpAdress.isDisplayed());
		Assert.assertTrue("Validação campo City", cmpCity.isDisplayed());
		Assert.assertTrue("Validação campo ZIP", cmpZip.isDisplayed());
		swipeDown();
		Assert.assertTrue("Validação link Sign Up", selLocation.isDisplayed());
		Assert.assertTrue("Validação link Sign Up", chkOffers.isDisplayed());
		Assert.assertTrue("Validação link Sign Up", chkAccept.isDisplayed());
		Assert.assertTrue("Validação link Sign Up", btnRegister.isDisplayed());
	}

	public void preencheDadosAcc(String user, String email, String pass) {
		cmpUsername.sendKeys(user);
		cmpEmail.sendKeys(email);
		cmpPass.sendKeys(pass);
		cmpConfPass.sendKeys(pass);
	}

	public void preencheDadosPersonal(String fName, String lName, String phone) {
		cmpFirsName.sendKeys(fName);
		cmpLastName.sendKeys(fName);
		cmpPhoneNum.sendKeys(phone);
	}

	public void preencheDadosAdress(String state, String adress, String city, String zip, String country) {
		swipeDown();
		swipeDown();
		cmbCountries.click();
		List<MobileElement> listCountries = driver.findElementsByXPath("//*[@text = '"+country+"']");
		
		while (listCountries.isEmpty()) {
			swipeDown();
			listCountries = driver.findElementsByXPath("//*[@text = '"+country+"']");
		}
		listCountries.get(0).click();
		swipeDown();
		cmpState.sendKeys(state);
		cmpAdress.sendKeys(adress);
		cmpCity.sendKeys(city);
		cmpZip.sendKeys(zip);
	}

	public void clicaRegister() {
		btnRegister.click();
	}

	private void swipeDown() {
		new TouchAction(driver).press(PointOption.point(550, y)).waitAction().moveTo(PointOption.point(550, 500))
				.release().perform();

	}
}
