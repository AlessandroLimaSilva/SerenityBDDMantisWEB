package org.ale.hooks;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.ale.dao.DeleteDao;
import org.ale.dao.InsertDAO;
import org.ale.utils.GlobalParameters;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;

public class Hooks {

    @BeforeAll
    public static void beforeAll(){
        System.setProperty("serenity.opentelemetry.enabled", "false");
    }
    @Before
    public void beforeScenario() throws FileNotFoundException {

        //código a ser executado antes de cada cenário
    }

    @After
    public void afterScenario() throws Exception {
        //código a ser executado depois de cada cenário
        Serenity.getWebdriverManager().resetDriver();
        Serenity.getWebdriverManager().closeDriver();

    }
}
