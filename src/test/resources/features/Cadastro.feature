Feature: Fazer Cadastro no App

@Cadastro1
		Scenario: Validar tela principal de cadastro	
		Given Que estou na tela inicial do app	
		When Acessar a opção login no menu	
		And Clicar no botao Sign Up	
		Then Valido o layout da tela Cadastro

@Cadastro2
		Scenario: Realizar o cadastro de um usuario	
		Given Que estou na tela de cadastro	
		When Preencher meus dados cadastrais	
		And Clicar no botao Register	
		Then Valido o username da conta no menu
