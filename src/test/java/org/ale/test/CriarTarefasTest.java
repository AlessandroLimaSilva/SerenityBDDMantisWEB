package org.ale.test;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/criarTarefas.feature",
        glue = {
                "org.ale.stepdefinitions",
                "org.ale.hooks",},
        publish = true,
        tags = "@automatizado or @T")

public class CriarTarefasTest {
}
