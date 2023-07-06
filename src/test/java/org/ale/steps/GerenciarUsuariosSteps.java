package org.ale.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.GerenciarUsuariosPage;

public class GerenciarUsuariosSteps extends ScenarioSteps {

    GerenciarUsuariosPage gerenciarUsuariosPage;

    @Step("clicar gerenciar usuarios button")
    public void clicarGerenciarUsuariosButton(){
        gerenciarUsuariosPage.clicarGerenciarUsuariosButton();
    }

    @Step("preencher nome de usuario input text")
    public void preencherNomeDeUsuarioInputText(String dado){
        gerenciarUsuariosPage.preencherNomeDeUsuarioInputText(dado);
    }

    @Step("preencher nome verdadeiro input text")
    public void preencherNomeVerdadeiroInputText(String dado){
        gerenciarUsuariosPage.preencherNomeVerdadeiroInputText(dado);
    }

    @Step("preencher email input text")
    public void preencherEmailInputText(String dado){
        gerenciarUsuariosPage.preencherEmailInputText(dado);
    }

    @Step("selecionar nivel de acesso")
    public void selecionarNivelDeAcesso(String dado){
        gerenciarUsuariosPage.selecionarNivelDeAcesso(dado);
    }

    @Step("clicar habilitado check")
    public void clicarHabilitadoCheck(){
        gerenciarUsuariosPage.clicarHabilitadoCheck();
    }

    @Step("clicar protegido check")
    public void clicarProtegidoCheck(){
        gerenciarUsuariosPage.clicarProtegidoCheck();
    }

    @Step("clicar criar usuario")
    public void clicarCriarUsuario(){
        gerenciarUsuariosPage.clicarCriarUsuario();
    }

    @Step("retorna operacao com sucesso")
    public boolean retornaOperacaoComSucesso(){
        return gerenciarUsuariosPage.retornaOperacaoComSucesso();
    }

    @Step("clicar criar nova conta button")
    public void clicarCriarNovaContaButton(){
        gerenciarUsuariosPage.clicarCriarNovaContaButton();
    }

    @Step("retorna nome de usuario Ja Utilizado Error Card")
    public boolean retornaNomeDeUsuarioJaUtilizadoErrorCard(){
        return gerenciarUsuariosPage.nomeDeUsuarioJaUtilizadoErrorCard();
    }

    @Step("retorna nome de usuario Ja Utilizado Error Card")
    public boolean retornaEmailDeUsuarioJaUtilizadoErrorCard(){
        return gerenciarUsuariosPage.emailDeUsuarioJaUtilizadoErrorCard();
    }

    @Step("clicar Nao Utilizado Button")
    public void clicarNaoUtilizadoButton(){
        gerenciarUsuariosPage.clicarNaoUtilizadoButton();
    }

    @Step("retorna se usuario esta na lista de pesquisa")
    public boolean retornaSeUsuarioEstaNaListaDePesquisa(String nomeUsuario){
        return gerenciarUsuariosPage.retornaSeUsuarioEstaNaListaDePesquisa(nomeUsuario);
    }

    @Step("retorna se a lista da pesquisa esta vazia")
    public boolean retornaSeAListaDaPesquisaEstaVazia(){
        return gerenciarUsuariosPage.retornaSeAListaDaPesquisaEstaVazia();
    }

    @Step("preencher pesquisar usuario input text")
    public void preencherPesquisarUsuarioInputText(String dado){
        gerenciarUsuariosPage.preencherPesquisarUsuarioInputText(dado);
    }

    @Step("clicar aplicar filtro button")
    public void clicarAplicarFiltroButton(){
        gerenciarUsuariosPage.clicarAplicarFiltroButton();
    }

    @Step("retorna nome de usuario label form")
    public boolean retornaNomeDeUsuarioLabelForm(){
        return gerenciarUsuariosPage.retornaNomeDeUsuarioLabelForm();
    }

    @Step("clicar novo button")
    public void clicarNovoButton(){
        gerenciarUsuariosPage.clicarNovoButton();
    }

    @Step("clicar Em Usuario Por Nome")
    public void clicarEmUsuarioPorNome(String dado){
        gerenciarUsuariosPage.clicarEmUsuarioPorNome(dado);
    }

    @Step("clicar habilitado check alterar usuario")
    public void clicarHabilitadoCheckAlterarUsuario(){
        gerenciarUsuariosPage.clicarHabilitadoCheckAlterarUsuario();
    }

    @Step("clicar Atualizar Usuario Button Alterar Usuario")
    public void clicarAtualizarUsuarioButtonAlterarUsuario(){
        gerenciarUsuariosPage.clicarAtualizarUsuarioButtonAlterarUsuario();
    }

    @Step("clicar Mostrar Desativados Check")
    public void clicarMostrarDesativadosCheck(){
        gerenciarUsuariosPage.clicarMostrarDesativadosCheck();
    }

    @Step("click Representar Usuario Button Alterar Usuario")
    public void clickRepresentarUsuarioButtonAlterarUsuario(){
        gerenciarUsuariosPage.clickRepresentarUsuarioButtonAlterarUsuario();
    }

    @Step("click Apagar Usuario Button Alterar Usuario")
    public void clickApagarUsuarioButtonAlterarUsuario(){
        gerenciarUsuariosPage.clickApagarUsuarioButtonAlterarUsuario();
    }

    @Step("click Apagar Conta Confirma Button Alterar Usuario")
    public void clickApagarContaConfirmaButtonAlterarUsuario(){
        gerenciarUsuariosPage.clickApagarContaConfirmaButtonAlterarUsuario();
    }

    @Step("retorna Se Usuario E Visivel Na Pesquisa")
    public boolean retornaSeUsuarioEVisivelNaPesquisa(String dado){
        return gerenciarUsuariosPage.retornaSeUsuarioEVisivelNaPesquisa(dado);
    }

    @Step("clica em todos button")
    public void clicarTodosButton(){
        gerenciarUsuariosPage.clicarTodosButton();
    }

    @Step("clicar primeira letra alfabeto menu search lista")
    public void clicarPrimeiraLetraAlfabetoMenuSearchLista(String nome){
        gerenciarUsuariosPage.clicarPrimeiraLetraAlfabetoMenuSearchLista(nome);
    }

    @Step("clicar redefinir senha button")
    public void clicarRedefinirSenhaButton(){
        gerenciarUsuariosPage.clicarRedefinirSenhaButton();
    }
}
