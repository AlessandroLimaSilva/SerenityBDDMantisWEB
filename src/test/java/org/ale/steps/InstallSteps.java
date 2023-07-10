package org.ale.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ale.pages.InstallPage;

import java.util.Map;

public class InstallSteps extends ScenarioSteps {

    InstallPage installPage;

    @Step("acesso a tela de configuracao do mantisBT")
    public void acessoATelaDeConfiguracaoDoMantisBT(){
        installPage.acessarURLDeConfiguracao();
    }

    @Step("informo os dados necessarios para configuracao do mantisBT")
    public void informoOSDadosNecessariosParaConfiguracaoDoMantisBT(Map map){
        installPage.selecionarTypeOfDataBaseSelect(map.get("typeDatabase").toString());
        installPage.preencherHostNameDataBaseServerInput(map.get("hostNameDataBase").toString());
        installPage.preencherUserNameDataBaseInput(map.get("userNameDataBase").toString());
        installPage.preencherPasswordDataBaseInput(map.get("passwordDataBase").toString());
        installPage.preencherDataBaseNameInput(map.get("dataBaseName").toString());
        installPage.preencherAdminUserNameDataBaseInput(map.get("adminUserNameDataBase").toString());
        installPage.preencherAdminPasswordDataBaseInput(map.get("adminPasswordDataBase").toString());
        installPage.selecionarDefaultTimeZoneSelect();
    }

    @Step("seleciono instalar database")
    public void selecionoInstalarDataBase(){
        installPage.clicarInstallUpgradeDatabaseButton();
    }

    @Step("retorno o texto de installation complete label")
    public String installationCompleteLabelReturn(){
        return installPage.installationCompleteLabelReturn();
    }
}
