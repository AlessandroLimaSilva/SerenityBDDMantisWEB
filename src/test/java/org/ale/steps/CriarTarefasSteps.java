package org.ale.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.CriarTarefasPage;

public class CriarTarefasSteps extends ScenarioSteps {

    CriarTarefasPage criarTarefasPage;

    @Step("selecionar categoria options")
    public void selecionarCategoriaOptions(String nomeCategoria){
        criarTarefasPage.selecionarCategoriaOptions(nomeCategoria);
    }

    @Step("selecionar frequencia options")
    public void selecionarFrequenciaOptions(String nomeFrequencia){
        criarTarefasPage.selecionarFrequenciaOptions(nomeFrequencia);
    }

    @Step("selecionar gravidade options")
    public void selecionarGravidadeOptions(String nomeGravidade){
        criarTarefasPage.selecionarGravidadeOptions(nomeGravidade);
    }

    @Step("selecionar prioridade options")
    public void selecionarPrioridadeOptions(String nomePrioridade){
        criarTarefasPage.selecionarPrioridadeOptions(nomePrioridade);
    }

    @Step("selecionar atribuir a options")
    public void selecionarAtribuirAOptions(String nomeAtribuirA){
        criarTarefasPage.selecionarAtribuirAOptions(nomeAtribuirA);
    }

    @Step("preencher resumo input text")
    public void preencherResumoInputText(String resumo){
        criarTarefasPage.preencherResumoInputText(resumo);
    }

    @Step("preencher descricao input text")
    public void preencherDescricaoInputText(String descricao){
        criarTarefasPage.preencherDescricaoInputText(descricao);
    }

    @Step("selecionar visibilidade radio")
    public void selecionarVisibilidadeRadio(String nomeVisibilidade){
        criarTarefasPage.selecionarVisibilidadeRadio(nomeVisibilidade);
    }

    @Step("clicar criar nova tarefa")
    public void clicarCriarNovaTarefaButton(){
        criarTarefasPage.clicarCriarNovaTarefaButton();
    }

    @Step("retorna se categoria nao informada error e visivel")
    public boolean categoriaNaoInformadaErrorEVisivel(){
        return criarTarefasPage.categoriaNaoInformadaErrorEVisivel();
    }

    @Step("retorna se criar nova tarefa button e visivel")
    public boolean criarNovaTarefaButtonEVisivel(){
        return criarTarefasPage.criarNovaTarefaButtonEVisivel();
    }
}
