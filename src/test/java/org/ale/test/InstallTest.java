package org.ale.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/install.feature",
        glue = {
                "classpath:org.ale.stepdefinitions",
                "classpath:org.ale.hooks",},
        tags = "@installlDatabaseMantisBT or @MontaOBancoDeDados")

public class InstallTest {
}
