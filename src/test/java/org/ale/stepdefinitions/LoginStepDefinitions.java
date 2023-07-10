package org.ale.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;import org.ale.steps.LoginSteps;
import org.ale.utils.GlobalParameters;
import org.junit.Assert;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Given("que o usuario esta logado como Administrator")
    public void queEstouLogadoComoAdministrator() {
        loginSteps.acessaTelaDeLogin();
        loginSteps.preencherNomeDeUsuarioInputTextArea(GlobalParameters.AUTHENTICATOR_USER);
        loginSteps.clicarEmEntrarNomeButton();
        loginSteps.preencherSenhaInputTextArea(GlobalParameters.AUTHENTICATOR_PASSWORD);
        loginSteps.clicarEntrarSenhaButton();
    }


    @Given("acessa a tela de login")
    public void acessarATelaDeLogin(){
        loginSteps.acessaTelaDeLogin();
    }

    @And("o administrador informa nome de usuario")
    public void administradorInsereSeuNome(){
        loginSteps.preencherNomeDeUsuarioInputTextArea("administrator");
        loginSteps.clicarEmEntrarNomeButton();
    }

    @When("o administrador informa sua senha")
    public void administradorInformaSuaSenha(){
        loginSteps.preencherSenhaInputTextArea("root2");
        loginSteps.clicarEntrarSenhaButton();
    }

    @Then("sera exibido a pagina inicial")
    public void seraExibidoAPaginaInicial(){
        Assert.assertEquals(loginSteps.retornaNomeLabelDropDownBarTop(),"administrator");
    }

}
