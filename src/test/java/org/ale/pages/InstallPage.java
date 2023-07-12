package org.ale.pages;

import org.ale.utils.GlobalParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstallPage extends BasePage{

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    private static final String INSTALL_URL = GlobalParameters.DB_URL_MANTISBT;

    @FindBy(xpath = "//select[@id='db_type']")
    private WebElement typeOfDataBaseSelect;

    @FindBy(xpath = "//input[@name='hostname']")
    private WebElement hostNameDataBaseServerInput;

    @FindBy(xpath = "//input[@name='db_username']")
    private WebElement userNameDataBaseInput;

    @FindBy(xpath = "//input[@name='db_password']")
    private WebElement passwordDataBaseInput;

    @FindBy(xpath = "//input[@name='database_name']")
    private WebElement dataBaseNameInput;

    @FindBy(xpath = "//input[@name='admin_username']")
    private WebElement adminUserNameDataBaseInput;

    @FindBy(xpath = "//input[@name='admin_password']")
    private WebElement adminPasswordDataBaseInput;

    @FindBy(xpath = "//select[@id='timezone']")
    private WebElement defaultTimeZoneSelect;

    @FindBy(xpath = "//input[@value='Install/Upgrade Database']")
    private WebElement installUpgradeDatabaseButton;

    @FindBy(xpath = "//option[@value='America/Sao_Paulo']")
    private WebElement saoPauloValue;

    @FindBy(xpath = "//div[@class='col-md-12 col-xs-12']//h4[@class='widget-title lighter' and contains(text(),'Installation Complete')]")
    private WebElement installationCompleteLabel;

    public InstallPage(WebDriver driver) {
        super(driver);
    }

    public void acessarURLDeConfiguracao(){
        driver.navigate().to(INSTALL_URL);
        waitUntilPageReady();
    }

    public void selecionarTypeOfDataBaseSelect(String dado){
        waitForElement(typeOfDataBaseSelect);
        selectByText(typeOfDataBaseSelect,dado);
    }

    public void preencherHostNameDataBaseServerInput(String dado){
        waitForElement(hostNameDataBaseServerInput);
        hostNameDataBaseServerInput.clear();
        hostNameDataBaseServerInput.sendKeys(dado);
    }

    public void preencherUserNameDataBaseInput(String dado){
        waitForElement(userNameDataBaseInput);
        userNameDataBaseInput.clear();
        userNameDataBaseInput.sendKeys(dado);
    }

    public void preencherPasswordDataBaseInput(String dado){
        waitForElement(passwordDataBaseInput);
        passwordDataBaseInput.clear();
        passwordDataBaseInput.sendKeys(dado);
    }

    public void preencherDataBaseNameInput(String dado){
        waitForElement(dataBaseNameInput);
        dataBaseNameInput.clear();
        dataBaseNameInput.sendKeys(dado);
    }

    public void preencherAdminUserNameDataBaseInput(String dado){
        waitForElement(adminUserNameDataBaseInput);
        adminPasswordDataBaseInput.clear();
        adminUserNameDataBaseInput.sendKeys(dado);
    }

    public void preencherAdminPasswordDataBaseInput(String dado){
        waitForElement(adminPasswordDataBaseInput);
        adminPasswordDataBaseInput.clear();
        adminPasswordDataBaseInput.sendKeys(dado);
    }

    public void selecionarDefaultTimeZoneSelect(){
        waitForElement(defaultTimeZoneSelect);
        scrollToElementJavaScript(defaultTimeZoneSelect);
        defaultTimeZoneSelect.click();
        scrollToElementJavaScript(saoPauloValue);
        saoPauloValue.click();
    }

    public void clicarInstallUpgradeDatabaseButton(){
        waitForElement(installUpgradeDatabaseButton);
        installUpgradeDatabaseButton.click();
    }

    public String installationCompleteLabelReturn(){
        waitForElement(installationCompleteLabel);
        return installationCompleteLabel.getText();
    }
}
