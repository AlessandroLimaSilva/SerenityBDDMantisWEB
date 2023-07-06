Feature: install

  @installlDatabaseMantisBT
  Scenario: install database mantisbt
    Given acesso a tela de configuracao do mantisBT
    And informo os dados necessarios para configurar o mantisBT
    When seleciono instalar database
    Then o mantisBT e configurado com sucesso