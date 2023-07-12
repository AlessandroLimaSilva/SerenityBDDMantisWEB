package org.ale.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.GerenciarProjetosPage;

public class GerenciarProjetosSteps extends ScenarioSteps {

    GerenciarProjetosPage gerenciarProjetosPage;

    @Step("clicar Criar Novo Projeto Button")
    public void clicarCriarNovoProjetoButton(){
        gerenciarProjetosPage.clicarCriarNovoProjetoButton();
    }

    @Step("preencher Nome Do Projeto Input Text")
    public void preencherNomeDoProjetoInputText(String dado){
        gerenciarProjetosPage.preencherNomeDoProjetoInputText(dado);
    }

    @Step("selecionar estado Do Projeto Select")
    public void selecionarEstadoDoProjetoSelect(String dado){
        gerenciarProjetosPage.selecionarEstadoDoProjetoSelect(dado);
    }

    @Step("clicar herdar Habilidades Globais Check")
    public void clicarHerdarHabilidadesGlobaisCheck(String dado){
        if (dado.equalsIgnoreCase("sim")){

        }
        if (dado.equalsIgnoreCase("nao")){
            gerenciarProjetosPage.clicarHerdarHabilidadesGlobaisCheck();
        }
    }

    @Step("selecionar Visibilidade Do Projeto Select")
    public void selecionarVisibilidadeDoProjetoSelect(String dado){
        gerenciarProjetosPage.selecionarVisibilidadeDoProjetoSelect(dado);
    }

    @Step("preencher Descricao Do Projeto Text Area")
    public void preencherDescricaoDoProjetoTextArea(String dado){
        gerenciarProjetosPage.preencherDescricaoDoProjetoTextArea(dado);
    }

    @Step("clicar Adicionar Projeto Button")
    public void clicarAdicionarProjetoButton(){
        gerenciarProjetosPage.clicarAdicionarProjetoButton();
    }

    @Step("retorna se a operacao foi um sucesso")
    public String retornaSeOperacaoFoiUmSucesso(){
        return gerenciarProjetosPage.retornaOperacaoComSucesso();
    }

    @Step("retorna se o nome do projeto ja esta sendo utilizado")
    public String retornaSeNomeDeProjetoJaEstaSendoUtilizado(){
        return gerenciarProjetosPage.nomeDeProjetoJaUtilizadoErrorCard();
    }

    @Step("retorna se o nome da categoria global ja esta sendo utilizado")
    public boolean retornaSeNomeDeCategoriaGlobalJaEstaSendoUtilizado(){
        return gerenciarProjetosPage.nomeDeCategoriaGlobalJaUtilizadoErroCard();
    }

    @Step("preencher adicionar nova categoria ")
    public void preencherAdicionarNovaCategoria(String dado){
        gerenciarProjetosPage.preencherAdicionarNovaCategoria(dado);
    }

    @Step("clicar Adicionar Nova Categoria Button")
    public void clicarAdicionarNovaCategoriaButton(){
        gerenciarProjetosPage.clicarAdicionarNovaCategoriaButton();
    }

    @Step("retorna categoria nome table form")
    public String retornarCategoriaNomeFormTable(String dado){
        return gerenciarProjetosPage.retornaCategoriaNomeTableFormPath(dado);
    }

    @Step("retorna error label campo da categoria label")
    public String retornarErrorLabelCampoDaCategoriaGlobal(){
        return gerenciarProjetosPage.retornarErrorLabelCampoDaCategoriaGlobal();
    }

    @Step("clicar no nome de um projeto button link")
    public void clicarNomeDoProjetoButtonLink(String dado){
        gerenciarProjetosPage.clicarNomeDoProjetoButtonLink(dado);
    }

    @Step("clicar apagar projeto button editar projeto")
    public void clicarApagarProjetoButtonEditarProjeto(){
        gerenciarProjetosPage.clicarApagarProjetoButtonEditarProjeto();
    }

    @Step("clicar confirmar apagar projeto button")
    public void clicarConfirmarApagarProjetoButton(){
        gerenciarProjetosPage.clicarConfirmarApagarProjetoButton();
    }

    @Step("retorna se um projeto nao existe")
    public boolean retornaSeUmProjetoNaoExiste(String dado){
        return gerenciarProjetosPage.retornaSeUmProjetoNaoExiste(dado);
    }

    @Step("clicar em um projeto habilitado")
    public void clicarProjetoHabilitado(String dado){
        gerenciarProjetosPage.clicarProjetoHabilitadoLink(dado);
    }

    @Step("clicar habilitado Check Editar Projeto")
    public void clicarhabilitadoCheckEditarProjeto(){
        gerenciarProjetosPage.clicarhabilitadoCheckEditarProjeto();
    }

    @Step("clicar em um projeto desabilitado")
    public void clicarProjetoDesabilitado(String dado){
        gerenciarProjetosPage.clicarProjetoDesabilitadoLink(dado);
    }

    @Step("clicar em atualizar projeto button editar projeto")
    public void clicarAtualizarProjetoButtonEditarProjeto(){
        gerenciarProjetosPage.clicarAtualizarProjetoButtonEditarProjeto();
    }

    @Step("retorna projeto desabilitado e visivel")
    public boolean retornaProjetoDesabilitadoVisivel(String dado){
        return gerenciarProjetosPage.retornaProjetoDesabilitado(dado);
    }

    @Step("retorna projeto habilitado e visivel")
    public boolean retornaProjetoHabilitadoVisivel(String dado){
        return gerenciarProjetosPage.retornaProjetoHabilitado(dado);
    }

    @Step("retorna o estado do projeto")
    public boolean retornaEstadoDoProjeto(String dado,String tipoEstado){
        return gerenciarProjetosPage.retornaEstadoDoProjeto(dado,tipoEstado);
    }

    @Step("retorna a visibilidade do projeto")
    public boolean retornaVisibilidadeDoProjeto(String dado,String tipoVisibilidade){
        return gerenciarProjetosPage.retornaVisibilidadeDoProjeto(dado,tipoVisibilidade);
    }

    @Step("clicar em apagar categoria button")
    public void clicarEmApagarCategoriaButton(String dado){
        gerenciarProjetosPage.clicarApagarCategoriaDeCategoriaGlobal(dado);
    }

    @Step("clicar em alterar categoria button")
    public void clicarEmAlterarCategoriaButton(String dado){
        gerenciarProjetosPage.clicarAlterarCategoriaDeCategoriaGlobal(dado);
    }

    @Step("clicar confirmar apagar categoria button")
    public void clicarConfirmarApagarCategoriaButton(){
        gerenciarProjetosPage.clicarConfirmarApagarCategoriaButton();
    }

    @Step("clicar em criar novo subprojeto")
    public void clicarEmCriarNovoSubProjeto(){
        gerenciarProjetosPage.clicarCriarNovoSubProjetoButton();
    }

    @Step("preencher nome do subprojeto input text")
    public void preencherNomeDoSubProjetoInputText(String dado){
        gerenciarProjetosPage.preencherNomeDoSubProjetoInputText(dado);
    }

    @Step("clicar adicionar subprojeto")
    public void clicarAdicionarSubProjeto(){
        gerenciarProjetosPage.clicarAdicionarSubProjetoButton();
    }

    @Step("clicar desvincular subprojeto button")
    public void clicarDesvincularSubprojetoButton(String dado){
        gerenciarProjetosPage.clicarDesvincularSubProjetoButton(dado);
    }

    @Step("preencher nome da categoria alterar input")
    public void preencherNomeDaCategoriaAlterarInput(String dado){
        gerenciarProjetosPage.preencherNomeDaCategoriaAlterarInput(dado);
    }

    @Step("clicar atualizar categira button")
    public void clicarAtualizarCategoriaButton(){
        gerenciarProjetosPage.clicarAtualizarCategoriaButton();
    }

    @Step("clicar em atribuido a select")
    public void selecionarAtribuidoASelect(String nome){
        gerenciarProjetosPage.selecionarAtribuidoASelect(nome);
    }

}
