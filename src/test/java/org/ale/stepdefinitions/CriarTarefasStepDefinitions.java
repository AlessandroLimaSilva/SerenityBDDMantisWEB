package org.ale.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.ale.dao.DeleteDao;
import org.ale.steps.CriarTarefasSteps;
import org.ale.steps.GerenciarProjetosSteps;
import org.ale.steps.MyViewSteps;

public class CriarTarefasStepDefinitions {

    @Steps
    MyViewSteps myViewSteps;

    @Steps
    GerenciarProjetosSteps gerenciarProjetosSteps;

    @Steps
    CriarTarefasSteps criarTarefasSteps;

    @And("que o usuario tenha selecionado criar tarefas")
    public void queOUsuarioTenhaSelecionadoCriarTarefas(){
        myViewSteps.clicarCriarTarefaButtonLeftBar();
        myViewSteps.escolherProjetoPadrao(Serenity.sessionVariableCalled("projectName"));
    }

    @When("^o usuario informa os dados categoria (.*), frequencia (.*), gravidade (.*), prioridade (.*), atribuir (.*), resumo (.*), descricao (.*) e visibilidade (.*)$")
    public void oUsuarioInformaOsDadosCategoriaFrequenciaGravidadePrioridadeAtribuirResumoDescricaoEVisibilidade(String categoria,String frequencia,String gravidade,String prioridade,String atribuir,String resumo,String descricao,String visibilidade){
        criarTarefasSteps.selecionarCategoriaOptions(categoria);
        criarTarefasSteps.selecionarFrequenciaOptions(frequencia);
        criarTarefasSteps.selecionarGravidadeOptions(gravidade);
        criarTarefasSteps.selecionarPrioridadeOptions(prioridade);
        criarTarefasSteps.selecionarAtribuirAOptions(atribuir);
        criarTarefasSteps.preencherResumoInputText(resumo);
        criarTarefasSteps.preencherDescricaoInputText(descricao);
        criarTarefasSteps.selecionarVisibilidadeRadio(visibilidade);
        criarTarefasSteps.clicarCriarNovaTarefaButton();
    }

    @Then("a tarefa é criada com sucesso")
    public void aTarefaECriadaComsucesso(){
        Assert.assertTrue(gerenciarProjetosSteps.retornaSeOperacaoFoiUmSucesso().contains("Operação realizada com sucesso."));
    }

    @And("o projeto e a tarefa são excluidos")
    public void oProjetoEATarefaSaoExcluidos() throws Exception {
        DeleteDao deleteDao = new DeleteDao();
        deleteDao.deleteProjectPerID();
        deleteDao.deleteIssuePerID();
    }

    @When("^o usuario informar os dados minimos categoria (.*), resumo (.*) e descrição (.*)$")
    public void oUsuarioInformarOsDadosMinimosCategoriaResumoEDescricacao(String categoria,String resumo,String descricao){
        criarTarefasSteps.selecionarCategoriaOptions(categoria);
        criarTarefasSteps.preencherResumoInputText(resumo);
        criarTarefasSteps.preencherDescricaoInputText(descricao);
        criarTarefasSteps.clicarCriarNovaTarefaButton();
    }

    @When("^o usuario informar os dados minimos resumo (.*), descrição (.*) e esquecer de informar a categoria$")
    public void oUsuarioInformarOsDadosMinimosEEsquecerDeInformarACategoria(String resumo,String descricao){
        criarTarefasSteps.preencherResumoInputText(resumo);
        criarTarefasSteps.preencherDescricaoInputText(descricao);
        criarTarefasSteps.clicarCriarNovaTarefaButton();
    }

    @When("^o usuario informar os dados minimos categoria (.*), descrição (.*) e esquecer do resumo$")
    public void oUsuarioInformarOsDadosMinimosCategoriaEDescricaoEEsquecerDoResumo(String categoria,String descricao){
        criarTarefasSteps.selecionarCategoriaOptions(categoria);
        criarTarefasSteps.preencherDescricaoInputText(descricao);
        criarTarefasSteps.clicarCriarNovaTarefaButton();

    }

    @When("^o usuario informar os dados minimos categoria (.*), resumo (.*) e esquecer da descricao$")
    public void oUsuarioInformarOsdadosMinimosCategoriaResumoEEsquecerDaDescricao(String categoria,String resumo){
        criarTarefasSteps.selecionarCategoriaOptions(categoria);
        criarTarefasSteps.preencherResumoInputText(resumo);
        criarTarefasSteps.clicarCriarNovaTarefaButton();
    }

    @Then("a tarefa não é criada")
    public void aTarefaNaoECriada(){
        Assert.assertTrue(criarTarefasSteps.categoriaNaoInformadaErrorEVisivel());
    }

    @Then("a tarefa não sera criada")
    public void aTarefaNaoSeraCriada(){
        Assert.assertTrue(criarTarefasSteps.criarNovaTarefaButtonEVisivel());
    }

}
