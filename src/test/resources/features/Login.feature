Feature: Fazer Login com Dados de Acesso
@Login1
	  Scenario: Validar tela principal de login	
	  Given Que estou na tela inicial do app	
	  When Acessar a opção login do menu	
	  Then Valido o layout da tela Login
  
@Login2
	  Scenario: Fazer Login	
	  Given Que estou na tela de login	
	  When Preencher meus dados de acesso	
	  And Clicar no botao login	
	  Then Valido o username da conta no menu
  
 @Login3
	  Scenario: Sair da conta do usuario logado	
	  Given Que estou logado na tela inicial do app	
	  When Acessar a opcao sign out do menu
  	Then Valido a opção login no menu  