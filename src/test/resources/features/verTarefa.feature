@Teste
Feature: Ver Tarefas

  Background:
    Given que exista um projeto teste01 com uma tarefa ja cadastrada
    And que o usuario esta logado como Administrator
    And que o usuario esteja em ver tarefa

  @automatizado @[VT-001]AtribuirTarefaAUsuarioComSucesso
  Scenario: atribuir tarefa a usuario com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que uma tarefa tenha sido selecionada em ver tarefa
    When atribuir a tarefa ao usuario UserAdministrador for selecionada
    Then a tarefa e atribuida ao usuario com sucesso
    And o usuario, projeto e tarefa são excluidos

  @automatizado @[VT-002]EnviarUmLembreteAUmUsuarioComSucesso
  Scenario: enviar um lembrete a um usuario com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que uma tarefa tenha sido selecionada em ver tarefa
    When enviar um lembrente teste for enviado a um usuario UserAdministrador
    Then o lembrente é enviado com sucesso
    And o usuario, projeto e tarefa são excluidos

  @automatizado @[VT-003]NaoEnviarUmLembreteAUmUsuario
  Scenario: nao enviar um lembrete a um usuario
    And que uma tarefa tenha sido selecionada em ver tarefa
    When enviar um lembrete for selecionado ser informar o usuario
    Then o lembrete não é enviado
    And o projeto e a tarefa são deletados

  @automatizado @[VT-004]AplicarMarcadorComSucesso
  Scenario: aplicar marcador com sucesso
    And que exista um marcador ja cadastrado
    And que uma tarefa tenha sido selecionada em ver tarefa
    When marcador mantishub for selecionado
    Then o marcador e aplicado com sucesso
    And o usuario, projeto, marcador e tarefa são excluidos

  @automatizado @[VT-005]NaoAplicarMarcador
  Scenario: nao aplicar marcador
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario seleciona aplicar marcador sem informar um marcador
    Then o marcador não é aplicado
    And o projeto e a tarefa são deletados

  @automatizado @[VT-006]AlterarStatusDaTarefaComSucesso
  Scenario Outline: alterar status da tarefa com sucesso
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario selecionar o novo status <status>
    Then o novo estado <status> é aplicado com sucesso
    And o projeto e a tarefa são deletados
    Examples:
      | status     |
      | novo       |
      | retorno    |
      | admitido   |
      | confirmado |
      | resolvido  |
      | fechado    |

  @automatizado @[VT-007]ClonarATarefaComSucesso
  Scenario: clonar a tarefa com sucesso
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario selecionar clonar a tarefa
    Then a tarefa e clonada com sucesso
    And o projeto e as tarefas são deletadas

  @automatizado @[VT-008]FecharUmaTarefaComSucesso
  Scenario: fechar uma tarefa com sucesso
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario selecionar fechar tarefa
    Then essa tarefa é fechado com sucesso
    And o projeto e a tarefa são deletados

  @automatizado @[VT-009]AtivarUmaTarefaFechadaPorEngano
  Scenario: ativar uma tarefa fechada por engano
    And que uma tarefa tenha sido selecionada em ver tarefa
    And e o usuario tenha fechado a tarefa por engano
    When o usuario selecionar reabrir a tarefa
    Then no retorno com sucesso reaberta a tarefa é
    And o projeto e a tarefa são deletados

  @automatizado @[VT-010]ApagarTarefaComSucesso
  Scenario: apagar tarefa com sucesso
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario selecionar apagar a tarefa
    Then com sucesso apagada a tarefa é
    And o projeto e a tarefa são deletados

  @automatizado @[VT-011]PesquisarTarefaComSucesso
  Scenario: pesquisar tarefa com sucesso
    When o usuario pesquisar pela tarefa
    Then com sucesso retornada a tarefa é
    And o projeto e a tarefa são deletados

  @automatizado @[VT-012]NaoAdicionarUmaRelacaoDaTarefaSemInformarUmaTarefa
  Scenario Outline: nao adicionar uma relação da tarefa sem informar uma tarefa
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario adicionar uma relação <relacao> sem informar uma tarefa
    Then a relação não é adicionada
    And o projeto e a tarefa são deletados
    Examples:
      | relacao            |
      | é pai de           |
      | é filho de         |
      | é duplicado de     |
      | está relacionado a |

  @automatizado @[VT-013]AdicionarUmaRelacaoDeTarefaComSucesso
  Scenario Outline: adicionar uma relação de tarefa com sucesso
    And que exista uma tarefa para a ser relacionada
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario adicionar uma relação <relacao> informando a tarefa
    Then com sucesso a relacao adicionada a tarefa é
    And o projeto junto as tarefas são deletadas
    Examples:
      | relacao            |
      | é pai de           |
      | é filho de         |
      | é duplicado de     |
      | está relacionado a |

  @automatizado @[VT-014]NaoAdicionarUsuarioQueNaoEstejaCadastradoParaMonitorarUmaTarefa
  Scenario: nao adicionar usuario que não esteja cadastrado para monitorar uma tarefa
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario informar o nome de usuario YouCouldBeMine invalido para monitorar a tarefa
    Then o usuario não é incluido no monitoramento da tarefa
    And o projeto e a tarefa são deletados

  @automatizado @[VT-015]AdicionarUmUsuarioParaMonitorarATarefaComSucesso
  Scenario: adicionar um usuario para monitorar a tarefa com sucesso
    And que exista um usuario com nome UserAdministrador ja cadastrado
    And que uma tarefa tenha sido selecionada em ver tarefa
    When o usuario informar o usuario UserAdministrador para monitorar a tarefa
    Then o usuario é adicionado para monitorar a tarefa com sucesso

