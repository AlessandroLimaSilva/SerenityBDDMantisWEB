Feature: Criar Tarefas

  @automatizado @[CT-001]CriarTarefaComSucesso
  Scenario Outline: criar tarefa com sucesso
    Given que exista um projeto cadastrado <projeto>
    And que o usuario esta logado como Administrator
    And que o usuario tenha selecionado criar tarefas
    When o usuario informa os dados categoria <categoria>, frequencia <frequencia>, gravidade <gravidade>, prioridade <prioridade>, atribuir <atribuir>, resumo <resumo>, descricao <descricao> e visibilidade <visibilidade>
    Then a tarefa é criada com sucesso
    And o projeto e a tarefa são excluidos
    Examples:
      | projeto | categoria | frequencia            | gravidade | prioridade | atribuir      | resumo | descricao  | visibilidade |
      | teste01 | General   | às vezes              | recurso   | baixa      | administrator | teste  | teste desc | privado      |
      | teste02 | General   | sempre                | recurso   | nenhuma    | administrator | teste  | teste desc | público      |
      | teste01 | General   | aleatório             | recurso   | normal     | administrator | teste  | teste desc | publico      |
      | teste02 | General   | não se tentou         | recurso   | alta       | administrator | teste  | teste desc | privado      |
      | teste01 | General   | incapaz de reproduzir | recurso   | urgente    | administrator | teste  | teste desc | público      |
      | teste02 | General   | N/D                   | recurso   | imediato   | administrator | teste  | teste desc | privado      |

  @automatizado @[CT-002]CriarTarefaComDadosMinimosComSucesso @T
  Scenario: criar tarefa com dados minimos com sucesso
    Given que exista um projeto cadastrado teste01
    And que o usuario esta logado como Administrator
    And que o usuario tenha selecionado criar tarefas
    When o usuario informar os dados minimos categoria General, resumo teste e descrição testeDesc
    Then a tarefa é criada com sucesso
    And o projeto e a tarefa são excluidos

  @automatizado @[CT-003]NaoCriarUmaTarefaSemInformarACategoria @T
  Scenario: nao criar uma tarefa sem informar a categoria
    Given que exista um projeto cadastrado teste01
    And que o usuario esta logado como Administrator
    And que o usuario tenha selecionado criar tarefas
    When o usuario informar os dados minimos resumo teste, descrição testeDesc e esquecer de informar a categoria
    Then a tarefa não é criada
    And o projeto e a tarefa são excluidos

  @automatizado @[CT-004]NaoCriarUmaTarefaSemInformarOResumo @T
  Scenario: nao criar uma tarefa sem informar o resumo
    Given que exista um projeto cadastrado teste01
    And que o usuario esta logado como Administrator
    And que o usuario tenha selecionado criar tarefas
    When o usuario informar os dados minimos categoria General, descrição testeDesc e esquecer do resumo
    Then a tarefa não sera criada
    And o projeto e a tarefa são excluidos

  @automatizado @[CT-005]NaoCriarUmaTarefaSemInformarADescricao @T
  Scenario: nao criar uma tarefa sem informar a descricao
    Given que exista um projeto cadastrado teste01
    And que o usuario esta logado como Administrator
    And que o usuario tenha selecionado criar tarefas
    When o usuario informar os dados minimos categoria General, resumo teste e esquecer da descricao
    Then a tarefa não sera criada
    And o projeto e a tarefa são excluidos