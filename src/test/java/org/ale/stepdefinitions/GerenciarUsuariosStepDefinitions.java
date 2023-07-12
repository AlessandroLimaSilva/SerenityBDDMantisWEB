package org.ale.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.ale.dao.DeleteDao;
import org.ale.dao.InsertDAO;
import org.ale.dao.SelectDAO;
import org.ale.steps.*;
import org.ale.utils.Utils;
import org.junit.Assert;
import java.util.Map;


public class GerenciarUsuariosStepDefinitions {

    @Steps
    GerenciarUsuariosSteps gerenciarUsuariosSteps;

    @Steps
    MyViewSteps myViewSteps;

    @Steps
    GerenciarProjetosSteps gerenciarProjetosSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AlterarContaSteps alterarContaSteps;

    @And("que o usuario tenha selecionado um projeto")
    public void queOUsuarioTenhaSelecionadoUmProjeto(){
        myViewSteps.clicarGerenciarButtonLeftBar();
        myViewSteps.clicarGerenciarProjetosButton();
        gerenciarProjetosSteps.clicarNomeDoProjetoButtonLink(Serenity.sessionVariableCalled("projectName"));
    }

    @And("o usuario confirma apagar o projeto")
    public void oUsuarioConfirmaApagarOProjeto(){
        gerenciarProjetosSteps.clicarApagarProjetoButtonEditarProjeto();
        gerenciarProjetosSteps.clicarConfirmarApagarProjetoButton();
    }

    @And("^que o usuario acessou gerenciar usuario$")
    public void queOUsuarioAcessouGerenciarUsuario(){
        myViewSteps.clicarGerenciarButtonLeftBar();
        gerenciarUsuariosSteps.clicarGerenciarUsuariosButton();
    }

    @And("^que o administrador redefiniu a senha de usuario de (.*)$")
    public void queOAdministradorRedefiniuASenhaDeUsuario(String nomeUsuario){
        myViewSteps.clicarGerenciarButtonLeftBar();
        gerenciarUsuariosSteps.clicarGerenciarUsuariosButton();
        gerenciarUsuariosSteps.clicarEmUsuarioPorNome(nomeUsuario);
        gerenciarUsuariosSteps.clicarRedefinirSenhaButton();
    }

    @And("^que o usuario (.*) acessou o link de redefinir senha$")
    public void queOUsuarioAcessouOLinkDeRedefinirSenha(String nomeUsuario) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForName(nomeUsuario);
        String url = selectDAO.getLinkEmail(map.get("email").toString());
        loginSteps.abreUmaNovaAbaEAcessaUmaURL(Utils.limpaUrlEmail(url));
    }

    @When("o usuario redefinir sua senha")
    public void oUsuarioRedefinirSuaSenha(){
        alterarContaSteps.preencherSenhaInput("root");
        alterarContaSteps.preencherConfirmarSenhaInput("root");
        alterarContaSteps.clicarAtualizarUsuarioButton();
    }

    @Then("a senha e redefinida com sucesso")
    public void aSenhaERedefinidaComSucesso(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaOperacaoComSucesso());
    }

    @And("que o administrador acessou gerenciar usuario")
    public void queOAdministradorAcessouGerenciarUsuario(){
        myViewSteps.clicarGerenciarButtonLeftBar();
        gerenciarUsuariosSteps.clicarGerenciarUsuariosButton();
    }

    @And("seleciono gerenciar")
    public void selecionoGerenciar(){
        myViewSteps.clicarGerenciarButtonLeftBar();
    }

    @And("seleciono gerenciar usuarios")
    public void selecionoGerenciarUsuarios(){
        gerenciarUsuariosSteps.clicarGerenciarUsuariosButton();
    }

    @And("^que exista um usuario com nome (.*) ja cadastrado$")
    public void queExistaUmUsuarioComNomeJaCadastrado(String nomeUsuario) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForName(nomeUsuario);
        Serenity.setSessionVariable("nomeUsuario").to(map.get("username").toString());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneUser(map);
    }

    @And("^que exista um novo usuario com nome (.*) ja cadastrado$")
    public void queExistaUmNovoUsuarioComNomeJaCadastrado(String nomeUsuario) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForName(nomeUsuario);
        Serenity.setSessionVariable("nomeUsuario").to(map.get("username").toString());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneNewUser(map);
    }

    @And("^que exista um usuario do tipo (.*) ja cadastrado$")
    public void queExistaUmUsuarioDoTipoJaCadastrado(String nomeUsuario) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForType(nomeUsuario);
        Serenity.setSessionVariable("nomeUsuario").to(map.get("username").toString());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneNewUser(map);
    }

    @And("^que exista um usuario (.*) não utilizado ja castrado$")
    public void queExistaUmUsuarioNaoUtilizadoJaCadastrado(String nomeUsuario) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForName(nomeUsuario);
        Serenity.setSessionVariable("nomeUsuario").to(map.get("username").toString());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneUser(map);
    }

    @And("^que exista um usuario (.*) desabilitado ja cadastrado$")
    public void queExistaUmUsuarioDesabilitadoJaCadastrado(String nomeUsuario) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForName(nomeUsuario);
        Serenity.setSessionVariable("nomeUsuario").to(map.get("username").toString());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertNewOneUserDisabled(map);
    }

    @And("^informa os dados necessarios para criar um novo usuario (.*)$")
    public void informaOsDadosNecessariosParaCriarUmNovoUsuario(String tipoUsuario) throws Exception {
        gerenciarUsuariosSteps.clicarCriarNovaContaButton();
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForType(tipoUsuario);
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(map.get("username").toString());
        gerenciarUsuariosSteps.preencherNomeDeUsuarioInputText(map.get("username").toString());
        gerenciarUsuariosSteps.preencherNomeVerdadeiroInputText(map.get("realname").toString());
        gerenciarUsuariosSteps.preencherEmailInputText(map.get("email").toString());
        gerenciarUsuariosSteps.selecionarNivelDeAcesso(map.get("tipoUsuario").toString());
        Serenity.setSessionVariable("nomeUsuario").to(map.get("username").toString());
    }

    @And("^informa um nome (.*) ja utilizado junto dos dados necessarios$")
    public void informoUmNomeJaUtilizadoJuntoDosDadosNecessarios(String nomeUsuario) throws Exception {
        gerenciarUsuariosSteps.clicarCriarNovaContaButton();
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForName(nomeUsuario);
        gerenciarUsuariosSteps.preencherNomeDeUsuarioInputText(map.get("username").toString());
        gerenciarUsuariosSteps.preencherNomeVerdadeiroInputText(map.get("realname").toString());
        gerenciarUsuariosSteps.preencherEmailInputText(map.get("email").toString());
        gerenciarUsuariosSteps.selecionarNivelDeAcesso(map.get("tipoUsuario").toString());
    }

    @When("criar usuario for selecionado")
    public void criarUsuarioForSelecionado(){
        gerenciarUsuariosSteps.clicarCriarUsuario();
    }

    @Then("a nova conta e criada com sucesso")
    public void novaContaECriadaComSucesso(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaOperacaoComSucesso());
    }

    @And("o usuario e excluido")
    public void oUsuarioEDeletado() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
    }

    @And("^que exista um usuario com um email (.*) ja utilizado$")
    public void queExistaUmUsuarioComUmEmailJaUtilizado(String email) throws Exception {
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForEmail(email);
        Serenity.setSessionVariable("nomeUsuario").to(map.get("username").toString());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.setInsertOneUser(map);
    }

    @And("^informa um email (.*) ja utilizado junto dos dados necessarios$")
    public void informaUmEmailJaUtilizadoJuntoDosDadosNecessarios(String email) throws Exception {
        gerenciarUsuariosSteps.clicarCriarNovaContaButton();
        SelectDAO selectDAO = new SelectDAO();
        Map<String,Object> map = selectDAO.getUserForEmail(email);
        gerenciarUsuariosSteps.preencherNomeDeUsuarioInputText(map.get("email").toString());
        gerenciarUsuariosSteps.preencherNomeVerdadeiroInputText(map.get("realname").toString());
        gerenciarUsuariosSteps.preencherEmailInputText(map.get("email").toString());
        gerenciarUsuariosSteps.selecionarNivelDeAcesso(map.get("tipoUsuario").toString());
    }

    @Then("a nova conta nao e criada com o nome ja utilizado")
    public void aNovaContaNaoECriadaComONomeJaUtilizado() throws Exception {
        Assert.assertTrue(gerenciarUsuariosSteps.retornaNomeDeUsuarioJaUtilizadoErrorCard());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
    }

    @Then("a nova conta nao e criada pois o email ja e utilizado")
    public void aNovaContaNaoECriadaPoisOEmailJaEUtilizado() throws Exception {
        Assert.assertTrue(gerenciarUsuariosSteps.retornaEmailDeUsuarioJaUtilizadoErrorCard());
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteUserPerName(Serenity.sessionVariableCalled("nomeUsuario"));
    }

    @And("usuario nao utilizado for selecionado em pesquisar")
    public void usuarioNaoUtilizadoForSelecionadoEmPesquisar() {
        gerenciarUsuariosSteps.clicarNaoUtilizadoButton();
    }

    @When("a primeira letra do nome do usuario for selecionada")
    public void aPrimeiraLetraDoNomeDoUsuarioForSelecionada(){
        gerenciarUsuariosSteps.clicarPrimeiraLetraAlfabetoMenuSearchLista(Serenity.sessionVariableCalled("nomeUsuario"));
    }

    @Then("e mostrado todos os usuarios nao utilizados")
    public void eMostradoTodosOsUsuariosNaoUtilizados(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaSeUsuarioEstaNaListaDePesquisa(Serenity.sessionVariableCalled("nomeUsuario")));
    }

    @Then("o usuario não utilizado e retornado com sucesso")
    public void oUsuarioNaoUtilizadoERetornadoComSucesso(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaSeUsuarioEstaNaListaDePesquisa(Serenity.sessionVariableCalled("nomeUsuario")));
    }

    @Then("o usuario é apresentado na lista com sucesso")
    public void oUsuarioEApresentadoNaListaComSucesso(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaSeUsuarioEstaNaListaDePesquisa(Serenity.sessionVariableCalled("nomeUsuario")));
    }

    @Then("o usuario não é mostrado na lista")
    public void oUsuarioNaoEMostradonaLista(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaSeAListaDaPesquisaEstaVazia());
    }

    @When("^o usuario pesquisar o nome (.*) do usuario não utilizado$")
    public void oUsuarioPesquisaONomedoUsuarioNaoUtilizado(String nomeUsuario){
        gerenciarUsuariosSteps.preencherPesquisarUsuarioInputText(nomeUsuario);
        gerenciarUsuariosSteps.clicarAplicarFiltroButton();
    }

    @Then("e mostrado o nome do usuario nao utilizado")
    public void eMostradoONomeDoUsuarioNaoUtilizado(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaNomeDeUsuarioLabelForm());
    }

    @When("^o usuario pesquisar o usuario (.*) desabilitado$")
    public void oUsuarioPesquisarOUsuarioDesabilitado(String nomeUsuario){
        gerenciarUsuariosSteps.clicarMostrarDesativadosCheck();
        gerenciarUsuariosSteps.preencherPesquisarUsuarioInputText(nomeUsuario);
        gerenciarUsuariosSteps.clicarAplicarFiltroButton();
    }

    @When("o usuario pesquisar novo em pesquisar")
    public void oUsuarioPesquisarNovoEmPesquisar(){
        gerenciarUsuariosSteps.clicarNovoButton();
    }

    @And("^o usuario seleciona um usuario (.*)$")
    public void oUsuarioSelecionaUmUsuario(String nomeUsuario){
        gerenciarUsuariosSteps.clicarEmUsuarioPorNome(nomeUsuario);
    }

    @When("o usuario selecionar desabilitar usuario")
    public void oUsuarioSelecionarDesabilitarUsuario(){
        gerenciarUsuariosSteps.clicarHabilitadoCheckAlterarUsuario();
        gerenciarUsuariosSteps.clicarAtualizarUsuarioButtonAlterarUsuario();
    }

    @Then("o usuario e desabilitado com sucesso")
    public void oUsuarioEDesabilitadoComSucesso(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaOperacaoComSucesso());
    }

    @And("^que o usuario selecionou um usuario (.*) desabilitado$")
    public void queOUsuarioSelecionouUmUsuarioDesabilitado(String nomeUsuario){
        gerenciarUsuariosSteps.clicarMostrarDesativadosCheck();
        gerenciarUsuariosSteps.preencherPesquisarUsuarioInputText(nomeUsuario);
        gerenciarUsuariosSteps.clicarAplicarFiltroButton();
        gerenciarUsuariosSteps.clicarEmUsuarioPorNome(nomeUsuario);
    }

    @Then("o usuario e habilitado com sucesso")
    public void oUsuarioEHabilitadoComSucesso() {
        Assert.assertTrue(gerenciarUsuariosSteps.retornaOperacaoComSucesso());
    }

    @When("o usuario seleciona habilitar usuario")
    public void oUsuarioSelecionaHabilitarUsuario(){
        gerenciarUsuariosSteps.clicarHabilitadoCheckAlterarUsuario();
        gerenciarUsuariosSteps.clicarAtualizarUsuarioButtonAlterarUsuario();
    }

    @When("^o usuario selecionar representar um usuario do tipo (.*)$")
    public void oUsuarioSelecionarRepresentarUmUsuarioDoTipo(String tipoUsuario){
        gerenciarUsuariosSteps.clicarEmUsuarioPorNome(Serenity.sessionVariableCalled("nomeUsuario"));
        gerenciarUsuariosSteps.clickRepresentarUsuarioButtonAlterarUsuario();
    }

    @Then("o usuario e representado com sucesso")
    public void oUsuarioERepresentadoComSucesso() {
        Assert.assertTrue(gerenciarUsuariosSteps.retornaOperacaoComSucesso());
    }

    @When("^o usuario seleciona apagar o usuario do tipo (.*)$")
    public void oUsuarioSelecionaApagarOUsuarioDoTipo(String tipoUsuario){
        gerenciarUsuariosSteps.clicarTodosButton();
        gerenciarUsuariosSteps.clicarEmUsuarioPorNome(Serenity.sessionVariableCalled("nomeUsuario"));
        gerenciarUsuariosSteps.clickApagarUsuarioButtonAlterarUsuario();
        gerenciarUsuariosSteps.clickApagarContaConfirmaButtonAlterarUsuario();
    }

    @When("o usuario seleciona apagar usuario desabilitado")
    public void oUsuarioSelecionaApagarUsuariodesabilitado(){
        gerenciarUsuariosSteps.clickApagarUsuarioButtonAlterarUsuario();
        gerenciarUsuariosSteps.clickApagarContaConfirmaButtonAlterarUsuario();
    }

    @Then("o usuario e apagado com sucesso")
    public void oUsuarioEApagadoComSucesso(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaOperacaoComSucesso());
    }

    @When("pesquisar um usuario {string}")
    public void pesquisarUmUsuario(String dado){
        gerenciarUsuariosSteps.preencherPesquisarUsuarioInputText(dado);
        Serenity.setSessionVariable("dado").to(dado);
    }

    @When("^o usuario pesquisar pelo usuario (.*)$")
    public void pesquisoUsuarioJaCadastrado(String nomeUsuario){
        gerenciarUsuariosSteps.clicarTodosButton();
        gerenciarUsuariosSteps.preencherPesquisarUsuarioInputText(nomeUsuario);
        gerenciarUsuariosSteps.clicarAplicarFiltroButton();
        Serenity.setSessionVariable("nomeUsuario").to(nomeUsuario);
    }

    @Then("o usuario e retornado com sucesso")
    public void usuarioRetornadoComSucesso(){
        Assert.assertTrue(gerenciarUsuariosSteps.retornaSeUsuarioEVisivelNaPesquisa(Serenity.sessionVariableCalled("nomeUsuario")));
    }

}

