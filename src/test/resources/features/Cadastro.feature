Feature: Fazer Cadastro no App

@Cadastro1
		Scenario: Validar tela principal de cadastro	
		Given Que estou na tela inicial do app	
		When Acessar a opção login do menu	
		And Clicar no botao Sign Up	
		Then Valido o layout da tela Cadastro

@Cadastro2
		Scenario: Realizar o cadastro de um usuario	
		Given Que estou na tela de cadastro	
		When Preencher meus dados cadastrais user "maria3"	
		And Clicar no botao Register	
		Then Valido o username "maria3" da conta no menu
