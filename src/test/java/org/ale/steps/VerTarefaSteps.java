package org.ale.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.VerTarefaPage;

public class VerTarefaSteps extends ScenarioSteps {
    VerTarefaPage verTarefaPage;

    @Step("clicar numero tarefa form list")
    public void clicarNumeroTarefaFormList(String numeroTarefa){
        verTarefaPage.clicarNumeroTarefaFormList(numeroTarefa);
    }

    @Step("selecionar tarefa form list")
    public void selecionarTarefaFormList(String numeroTarefa){
         verTarefaPage.selecionarTarefaFormList(numeroTarefa);
    }

    @Step("clicar imprimir tarefas button")
    public void clicarImprimirTarefasButton(){
        verTarefaPage.clicarImprimirTarefasButton();
    }

    @Step("selecionar atribuir a select")
    public void selecionarAtribuirASelect(String nome){
        verTarefaPage.selecionarAtribuirASelect(nome);
    }

    @Step("clicar atribuir a button")
    public void clicarAtribuirAButton(){
        verTarefaPage.clicarAtribuirAButton();
    }

    @Step("get text atribuido a label")
    public String getTextAtribuidoALabel(){
        return verTarefaPage.getTextAtribuidoALabel();
    }

    @Step("clicar enviar um lembrete button")
    public void clicarEnviarUmLembreteButton(){
        verTarefaPage.clicarEnviarUmLembreteButton();
    }

    @Step("selecionar enviar lembrete para select")
    public void enviarLembreteParaSelect(String nomeUsuario){
        verTarefaPage.enviarLembreteParaSelect(nomeUsuario);
    }

    @Step("preencher lembrete text area input")
    public void preencherLembreteTextAreaInput(String mensagem){
        verTarefaPage.preencherLembreteTextAreaInput(mensagem);
    }

    @Step("clicar enviar lembrente button")
    public void clicarEnviarLembreteButton(){
        verTarefaPage.clicarEnviarLembreteButton();
    }

    @Step("retorna operacao com sucesso")
    public String retornaOperacaoComSucesso(){
        return verTarefaPage.retornaOperacaoComSucesso();
    }

    @Step("selecionar marcadores atuais select")
    public void selecionarMarcadoresAtuaisSelect(String marcador){
        verTarefaPage.selecionarMarcadoresAtuaisSelect(marcador);
    }

    @Step("preencher aplicar marcadores input text")
    public void preencherAplicaMarcadoresInputText(String marcador){
        verTarefaPage.preencherAplicaMarcadoresInputText(marcador);
    }

    @Step("clicar aplicar marcador button")
    public void clicarAplicarMarcadorButton(){
        verTarefaPage.clicarAplicarMarcadorButton();
    }

    @Step("get text marcadores aplicados button list")
    public boolean getTextMarcadoresAplicadosButtonList(String marcador){
        return verTarefaPage.getTextMarcadoresAplicadosButtonList(marcador);
    }

    @Step("get text categoria error label")
    public String getTextCategoriaErrorLabel(){
        return verTarefaPage.getTextCategoriaErrorLabel();
    }

    @Step("selecionar alterar status select")
    public void selecionarAlterarStatusSelect(String status){
        verTarefaPage.selecionarAlterarStatusSelect(status);
    }

    @Step("clicar alterar status button")
    public void clicarAlterarStatusButton(){
        verTarefaPage.clicarAlterarStatusButton();
    }

    @Step("get text estado status form label")
    public String getTextEstadoStatusFormLabel(){
        return verTarefaPage.getTextEstadoStatusFormLabel();
    }

    @Step("clicar alterar status finalizar morph button")
    public void clicarAlterarStatusFinalizarMorphButton(){
        verTarefaPage.clicarAlterarStatusFinalizarMorphButton();
    }

    @Step("clicar criar clone button")
    public void clicarCriarCloneButton(){
        verTarefaPage.clicarCriarCloneButton();
    }

    @Step("clicar criar nova tarefa")
    public void clicarCriarnovaTarefa(){
        verTarefaPage.clicarCriarNovaTarefaButton();
    }

    @Step("clicar fechar tarefa button")
    public void clicarFecharTarefaButton(){
        verTarefaPage.clicarFecharTarefaButton();
    }

    @Step("clicar reabrir tarefa button")
    public void clicarReabrirTarefaButton(){
        verTarefaPage.clicarReabrirTarefaButton();
    }

    @Step("clicar apagar tarefa button")
    public void clicarApagarTarefaButton(){
        verTarefaPage.clicarApagarTarefaButton();
    }

    @Step("clicar confirmar apagar tarefa button")
    public void clicarConfirmarApagarTarefaButton(){
        verTarefaPage.clicarConfirmarApagarTarefaButton();
    }

    @Step("confirmar se tarefa existe")
    public boolean confirmarSeTarefaExiste(){
        return verTarefaPage.confirmarSeTarefaExiste();
    }

    @Step("preencher barra de pesquisa top bar direito")
    public void preencherBarraDePesquisaTopBarDireito(String numeroTarefa){
        verTarefaPage.preencherBarraDePesquisaTopBarDireito(numeroTarefa);
    }

    @Step("get text numero da tarefa text form ver tarefa")
    public String getTextNumeroDaTarefaTextFormVerTarefa(){
        return verTarefaPage.getTextNumeroDaTarefaTextFormVerTarefa();
    }

    @Step("selecionar esta tarefa select")
    public void selecionarEstaTarefaSelect(String relacao){
        verTarefaPage.selecionarEstaTarefaSelect(relacao);
    }

    @Step("clicar adicionar relacao button")
    public void clicarAdicionarRelacaoButton(){
        verTarefaPage.clicarAdicionarRelacaoButton();
    }

    @Step("preencher relacao input text")
    public void preencherRelacaoInputText(String numeroTarefa){
        verTarefaPage.preencherRelacaoInputText(numeroTarefa);
    }

    @Step("get text numero da tarefa relacao form list")
    public String getTextNumeroDaTarefaRelacaoFormList(){
        return verTarefaPage.getTextNumeroDaTarefaRelacaoFormList();
    }

    @Step("preencher nome de usuario input text")
    public void preencherNomeDeUsuarioInputText(String usuario){
        verTarefaPage.preencherNomeDeUsuarioInputText(usuario);
    }

    @Step("clicar adicionar usuario monitorando tarefa button")
    public void clicarAdicionarUsuarioMonitorandoTarefaButton(){
        verTarefaPage.clicarAdicionarUsuarioMonitorandoTarefaButton();
    }

    @Step("get text usuario monitorando tarefa list label")
    public String getTextUsuarioMonitorandoTarefaListLabel(){
        return verTarefaPage.getTextUsuarioMonitorandoTarefaListLabel();
    }
}
