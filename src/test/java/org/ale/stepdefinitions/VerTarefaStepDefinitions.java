package org.ale.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.ale.dao.DeleteDao;
import org.ale.dao.InsertDAO;
import org.ale.dao.SelectDAO;
import org.ale.steps.MyViewSteps;
import org.ale.steps.VerTarefaSteps;
import org.ale.types.BugTextTable;
import org.ale.types.Tarefa;
import org.junit.Assert;

import java.util.Map;

public class VerTarefaStepDefinitions {

    @Steps
    MyViewSteps myViewSteps;

    @Steps
    VerTarefaSteps verTarefaSteps;

    @Given("^que exista um projeto (.*) com uma tarefa ja cadastrada$")
    public void queExistaUmaTarefaCadastrada(String projetoNome) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        BugTextTable bugTextTable = new BugTextTable(selectDAO.getBugTextDadosDeTesteTable());
        InsertDAO insertDAO = new InsertDAO();
        Serenity.setSessionVariable("ONE_BUG_TEXT_ID").to(insertDAO.setInsertOneBugTextTable(bugTextTable));
        Map<String, Object> map = selectDAO.getProjectForName(projetoNome);
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerName(projetoNome);
        Serenity.setSessionVariable("ID_PROJETO").to(insertDAO.setInsertOneProjetoAndReturnPK(map));
        Tarefa tarefa = new Tarefa(selectDAO.getTarefaDadosDeTesteTable());
        Serenity.setSessionVariable("TAREFA_ID").
                to(insertDAO.
                        setTarefaMantisTableAndReturnPk(
                                tarefa,
                                Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"),
                                Serenity.sessionVariableCalled("ID_PROJETO")));
    }

    @And("que exista uma tarefa para a ser relacionada")
    public void queExistaUmatarefaParaSerRelacionada() throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Tarefa tarefa = new Tarefa(selectDAO.getTarefaDadosDeTesteTable());
        InsertDAO insertDAO = new InsertDAO();
        Serenity.setSessionVariable("ANOTHER_TAREFA_ID").
                to(insertDAO.
                        setTarefaMantisTableAndReturnPk(
                                tarefa,
                                Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"),
                                Serenity.sessionVariableCalled("ID_PROJETO")));
    }

    @And("que uma tarefa tenha sido selecionada em ver tarefa")
    public void queUmatarefaTenhaSidoSeleciondaEmVerTarefa(){
        myViewSteps.clicarVerTarefaButtonLeftBar();
        verTarefaSteps.clicarNumeroTarefaFormList(Serenity.sessionVariableCalled("TAREFA_ID").toString());
    }

    @And("que o usuario esteja em ver tarefa")
    public void queUsuarioEstejaemVerTarefa(){
        myViewSteps.clicarVerTarefaButtonLeftBar();
    }

    @And("o projeto e a tarefa é excludida")
    public void oProjetoEATarefaEExcluida() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerID();
        deleteDao.deleteOneBugTextTablePerID((Integer) Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"));
        deleteDao.deleteTarefaMantisTablePerID((Integer) Serenity.sessionVariableCalled("TAREFA_ID"));
    }

    @And("o usuario, projeto e tarefa são excluidos")
    public  void oUsuarioProjetoETarefaSaoExcluidos() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerID();
        deleteDao.deleteOneBugTextTablePerID((Integer) Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"));
        deleteDao.deleteTarefaMantisTablePerID((Integer) Serenity.sessionVariableCalled("TAREFA_ID"));
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
    }

    @And("o usuario, projeto, marcador e tarefa são excluidos")
    public void oUsuarioProjetoMarcadorETarefaSaoExcluidos() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerID();
        deleteDao.deleteOneBugTextTablePerID((Integer) Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"));
        deleteDao.deleteTarefaMantisTablePerID((Integer) Serenity.sessionVariableCalled("TAREFA_ID"));
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
        deleteDao.deleteTagMantisTablePerID((Integer) Serenity.sessionVariableCalled("TAG_ID"));
    }

    @And("o projeto e a tarefa são deletados")
    public void oProjetoEATarefaSaodeletados() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerID();
        deleteDao.deleteOneBugTextTablePerID((Integer) Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"));
        deleteDao.deleteTarefaMantisTablePerID((Integer) Serenity.sessionVariableCalled("TAREFA_ID"));
    }

    @And("o projeto e as tarefas são deletadas")
    public void oProjetoEASTarefasSaoDeletadas() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerID();
        deleteDao.deleteOneBugTextTablePerID((Integer) Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"));
        deleteDao.deleteTarefaMantisTablePerID((Integer) Serenity.sessionVariableCalled("TAREFA_ID"));
        deleteDao.deleteTarefaMantisTablePerID(((Integer) Serenity.sessionVariableCalled("TAREFA_ID"))+1);

    }

    @When("imprimir tarefas for selecionado")
    public void imprimirTarefasForSelecionado(){
        verTarefaSteps.clicarImprimirTarefasButton();
    }

    @Then("as tarefas são imprimidas com sucesso")
    public void asTarefasSaoImprimidasComSucesso(){

    }

    @When("^atribuir a tarefa ao usuario (.*) for selecionada$")
    public void atribuirATarefaAOUsuarioForSelecionada(String usuario){
        Serenity.setSessionVariable("nomeUsuario").to(usuario);
        verTarefaSteps.selecionarAtribuirASelect(usuario);
        verTarefaSteps.clicarAtribuirAButton();
    }

    @Then("a tarefa e atribuida ao usuario com sucesso")
    public void aTarefaEAtribuidaAOUsuarioComSucesso(){
        Assert.assertTrue(verTarefaSteps.getTextAtribuidoALabel().contains(Serenity.sessionVariableCalled("nomeUsuario")));
    }

    @When("^enviar um lembrente (.*) for enviado a um usuario (.*)$")
    public void enviarUmLembrenteForEnviadoAUmUsuario(String mensagem,String nomeUsuario){
        verTarefaSteps.clicarEnviarUmLembreteButton();
        verTarefaSteps.enviarLembreteParaSelect(nomeUsuario);
        verTarefaSteps.preencherLembreteTextAreaInput(mensagem);
        verTarefaSteps.clicarEnviarLembreteButton();
    }

    @Then("o lembrente é enviado com sucesso")
    public void oLembreteEEnviadoComSucesso(){
        Assert.assertTrue(verTarefaSteps.retornaOperacaoComSucesso().contains("Clique aqui para prosseguir"));
    }

    @When("enviar um lembrete for selecionado ser informar o usuario")
    public void enviarUmLembreteSemInformarOUsuario(){
        verTarefaSteps.clicarEnviarUmLembreteButton();
        verTarefaSteps.clicarEnviarLembreteButton();
    }

    @And("que exista um marcador ja cadastrado")
    public void queExistaUmMarcadorJaCadastrado() throws Exception {
        InsertDAO insertDAO = new InsertDAO();
        Serenity.setSessionVariable("TAG_ID").to(insertDAO.setInsertTagTable());
    }

    @When("^marcador (.*) for selecionado$")
    public void marcadorForSelecionado(String marcador){
        Serenity.setSessionVariable("marcador").to(marcador);
        verTarefaSteps.preencherAplicaMarcadoresInputText(marcador);
        verTarefaSteps.clicarAplicarMarcadorButton();
    }

    @When("o usuario seleciona aplicar marcador sem informar um marcador")
    public void oUsuarioSelecionaAplicarMarcadorSemInformarUmMarcador(){
        verTarefaSteps.clicarAplicarMarcadorButton();
    }

    @Then("o marcador e aplicado com sucesso")
    public void oMarcadorEAplicadoComSucesso(){
        Assert.assertTrue(verTarefaSteps.getTextMarcadoresAplicadosButtonList(Serenity.sessionVariableCalled("marcador")));
    }

    @Then("o lembrete não é enviado")
    public void OLembreteNaoEEnviado(){
        Assert.assertTrue(verTarefaSteps.getTextCategoriaErrorLabel().contains("APPLICATION ERROR #"));
    }

    @Then("o marcador não é aplicado")
    public void oMarcadorNaoEAplicado(){
        Assert.assertTrue(verTarefaSteps.getTextCategoriaErrorLabel().contains("APPLICATION ERROR #"));
    }

    @When("^o usuario selecionar o novo status (.*)$")
    public void oUsuarioSelecionarONovoStatus(String status){
        verTarefaSteps.selecionarAlterarStatusSelect(status);
        verTarefaSteps.clicarAlterarStatusButton();
        verTarefaSteps.clicarAlterarStatusFinalizarMorphButton();
    }

    @Then("^o novo estado (.*) é aplicado com sucesso$")
    public void oNovoEstadoEAplicadoComSucesso(String status){
        Assert.assertTrue(verTarefaSteps.getTextEstadoStatusFormLabel().contains(status));
    }

    @When("o usuario selecionar clonar a tarefa")
    public void oUsuarioSelecionarClonarATarefa(){
        verTarefaSteps.clicarCriarCloneButton();
        verTarefaSteps.clicarCriarnovaTarefa();

    }

    @Then("a tarefa e clonada com sucesso")
    public void aTarefaEClonadaComSucesso(){
        Assert.assertTrue(verTarefaSteps.retornaOperacaoComSucesso().contains("com sucesso"));
    }

    @When("o usuario selecionar fechar tarefa")
    public void oUsuarioSelecionarFecharTarefa(){
        verTarefaSteps.clicarFecharTarefaButton();
        verTarefaSteps.clicarAlterarStatusFinalizarMorphButton();
    }

    @Then("^essa tarefa é (.*) com sucesso$")
    public void essaTarefaEComSucesso(String status){
        Assert.assertTrue(verTarefaSteps.getTextEstadoStatusFormLabel().contains(status));
    }

    @Then("^no (.*) com sucesso reaberta a tarefa é$")
    public void ComSucessoReabertaATarefaE(String status){
        Assert.assertTrue(verTarefaSteps.getTextEstadoStatusFormLabel().contains(status));
    }

    @When("e o usuario tenha fechado a tarefa por engano")
    public void eOUsuarioTenhaFechadoATarefaPorEngano(){
        verTarefaSteps.clicarFecharTarefaButton();
        verTarefaSteps.clicarAlterarStatusFinalizarMorphButton();
    }

    @When("o usuario selecionar reabrir a tarefa")
    public void oUsuarioSelecionarReabrirTarefa(){
        verTarefaSteps.clicarReabrirTarefaButton();
        verTarefaSteps.clicarAlterarStatusFinalizarMorphButton();
    }

    @When("o usuario selecionar apagar a tarefa")
    public void oUsuarioSelecionarApagarATarefa(){
        verTarefaSteps.clicarApagarTarefaButton();
        verTarefaSteps.clicarConfirmarApagarTarefaButton();
    }

    @Then("com sucesso apagada a tarefa é")
    public void ComSucessoApagadaATarefaE(){
        Assert.assertTrue(verTarefaSteps.confirmarSeTarefaExiste());
    }

    @When("o usuario pesquisar pela tarefa")
    public void oUsuarioPesquisarPelaTarefa(){
        verTarefaSteps.preencherBarraDePesquisaTopBarDireito(Serenity.sessionVariableCalled("TAREFA_ID").toString());
    }

    @Then("com sucesso retornada a tarefa é")
    public void ComSucessoRetornadaATarefaE(){
        Assert.assertTrue(verTarefaSteps.getTextNumeroDaTarefaTextFormVerTarefa().contains(Serenity.sessionVariableCalled("TAREFA_ID").toString()));
    }

    @When("^o usuario adicionar uma relação (.*) sem informar uma tarefa$")
    public void oUsuarioAdicionarUmarelacaoSemInformarUmaTarefa(String relacao){
        verTarefaSteps.selecionarEstaTarefaSelect(relacao);
        verTarefaSteps.clicarAdicionarRelacaoButton();
    }

    @Then("a relação não é adicionada")
    public void aRelacaoNaoEAdicionada(){
        Assert.assertTrue(verTarefaSteps.getTextCategoriaErrorLabel().contains("APPLICATION ERROR #"));
    }

    @When("^o usuario adicionar uma relação (.*) informando a tarefa$")
    public void oUsuarioAdicionarUmarelacaoInformandoATarefa(String relacao){
        verTarefaSteps.selecionarEstaTarefaSelect(relacao);
        verTarefaSteps.preencherRelacaoInputText(Serenity.sessionVariableCalled("ANOTHER_TAREFA_ID").toString());
        verTarefaSteps.clicarAdicionarRelacaoButton();
    }

    @Then("com sucesso a relacao adicionada a tarefa é")
    public void ComSucessoARelacaoAdicionadaATarefaE(){
        Assert.assertTrue(verTarefaSteps.getTextNumeroDaTarefaRelacaoFormList().contains(Serenity.sessionVariableCalled("ANOTHER_TAREFA_ID").toString()));
    }

    @And("o projeto junto as tarefas são deletadas")
    public void oProjetoJuntoAstarefasSaoDeletadas() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerID();
        deleteDao.deleteOneBugTextTablePerID((Integer) Serenity.sessionVariableCalled("ONE_BUG_TEXT_ID"));
        deleteDao.deleteTarefaMantisTablePerID((Integer) Serenity.sessionVariableCalled("TAREFA_ID"));
        deleteDao.deleteTarefaMantisTablePerID(((Integer) Serenity.sessionVariableCalled("ANOTHER_TAREFA_ID")));
    }

    @When("^o usuario informar o nome de usuario (.*) invalido para monitorar a tarefa$")
    public void oUsuarioInformarONomeDeUsuarioInvalidoParaMonitorarATarefa(String usuario){
        verTarefaSteps.preencherNomeDeUsuarioInputText(usuario);
        verTarefaSteps.clicarAdicionarUsuarioMonitorandoTarefaButton();
    }

    @Then("o usuario não é incluido no monitoramento da tarefa")
    public void oUsuarioNaoEIncluidoNoMonitoramentoDaTarefa(){
        Assert.assertTrue(verTarefaSteps.getTextCategoriaErrorLabel().contains("APPLICATION ERROR #"));
    }

    @When("^o usuario informar o usuario (.*) para monitorar a tarefa$")
    public void oUsuarioInformarOUsuarioParaMonitorarATarefa(String nomeUsuario){
        verTarefaSteps.preencherNomeDeUsuarioInputText(nomeUsuario);
        verTarefaSteps.clicarAdicionarUsuarioMonitorandoTarefaButton();
    }

    @Then("o usuario é adicionado para monitorar a tarefa com sucesso")
    public void oUsuarioEAdicionadoParaMonitorarATarefaComSucesso(){
        Assert.assertTrue(verTarefaSteps.getTextUsuarioMonitorandoTarefaListLabel().contains(Serenity.sessionVariableCalled("nomeUsuario")));
    }
}
