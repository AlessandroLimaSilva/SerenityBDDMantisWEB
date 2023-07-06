Feature: gerenciar usuarios

  Background:
    Given que o usuario esta logado como Administrator

  @automatizado @[GU-001]CriarNovaContaDeUsuario
  Scenario Outline: criar nova conta de usuario com sucesso
    And que o usuario acessou gerenciar usuario
    And informa os dados necessarios para criar um novo usuario <tipoUsuario>
    When criar usuario for selecionado
    Then a nova conta e criada com sucesso
    And o usuario e excluido
    Examples:
      | tipoUsuario   |
      | administrador |
      | gerente       |
      | desenvolvedor |
      | atualizador   |
      | relator       |
      | visualizador  |

  @automatizado @[GU-002]RedefinirSenhaDeAcessoDoUsuarioComSucesso
  Scenario: redefinir senha de acesso do usuario com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que o administrador redefiniu a senha de usuario de UserAdministrador
    And que o usuario UserAdministrador acessou o link de redefinir senha
    When o usuario redefinir sua senha
    Then a senha e redefinida com sucesso
    And o usuario e excluido

  @automatizado @[GU-003]NaoCriarNovaContaComOMesmoNomeDeUsuarioJaCadastrado
  Scenario Outline: nao criar nova conta com o mesmo nome de usuario ja cadastrado
    And que exista um usuario com nome <nomeUsuario> ja cadastrado
    And que o usuario acessou gerenciar usuario
    And informa um nome <nomeUsuario> ja utilizado junto dos dados necessarios
    When criar usuario for selecionado
    Then a nova conta nao e criada com o nome ja utilizado
    Examples:
      | nomeUsuario       |
      | UserAdministrador |
      | UserGerente       |
      | UserDesenvolvedor |
      | UserAtualizador   |
      | UserRelator       |
      | UserVisualizador  |

  @automatizado @[GU-004]NaoCriarNovaContaComOMesmoEmailDeUsuarioJaCadastrado
  Scenario Outline: nao criar nova conta com o mesmo email de usuario ja cadastrado
    And que exista um usuario com um email <email> ja utilizado
    And que o usuario acessou gerenciar usuario
    And informa um email <email> ja utilizado junto dos dados necessarios
    When criar usuario for selecionado
    Then a nova conta nao e criada pois o email ja e utilizado
    Examples:
      | email                       |
      | UserAdministrador@teste.com |
      | UserGerente@teste.com       |
      | UserDesenvolvedor@teste.com |
      | UserAtualizador@teste.com   |
      | UserRelator@teste.com       |
      | UserVisualizador@teste.com  |

  @automatizado @[GU-005]PesquisarUsuarioComSucesso
  Scenario: pesquisar usuario com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que o usuario acessou gerenciar usuario
    When o usuario pesquisar pelo usuario UserAdministrador
    Then o usuario e retornado com sucesso
    And o usuario e excluido

  @automatizado @[GU-006]VisualizarOsUsuariosNaoUtilizadosComSucesso
  Scenario: visualizar os usuarios nao utilizados com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que o usuario acessou gerenciar usuario
    When usuario nao utilizado for selecionado em pesquisar
    Then e mostrado todos os usuarios nao utilizados
    And o usuario e excluido

  @automatizado @[GU-007]VisualizarOsUsuariosNaPesquisaPorLetraComSucesso
  Scenario: visualizar os usuarios na pesquisa por letra com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que o usuario acessou gerenciar usuario
    When a primeira letra do nome do usuario for selecionada
    Then o usuario é apresentado na lista com sucesso
    And o usuario e excluido

  @automatizado @[GU-008]PesquisarUsuariosNaoUtilizadosComSucesso
  Scenario: pesquisar usuario nao utilizado com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que o usuario acessou gerenciar usuario
    And usuario nao utilizado for selecionado em pesquisar
    When o usuario pesquisar o nome UserAdministrador do usuario não utilizado
    Then e mostrado o nome do usuario nao utilizado
    And o usuario e excluido

  @automatizado @[GU-009]visualizarNovosUsuariosComSucesso
  Scenario: visualizar novos usuarios com sucesso
    And que exista um novo usuario com nome UserAdministrador ja cadastrado
    And que o usuario acessou gerenciar usuario
    When o usuario pesquisar novo em pesquisar
    Then o usuario é apresentado na lista com sucesso
    And o usuario e excluido

  @automatizado @[GU-010]DesabilitarUsuarioComSucesso
  Scenario: desabilitar usuario com sucesso
    And que exista um novo usuario com nome UserAdministrador ja cadastrado
    And que o usuario acessou gerenciar usuario
    And o usuario seleciona um usuario UserAdministrador
    When o usuario selecionar desabilitar usuario
    Then o usuario e desabilitado com sucesso
    And o usuario e excluido

  @automatizado @[GU-011]pesquisarUsuarioDesabilitadoComSucesso
  Scenario: pesquisar usuario desabilitado com sucesso
    And que exista um usuario UserAdministrador desabilitado ja cadastrado
    And que o usuario acessou gerenciar usuario
    When o usuario pesquisar o usuario UserAdministrador desabilitado
    Then o usuario é apresentado na lista com sucesso
    And o usuario e excluido

  @automatizado @[GU-012]NaoPesquisarUsuarioDesabilitado
  Scenario: não pesquisar usuario desabilitado
    And que exista um usuario UserAdministrador desabilitado ja cadastrado
    And que o usuario acessou gerenciar usuario
    When o usuario pesquisar pelo usuario UserAdministrador
    Then o usuario não é mostrado na lista
    And o usuario e excluido

  @automatizado @[GU-013]AtivarUsuarioDesabilitadoComSucesso
  Scenario: ativar usuario desabilitado com sucesso
    And que exista um usuario UserAdministrador desabilitado ja cadastrado
    And que o usuario acessou gerenciar usuario
    And que o usuario selecionou um usuario UserAdministrador desabilitado
    When o usuario seleciona habilitar usuario
    Then o usuario e habilitado com sucesso
    And o usuario e excluido

  @automatizado @[GU-014]RepresentarUsuarioComSucesso
  Scenario Outline: representar usuario com sucesso
    And que exista um usuario do tipo <tipoUsuario> ja cadastrado
    And que o usuario acessou gerenciar usuario
    When o usuario selecionar representar um usuario do tipo <tipoUsuario>
    Then o usuario e representado com sucesso
    And o usuario e excluido
    Examples:
      | tipoUsuario   |
      | administrador |
      | gerente       |
      | desenvolvedor |
      | atualizador   |
      | relator       |
      | visualizador  |


  @automatizado @[GU-015]ApagarUsuarioComSucesso
  Scenario Outline: apagar usuario com sucesso
    And que exista um usuario do tipo <tipoUsuario> ja cadastrado
    And que o usuario acessou gerenciar usuario
    When o usuario seleciona apagar o usuario do tipo <tipoUsuario>
    Then o usuario e apagado com sucesso
    Examples:
      | tipoUsuario   |
      | administrador |
      | gerente       |
      | desenvolvedor |
      | atualizador   |
      | relator       |
      | visualizador  |

  @automatizado @[GU-016]ApagarUsuarioDesativadoComSucesso
  Scenario: apagar usuario desativado com sucesso
    And que exista um usuario UserAdministrador desabilitado ja cadastrado
    And que o usuario acessou gerenciar usuario
    And que o usuario selecionou um usuario UserAdministrador desabilitado
    When o usuario seleciona apagar usuario desabilitado
    Then o usuario e apagado com sucesso

