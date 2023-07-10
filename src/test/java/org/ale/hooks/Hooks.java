package org.ale.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;


public class Hooks {

    @Before()
    public void beforeScenario() {

    }

    @After
    public void afterScenario(){
        //código a ser executado depois de cada cenário
        Serenity.getWebdriverManager().resetDriver();
        Serenity.getWebdriverManager().closeDriver();
    }


}

