package org.ale.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.MyViewPage;

public class MyViewSteps extends ScenarioSteps {

    MyViewPage myViewPage;

    @Step("clicar em convidar usuarios")
    public void clicarConvidarUsuariosButton(){
        myViewPage.clicarConvidarUsuariosButton();
    }

    @Step("clicar em gerenciar button left bar")
    public void clicarGerenciarButtonLeftBar(){
        myViewPage.clicarGerenciarButtonLeftBar();
    }

    @Step("clicar Gerenciar Projetos Button")
    public void clicarGerenciarProjetosButton(){
        myViewPage.clicarGerenciarProjetosButton();
    }

    @Step("clicar criar projeto left bar")
    public void clicarCriarTarefaButtonLeftBar(){
        myViewPage.clicarCriarTarefaButtonLeftBar();
    }

    @Step("clicar ver tarefa button left bar")
    public void clicarVerTarefaButtonLeftBar(){
        myViewPage.clicarVerTarefaButtonLeftBar();
    }

    @Step("escolher projeto padrao")
    public void escolherProjetoPadrao(String nomeProjeto){
        myViewPage.escolherProjetoPadrao(nomeProjeto);
    }
}
