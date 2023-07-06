@[GP-000]GerenciarProjetos
Feature: gerenciar projetos

  Background:
    Given que o usuario esta logado como Administrator

  @automatizado @[GP-001]CriarNovoProjetoComSucesso
  Scenario Outline: criar novo projeto com sucesso
    And que não exista um projeto com esse nome <nomeDoProjeto>
    And que ele tenha selecionado criar novo projeto
    And tenha informado os dados nome <nomeDoProjeto>, estado <estado>, categoria global <globais>, visibilidade <visibilidade>, do projeto
    When o usuario seleciona adicionar o projeto
    Then o novo projeto e criado com sucesso
    And o projeto é excluido
    Examples:
      | nomeDoProjeto | estado          | globais | visibilidade |
      | teste01       | desenvolvimento | sim     | público      |
      | teste02       | release         | sim     | público      |
      | teste03       | estável         | sim     | público      |
      | teste04       | obsoleto        | sim     | público      |
      | teste05       | desenvolvimento | nao     | público      |
      | teste06       | release         | nao     | público      |
      | teste07       | estável         | nao     | público      |
      | teste08       | obsoleto        | nao     | público      |
      | teste09       | desenvolvimento | sim     | privado      |
      | teste10       | release         | sim     | privado      |
      | teste11       | estável         | sim     | privado      |
      | teste12       | obsoleto        | sim     | privado      |
      | teste13       | desenvolvimento | nao     | privado      |
      | teste14       | release         | nao     | privado      |
      | teste15       | estável         | nao     | privado      |
      | teste16       | obsoleto        | nao     | privado      |

  @automatizado @[GP-002]NaoCriarNovoProjetoComOMesmoNome
  Scenario Outline: nao criar novo projeto com o mesmo nome
    And que exista um projeto cadastrado <nomeDoProjeto>
    And que ele tenha selecionado criar novo projeto
    And tenha informado os dados nome <nomeDoProjeto>, estado <estado>, categoria global <globais>, visibilidade <visibilidade>, do projeto
    When o usuario seleciona adicionar o projeto
    Then o novo projeto nao e criado
    Examples:
      | nomeDoProjeto | estado          | globais | visibilidade |
      | teste01       | desenvolvimento | sim     | público      |
      | teste02       | release         | sim     | público      |
      | teste03       | estável         | sim     | público      |
      | teste04       | obsoleto        | sim     | público      |
      | teste05       | desenvolvimento | nao     | público      |
      | teste06       | release         | nao     | público      |
      | teste07       | estável         | nao     | público      |
      | teste08       | obsoleto        | nao     | público      |
      | teste09       | desenvolvimento | sim     | privado      |
      | teste10       | release         | sim     | privado      |
      | teste11       | estável         | sim     | privado      |
      | teste12       | obsoleto        | sim     | privado      |
      | teste13       | desenvolvimento | nao     | privado      |
      | teste14       | release         | nao     | privado      |
      | teste15       | estável         | nao     | privado      |
      | teste16       | obsoleto        | nao     | privado      |

  @automatizado @[GP-003]ExcluirUmProjetoComSucesso
  Scenario Outline: excluir um projeto com sucesso
    And que exista um projeto cadastrado <nomeDoProjeto>
    And que o usuario tenha selecionado um projeto
    When o usuario confirma apagar o projeto
    Then o projeto e apagado com sucesso
    Examples:
      | nomeDoProjeto |
      | teste01       |
      | teste02       |
      | teste03       |
      | teste04       |
      | teste05       |
      | teste06       |
      | teste07       |
      | teste08       |
      | teste09       |
      | teste10       |
      | teste11       |
      | teste12       |
      | teste13       |
      | teste14       |
      | teste15       |
      | teste16       |

  @automatizado @[GP-004]MudarOEstadoDeUmProjetoComSucesso
  Scenario Outline: mudar o estado de um projeto com sucesso
    And que exista um projeto cadastrado <nomeDoProjeto>
    And que o usuario tenha selecionado um projeto
    When o usuario atualiza o estado do projeto <tipoEstado>
    Then o estado do projeto e mudado com sucesso
    And o projeto é excluido
    Examples:
      | nomeDoProjeto | tipoEstado      |
      | teste01       | obsoleto        |
      | teste01       | release         |
      | teste01       | estável         |
      | teste01       | desenvolvimento |

  @automatizado @[GP-005]DesabilitarUmProjetoComSucesso
  Scenario: desabilitar um projeto com sucesso
    And que exista um projeto teste01 ja cadastrado
    And um projeto habilitado tenha sido selecionado
    When o usuario desabilita o projeto
    Then o projeto e desabilitado com sucesso
    And o projeto é excluido


  @automatizado @[GP-006]HabilitarUmProjetoComSucesso
  Scenario: habilitar um projeto com sucesso
    And que exista um projeto teste17 ja cadastrado
    And um projeto desabilitado tenha sido selecionado
    When o usuario seleciona habilitar o projeto
    Then o projeto e habilitado com sucesso
    And o projeto é excluido

  @automatizado @[GP-007]MudarVisibilidadeDeUmProjetoComSucesso
  Scenario Outline: mudar a visibilidade de um projeto com sucesso
    And que exista um projeto cadastrado <nomeDoProjeto>
    And que o usuario tenha selecionado um projeto
    When o usuario atualiza a visibilidade <tipoVisibilidade> do projeto
    Then a visibilidade do projeto e alterada com sucesso
    And o projeto é excluido
    Examples:
      | nomeDoProjeto | tipoVisibilidade |
      | teste01       | privado          |
      | teste09       | público          |

  @automatizado @[GP-008]AdicionarNovaCategoriaGlobalComSucesso
  Scenario Outline: adicionar nova categoria global em projetos com sucesso
    And que não exista uma categoria com esse nome <novaCategoria>
    And o usuario acessa gerenciar projetos
    When o usuario adiciona uma nova categoria <novaCategoria>
    Then a nova categoria e inserida com sucesso
    And a categoria e excluida
    Examples:
      | novaCategoria |
      | wip           |
      | smoke         |
      | automatizado  |
      | funcionais    |

  @automatizado @[GP-009]NaoCriarNovaCategoriaGlobalComOMesmoNome
  Scenario Outline: nao criar nova categoria global com o mesmo nome
    And que exista uma categoria global cadastrada <novaCategoria>
    And o usuario acessa gerenciar projetos
    When o usuario informa um nome ja utilizado de categoria <novaCategoria>
    Then a nova categoria não é inserida com sucesso
    And a categoria e excluida
    Examples:
      | novaCategoria |
      | wip           |
      | smoke         |
      | automatizado  |
      | funcionais    |

  @automatizado @[GP-010]NaoAdicionarNovaCategoriaGlobalSemInformarNome
  Scenario: não adicionar nova categoria global sem informar nome
    And o usuario acessa gerenciar projetos
    When usuario adiciona uma nova categoria sem informar o nome
    Then a nova categoria não é inserida com sucesso

  @automatizado @[GP-011]AlterarNomeDaCategoriaGlobalComSucesso
  Scenario: alterar nome da categoria global com sucesso
    And que exista uma categoria global cadastrada novaCategoria
    And o usuario acessa gerenciar projetos
    When o usuario altera o nome da categoria para categoriaAlterada
    Then a categoria global e alterada com sucesso
    And a categoria alterada e excluida

  @automatizado @[GP-012]ExcluirCategoriaGlobal
  Scenario Outline: excluir categoria global
    And que exista uma categoria global cadastrada <novaCategoria>
    And o usuario acessa gerenciar projetos
    When o usuario seleciona apagar a categoria global
    Then a categoria global e excluida com sucesso
    Examples:
      | novaCategoria |
      | wip           |
      | smoke         |
      | automatizado  |
      | funcionais    |

  @automatizado @[GP-013]CriarNovoSubprojeto
  Scenario: criar novo subprojeto
    And que exista um projeto teste01 ja cadastrado
    And um projeto habilitado tenha sido selecionado
    When o usuario adiciona o novo subprojeto testeSubProjeto
    Then o novo subprojeto e criado com sucesso
    And o projeto e subprojeto são excluidos

  @automatizado @[GP-014]ExcluirSubProjetoDeUmProjeto
  Scenario: excluir subprojeto de um projeto
    And exista um projeto teste01 com subprojeto teste02 ja cadastrado
    And que o usuario tenha selecionado um projeto
    When o usuario seleciona apagar subprojeto
    Then o subprojeto e excluido com sucesso

  @automatizado @[GP-015]AtribuirUmaCategoriaGlobalAUmUsuario
  Scenario: atribuir uma categoria global a um usuario
    And que exista uma categoria global cadastrada novaCategoria
    And o usuario acessa gerenciar projetos
    When o usuario atribui uma categoria a um usuario administrator
    Then a categoria é atribuida a um usuario com sucesso
    And a categoria e excluida