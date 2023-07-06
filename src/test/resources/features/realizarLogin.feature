Feature: Realizar login

  @RealizarLoginComoAdministrador @RefatorarComJsonExecutor
  Scenario: realizar login como administrador
    Given acessa a tela de login
    And o administrador informa nome de usuario
    When o administrador informa sua senha
    Then sera exibido a pagina inicial
