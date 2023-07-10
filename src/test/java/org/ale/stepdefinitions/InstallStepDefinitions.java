package org.ale.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;import org.ale.dao.InsertDAO;
import org.ale.steps.InstallSteps;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class InstallStepDefinitions {

    @Steps
    InstallSteps installSteps;

    @Given("acesso a tela de configuracao do mantisBT")
    public void acessoATelaDeConfiguracaoDoMantisBT(){
        installSteps.acessoATelaDeConfiguracaoDoMantisBT();
    }

    @And("informo os dados necessarios para configurar o mantisBT")
    public void informoOsDadosNecessariosParaConfigurarOMantisBT(){
        //Adicionar a chamada no banco de dados
        Map<String,String> map = new HashMap<String, String>();
        map.put("typeDatabase","MySQL Improved");
        map.put("hostNameDataBase","mysql");
        map.put("userNameDataBase","mantisbt");
        map.put("passwordDataBase","mantisbt");
        map.put("dataBaseName","bugtracker");
        map.put("adminUserNameDataBase","root");
        map.put("adminPasswordDataBase","root");
        installSteps.informoOSDadosNecessariosParaConfiguracaoDoMantisBT(map);
    }

    @When("seleciono instalar database")
    public void selecionarInstalar(){
        installSteps.selecionoInstalarDataBase();
    }

    @Then("o mantisBT e configurado com sucesso")
    public void mantisBTEConfiguradoComSucesso(){
        Assert.assertTrue(installSteps.installationCompleteLabelReturn().contains("Installation Complete"));
    }

    @When("criar database e popular")
    public void criarDatabaseEPopular() throws Exception {
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.popularBancoDeDadoTesteAPI();
    }

    @Then("o banco de dados do teste e populado com sucesso")
    public void oBancoDeDadosDoTesteEPopuladoComSucesso(){
        System.out.println("Banco Criado Com Sucesso !!!!");
    }
}
