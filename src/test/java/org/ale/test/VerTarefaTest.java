package org.ale.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/verTarefa.feature",
        glue = {
                "classpath:org.ale.stepdefinitions",
                "classpath:org.ale.hooks"},
        tags = "@automatizado or @Teste")

public class VerTarefaTest {
}
