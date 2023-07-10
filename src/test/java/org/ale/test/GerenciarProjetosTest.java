package org.ale.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/gerenciarProjetos.feature",
        glue = {
        "org.ale.stepdefinitions",
        "org.ale.hooks",},
        tags = "@automatizado")

public class GerenciarProjetosTest {
}




