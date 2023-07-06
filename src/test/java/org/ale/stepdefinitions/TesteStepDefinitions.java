package org.ale.stepdefinitions;


import io.cucumber.java.en.When;
import org.ale.dao.InsertDAO;

public class TesteStepDefinitions {

    @When("criar datatable e popular")
    public void fodasse() throws Exception {
        InsertDAO insertDAO = new InsertDAO();
        insertDAO.popularBancoDeDadoTesteAPI();
    }

}
