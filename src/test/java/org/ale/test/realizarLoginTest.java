package org.ale.test;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/realizarLogin.feature",
        glue = {
        "classpath:org.ale.stepdefinitions",
        "classpath:org.ale.hooks",},
        tags = "@automatizado")

public class realizarLoginTest {
}
