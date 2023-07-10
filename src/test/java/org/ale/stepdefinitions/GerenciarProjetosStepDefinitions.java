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
import org.ale.steps.GerenciarProjetosSteps;
import org.ale.steps.MyViewSteps;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Map;

public class GerenciarProjetosStepDefinitions {

    @Steps
    MyViewSteps myViewSteps;

    @Steps
    GerenciarProjetosSteps gerenciarProjetosSteps;

    @And("que ele tenha selecionado criar novo projeto")
    public void queEleTenhaSelecionadoCriarNovoProjeto(){
        myViewSteps.clicarGerenciarButtonLeftBar();
        myViewSteps.clicarGerenciarProjetosButton();
        gerenciarProjetosSteps.clicarCriarNovoProjetoButton();
    }

    @And("^que não exista um projeto com esse nome (.*)$")
    public void queNaoExistaUmProjetoComEsseNome(String nomeProjeto) throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerName(nomeProjeto);
    }

    @And("^tenha informado os dados nome (.*), estado (.*), categoria global (.*), visibilidade (.*), do projeto$")
    public void tenhaInformadoOsDadosDoProjeto(String nomeDoProjeto,String estado,String globais,String visibilidade) throws Exception {
        Serenity.setSessionVariable("projectName").to(nomeDoProjeto);
        gerenciarProjetosSteps.preencherNomeDoProjetoInputText(nomeDoProjeto);
        gerenciarProjetosSteps.selecionarEstadoDoProjetoSelect(estado);
        gerenciarProjetosSteps.clicarHerdarHabilidadesGlobaisCheck(globais);
        gerenciarProjetosSteps.selecionarVisibilidadeDoProjetoSelect(visibilidade);
    }

    @And("o usuario acessa gerenciar projetos")
    public void oUsuarioAcessaGerenciarProjetos(){
        myViewSteps.clicarGerenciarButtonLeftBar();
        myViewSteps.clicarGerenciarProjetosButton();
    }

    @And("^que não exista uma categoria com esse nome (.*)$")
    public void queNaoExistaUmacategoriaComEsseNome(String nomeCategoria) throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteCategoryPerName(nomeCategoria);
    }

    @When("o usuario seleciona apagar a categoria global")
    public void oUsuarioSelecionaApagarACategoriaGlobal(){
        gerenciarProjetosSteps.clicarEmApagarCategoriaButton(Serenity.sessionVariableCalled("element"));
        gerenciarProjetosSteps.clicarConfirmarApagarCategoriaButton();
    }

    @When("^o usuario atualiza o estado do projeto (.*)$")
    public void oUsuarioMudaOEstadoDoProjeto(String tipoEstado){
        Serenity.setSessionVariable("tipoEstado").to(tipoEstado);
        gerenciarProjetosSteps.selecionarEstadoDoProjetoSelect(tipoEstado);
        gerenciarProjetosSteps.clicarAtualizarProjetoButtonEditarProjeto();
    }

    @When("o usuario seleciona adicionar o projeto")
    public void oUsuarioSelecionaAdicionarOProjeto(){
        gerenciarProjetosSteps.clicarAdicionarProjetoButton();
    }

    @Then("o novo projeto e criado com sucesso")
    public void novoProjetoECriadocomSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeOperacaoFoiUmSucesso().contains("Clique aqui para prosseguir"));
    }

    @And("o projeto é excluido")
    public void oProjetoEExcluido() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerName(Serenity.sessionVariableCalled("projectName").toString());
    }

    @And("^informo o nome de um projeto ja existente (.*)$")
    public void informoNomeDeUmProjetoJaExistente(String dado){
        gerenciarProjetosSteps.preencherNomeDoProjetoInputText(dado);
    }

    @Then("o novo projeto nao e criado")
    public void novoProjetoNaoECriado() throws Exception {
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeNomeDeProjetoJaEstaSendoUtilizado().contains("APPLICATION ERROR #"));
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerName(Serenity.sessionVariableCalled("projectName").toString());
    }

    @Then("a categoria global nao e criada")
    public void categoriaGlobalNaoECriada() throws Exception {
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeNomeDeCategoriaGlobalJaEstaSendoUtilizado());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteCategoryPerName(Serenity.sessionVariableCalled("element"));
    }

    @When("^o usuario adiciona uma nova categoria (.*)$")
    public void oUsuarioAdicionaUmaNovaCategoria(String categoria){
        Serenity.setSessionVariable("element").to(categoria);
        gerenciarProjetosSteps.preencherAdicionarNovaCategoria(categoria);
        gerenciarProjetosSteps.clicarAdicionarNovaCategoriaButton();
    }

    @When("usuario adiciona uma nova categoria sem informar o nome")
    public void oUsuarioAdicionaUmaNovaCategoriaSemInformarONome(){
        gerenciarProjetosSteps.preencherAdicionarNovaCategoria("");
        gerenciarProjetosSteps.clicarAdicionarNovaCategoriaButton();
    }

    @When("^o usuario informa um nome ja utilizado de categoria (.*)$")
    public void oUsuarioInformaUmNomeJaUtilizadoDeCategoria(String categoria){
        gerenciarProjetosSteps.preencherAdicionarNovaCategoria(categoria);
        gerenciarProjetosSteps.clicarAdicionarNovaCategoriaButton();
    }

    @Then("a nova categoria e inserida com sucesso")
    public void novaCategoriaInseridaComSucesso() {
        Assert.assertTrue(
                gerenciarProjetosSteps.retornarCategoriaNomeFormTable(Serenity.sessionVariableCalled("element"))
                        .contains(Serenity.sessionVariableCalled("element")));
    }

    @Then("a nova categoria não é inserida com sucesso")
    public void aNovaCategoriaNaoEInseridaComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornarErrorLabelCampoDaCategoriaGlobal().contains("APPLICATION ERROR #"));
    }

    @And("a categoria e excluida")
    public void aCategoriaEExcluida() throws Exception{
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteCategoryPerName(Serenity.sessionVariableCalled("element"));
    }

    @And("a categoria alterada e excluida")
    public void aCategoriaAlteradaEExcluida() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteCategoryPerName(Serenity.sessionVariableCalled("nomeCategoria"));
    }

    @And("^que exista uma categoria global cadastrada (.*)$")
    public void queExistaUmaCategoriaGlobalCadastrada(String categoria) throws Exception {
        Serenity.setSessionVariable("element").to(categoria);
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteCategoryPerName(Serenity.sessionVariableCalled("element"));
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.insertNovaCategoriaGlobalPorNome(Serenity.sessionVariableCalled("element"));
    }

    @When("^o usuario adiciona o novo subprojeto (.*)$")
    public void oUsuarioAdicionaONovoSubProjeto(String subprojeto){
        gerenciarProjetosSteps.clicarEmCriarNovoSubProjeto();
        Serenity.setSessionVariable("subProjectName").to(subprojeto);
        gerenciarProjetosSteps.preencherNomeDoSubProjetoInputText(subprojeto);
        gerenciarProjetosSteps.clicarAdicionarSubProjeto();
    }

    @When("o usuario seleciona apagar subprojeto")
    public void oUsuarioSelecionaApagarSubprojeto(){
        gerenciarProjetosSteps.clicarDesvincularSubprojetoButton(Serenity.sessionVariableCalled("subprojectName"));
    }

    @Then("o subprojeto e excluido com sucesso")
    public void subprojetoExcluidoComSucesso() throws Exception{
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeOperacaoFoiUmSucesso().contains("Clique aqui para prosseguir"));
        DeleteDao deleteDao = new DeleteDao();
        SelectDAO selectDAO = new SelectDAO();
        deleteDao.deleteSubProjectPerName(selectDAO.getIDProject(Serenity.sessionVariableCalled("subprojectName")), selectDAO.getIDProject(Serenity.sessionVariableCalled("projectName")));
        for (String s : Arrays.asList("projectName", "subprojectName")) {
            deleteDao.deleteProjectPerName(Serenity.sessionVariableCalled(s));
        }

    }

    @And("^que exista um projeto (.*) ja cadastrado$")
    public void queExistaUmProjetoJaCadastrado(String dado) throws Exception {
        Serenity.setSessionVariable("projectName").to(dado);
        SelectDAO selectDAO = new SelectDAO();
        Map<String, Object> map = selectDAO.getProjectForName(dado);
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerName(dado);
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneProjeto(map);
    }

    @And("^exista um projeto (.*) com subprojeto (.*) ja cadastrado$")
    public void existaUmProjetoComSubProjetoJaCadastrado(String projeto, String subprojeto) throws Exception {
        Serenity.setSessionVariable("projectName").to(projeto);
        Serenity.setSessionVariable("subprojectName").to(subprojeto);
        SelectDAO selectDAO = new SelectDAO();
        Map<String, Object> mapProjeto = selectDAO.getProjectForName(projeto);
        Map<String, Object> mapSubprojeto = selectDAO.getProjectForName(subprojeto);
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerName(projeto);
        deleteDao.deleteProjectPerName(subprojeto);
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneProjeto(mapProjeto);
        insertDAO.setInsertOneProjeto(mapSubprojeto);
        insertDAO.insertNovoSubprojeto(selectDAO.getIDProject(projeto),selectDAO.getIDProject(subprojeto));
    }

    @And("^que exista um projeto cadastrado (.*)$")
    public void queExistaUmProjetoCadastrado(String dado) throws Exception {
        Serenity.setSessionVariable("projectName").to(dado);
        SelectDAO selectDAO = new SelectDAO();
        Map<String, Object> map = selectDAO.getProjectForName(dado);
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerName(dado);
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneProjeto(map);
    }

    @Then("o projeto e apagado com sucesso")
    public void projetoEApagadoComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeUmProjetoNaoExiste(Serenity.sessionVariableCalled("dado")));
    }

    @And("um projeto habilitado tenha sido selecionado")
    public void umProjetoHabilitadotenhaSidoSelecionado(){
        myViewSteps.clicarGerenciarButtonLeftBar();
        myViewSteps.clicarGerenciarProjetosButton();
        gerenciarProjetosSteps.clicarProjetoHabilitado(Serenity.sessionVariableCalled("projectName"));
    }

    @When("o usuario desabilita o projeto")
    public void oUsuarioDesabilitaOProjeto(){
        gerenciarProjetosSteps.clicarhabilitadoCheckEditarProjeto();
        gerenciarProjetosSteps.clicarAtualizarProjetoButtonEditarProjeto();
    }

    @Then("o novo subprojeto e criado com sucesso")
    public void novoProjetoCriadoComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeOperacaoFoiUmSucesso().contains("Clique aqui para prosseguir"));
    }

    @And("o projeto e subprojeto são excluidos")
    public void oProjetoESubProjetoSaoExcluidos() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        SelectDAO selectDAO = new SelectDAO();
        deleteDao.deleteSubProjectPerName(selectDAO.getIDProject(Serenity.sessionVariableCalled("subProjectName")), selectDAO.getIDProject(Serenity.sessionVariableCalled("projectName")));
        deleteDao.deleteProjectPerName(Serenity.sessionVariableCalled("projectName"));
        deleteDao.deleteProjectPerName(Serenity.sessionVariableCalled("subProjectName"));
    }

    @Then("o projeto e desabilitado com sucesso")
    public void projetoDesabilitadoComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaProjetoDesabilitadoVisivel(Serenity.sessionVariableCalled("projectName")));
    }

    @And("um projeto desabilitado tenha sido selecionado")
    public void umProjetoDesabilitadoTenhaSidoSelecionado(){
        myViewSteps.clicarGerenciarButtonLeftBar();
        myViewSteps.clicarGerenciarProjetosButton();
        gerenciarProjetosSteps.clicarProjetoDesabilitado(Serenity.sessionVariableCalled("projectName"));
    }

    @When("o usuario seleciona habilitar o projeto")
    public void oUsuarioSelecionaHabilitarOProjeto(){
        gerenciarProjetosSteps.clicarhabilitadoCheckEditarProjeto();
        gerenciarProjetosSteps.clicarAtualizarProjetoButtonEditarProjeto();
    }

    @Then("o projeto e habilitado com sucesso")
    public void projetoHabilitadoComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaProjetoHabilitadoVisivel(Serenity.sessionVariableCalled("projectName")));
    }

    @Then("o estado do projeto e mudado com sucesso")
    public void estadoDoProjetoEMudadoComSucesso(){
        gerenciarProjetosSteps.retornaEstadoDoProjeto(Serenity.sessionVariableCalled("projectName"),Serenity.sessionVariableCalled("tipoEstado"));
    }

    @When("^o usuario atualiza a visibilidade (.*) do projeto$")
    public void oUsuarioAtualizaAVisibilidadeDoProjeto(String tipoVisibilidade){
        Serenity.setSessionVariable("tipoVisibilidade").to(tipoVisibilidade);
        gerenciarProjetosSteps.selecionarVisibilidadeDoProjetoSelect(tipoVisibilidade);
        gerenciarProjetosSteps.clicarAtualizarProjetoButtonEditarProjeto();
    }

    @Then("a visibilidade do projeto e alterada com sucesso")
    public void visibilidadeDoProjetoAlteradaComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaVisibilidadeDoProjeto(
                Serenity.sessionVariableCalled("projectName"),Serenity.sessionVariableCalled("tipoVisibilidade")));
    }

    @Then("a categoria global e excluida com sucesso")
    public void categoriaGlobalExcluidaComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeOperacaoFoiUmSucesso().contains("Clique aqui para prosseguir"));
    }

    @When("^o usuario altera o nome da categoria para (.*)$")
    public void oUsuarioAlteraONomeDaCategoriaPara(String novaCategoria){
        gerenciarProjetosSteps.clicarEmAlterarCategoriaButton(Serenity.sessionVariableCalled("element"));
        Serenity.setSessionVariable("nomeCategoria").to(novaCategoria);
        gerenciarProjetosSteps.preencherNomeDaCategoriaAlterarInput(novaCategoria);
        gerenciarProjetosSteps.clicarAtualizarCategoriaButton();
    }


    @When("^o usuario atribui uma categoria a um usuario (.*)$")
    public void oUsuarioAtribuiUmaCategoriaAUmUsuario(String usuario){
        gerenciarProjetosSteps.clicarEmAlterarCategoriaButton(Serenity.sessionVariableCalled("element"));
        gerenciarProjetosSteps.selecionarAtribuidoASelect(usuario);
        gerenciarProjetosSteps.clicarAtualizarCategoriaButton();
    }

    @Then("a categoria é atribuida a um usuario com sucesso")
    public void aCategoriaEAtribuidaAUmUsuarioComSucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeOperacaoFoiUmSucesso().contains("Clique aqui para prosseguir"));
    }

    @Then("a categoria global e alterada com sucesso")
    public void categoriaGlobalAlteradaComSucesso() throws Exception {
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeOperacaoFoiUmSucesso().contains("Clique aqui para prosseguir"));
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteCategoryPerName(Serenity.sessionVariableCalled("nomeCategoria"));
    }

}
