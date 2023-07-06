Feature: install

  @installlDatabaseMantisBT
  Scenario: install database mantisbt
    Given acesso a tela de configuracao do mantisBT
    And informo os dados necessarios para configurar o mantisBT
    When seleciono instalar database
    Then o mantisBT e configurado com sucesso

  @MontaOBancoDeDados
  Scenario: criar banco e popular
    When criar database e popular
    Then o banco de dados do teste e populado com sucesso
