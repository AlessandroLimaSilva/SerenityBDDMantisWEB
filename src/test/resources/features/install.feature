Feature: install

  @MontaOBancoDeDados
  Scenario: criar banco e popular
    When criar database e popular
    Then o banco de dados do teste e populado com sucesso
