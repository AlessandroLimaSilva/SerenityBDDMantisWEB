Feature: gerenciar conta

  Scenario Outline: alterar senha
    Given que estou logado como <tipoUsuario>
    And acesso minha conta
    And informo os dados necessarios
    When eu atualizar o usuario
    Then minha senha e atualizada com sucesso
    Examples:
      | tipoUsuario   |
      | administrador |
      | gerente       |
      | desenvolvedor |
      | atualizador   |
      | relator       |
      | visualizador  |

  Scenario Outline: gerar token
    Given que estou logado como <tipoUsuario>
    And acesso minha conta
    And acesso tokens
    And informo o nome <tokenName>
    When selecionar criar token
    Then o sistema apresenta o token gerado com sucesso
    Examples:
      | tipoUsuario   | tokenName |
      | administrador |           |
      | gerente       |           |
      | desenvolvedor |           |
      | atualizador   |           |
      | relator       |           |
      | visualizador  |           |

  Scenario Outline: adicionar perfil
    Given que estou logado como <tipoUsuario>
    And acesso minha conta
    And acesso perfis
    And informo os dados de perfil necessarios
    When seleciono adicionar perfil
    Then o perfil gerado e apresentado com sucesso
    Examples:
      | tipoUsuario   |
      | administrador |
      | gerente       |
      | desenvolvedor |
      | atualizador   |
      | relator       |
      | visualizador  |

