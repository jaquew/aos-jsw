package com.aos.steps;

import com.aos.pages.CadastroPage;
import com.aos.pages.LoginPage;
import com.aos.utils.DriverSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	AppiumDriver<MobileElement> driver;
	LoginPage login;
	CadastroPage cadastro;

	@Before
	public void setUp() throws Exception {
		driver = new DriverSetup().driverSetup();
		login = new LoginPage(driver);
		cadastro = new CadastroPage(driver);
	}

	@After
	public void tear() {
		driver.closeApp();
	}
	
	@Given("Que estou na tela inicial do app")
	public void que_estou_na_tela_inicial_do_app() throws Exception {
		System.out.println("Que estou na tela inicial do app");
		login.verificaTelaInicial();
	}

	@When("Acessar a opção login do menu")
	public void acessar_a_opção_login_do_menu() throws Exception {
		System.out.println("Acessar a opção login do menu");
		login.abreMenu();
		login.acessaOpLogin();

	}

	@Then("Valido o layout da tela Login")
	public void valido_o_layout_da_tela_login() throws Exception {
		System.out.println("Valido o layout da tela Login");
		login.validaTelaLogin();

	}

	@Given("Que estou na tela de login")
	public void que_estou_na_tela_de_login() throws Exception {
		acessar_a_opção_login_do_menu();
	}

	@When("Preencher meus dados de acesso")
	public void preencher_meus_dados_de_acesso() throws Exception {
		login.preencheDados("branca", "Senha1234");
	}

	@When("Clicar no botao login")
	public void clicar_no_botao_login() throws Exception {
		login.clicaLogin();
		login.trataPopUp();
	}

	@Then("Valido o username {string} da conta no menu")
	public void valido_o_username_da_conta_no_menu(String user) throws Exception {
		Thread.sleep(2000);
		login.abreMenu();
		login.validaLoginFeito(user);
	}

	@Given("Que estou logado na tela inicial do app")
	public void que_estou_logado_na_tela_inicial_do_app() throws Exception {
		login.abreMenu();
		if (driver.findElementsById("textViewMenuSignOut").isEmpty()) {
			login.acessaOpLogin();
			preencher_meus_dados_de_acesso();
			clicar_no_botao_login();
			login.abreMenu();
		}
	}

	@When("Acessar a opcao sign out do menu")
	public void acessar_a_opcao_sign_out_do_menu() {
		login.clicaSignOut();
		login.trataPopUp();
	}

	@Then("Valido a opção login no menu")
	public void valido_a_opção_login_no_menu() {
		login.abreMenu();
		login.validaOpcaoLogin();
	}

	
	// Steps Cadastro
	@When("Clicar no botao Sign Up")
	public void clicar_no_botao_sign_up() {
		login.clicaSignUp();

	}
	
	@Then("Valido o layout da tela Cadastro")
	public void valido_o_layout_da_tela_cadastro() {
		cadastro.validaTelaCadastro();

	}
	
	@Given("Que estou na tela de cadastro")
	public void que_estou_na_tela_de_cadastro() throws Exception {
		acessar_a_opção_login_do_menu();
		login.clicaSignUp();

	}

	@When("Preencher meus dados cadastrais user {string}")
	public void preencher_meus_dados_cadastrais_user(String user) {
	cadastro.preencheDadosAcc(user, "mary01@anymail.com", "Senha1234");
	cadastro.preencheDadosPersonal("Mary", "Anne", "99999999");
	cadastro.preencheDadosAdress("São Paulo", "Av Paulista", "São Paulo", "999999", "Brazil");

	}

	@When("Clicar no botao Register")
	public void clicar_no_botao_register() {
		cadastro.clicaRegister();

	}

}
