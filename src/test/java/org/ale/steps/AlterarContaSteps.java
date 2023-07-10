package org.ale.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.AlterarContaPage;

public class AlterarContaSteps extends ScenarioSteps {

    AlterarContaPage alterarContaPage;

    @Step("preencher nome real input")
    public void PreencherNomeRealInput(String nomeReal){
        alterarContaPage.preencherNomeRealInput(nomeReal);
    }

    @Step("preencher senha input")
    public void preencherSenhaInput(String senha){
        alterarContaPage.preencherSenhaInput(senha);
    }

    @Step("preencher confirmar senha input")
    public void preencherConfirmarSenhaInput(String senha){
        alterarContaPage.preencherConfirmaSenhaInput(senha);
    }

    @Step("clicar atualizar usuario button")
    public void clicarAtualizarUsuarioButton(){
        alterarContaPage.clicarAtualizarUsuarioButton();
    }
}
