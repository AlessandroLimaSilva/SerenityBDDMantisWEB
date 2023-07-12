package org.ale.steps;

/**
 * * @Author Alessandro Lima 23/10/2022
 */

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.LoginPage;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step("Acessa a tela de login")
    public void acessaTelaDeLogin(){
        loginPage.acessaTelaDeLogin();
    }

    @Step("Acessa abre uma nova aba pelo javaScript e acessa uma url ")
    public void abreUmaNovaAbaPeloJavaScriptEAcessaUmaURL(String url){
        loginPage.acessaNovaUrl(url);
    }

    @Step("preencher nome de usuario input text area")
    public void preencherNomeDeUsuarioInputTextArea(String dado){
        loginPage.preencherNomeDeUsuarioTextArea(dado);
    }

    @Step("clicar em entrar button")
    public void clicarEmEntrarNomeButton(){
        loginPage.clicarEmEntrarNomeButton();
    }

    @Step("preencher senha input text area")
    public void preencherSenhaInputTextArea(String dado){
        loginPage.preencherSenhaTextArea(dado);
    }

    @Step("clicar em entrar senha button")
    public void clicarEntrarSenhaButton(){
        loginPage.clicarEntrarSenhaButton();
    }

    @Step("retorna nome label dropDown top bar")
    public String retornaNomeLabelDropDownBarTop(){
        return loginPage.retornaNomeLabelDropDownBarTop();
    }

}
