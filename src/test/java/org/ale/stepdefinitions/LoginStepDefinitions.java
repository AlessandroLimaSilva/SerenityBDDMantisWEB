package org.ale.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.nashorn.internal.objects.Global;
import net.thucydides.core.annotations.Steps;
import org.ale.steps.LoginSteps;
import org.ale.utils.GlobalParameters;
import org.junit.Assert;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Given("que o usuario esta logado como Administrator")
    public void queEstouLogadoComoAdministrator(){
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
