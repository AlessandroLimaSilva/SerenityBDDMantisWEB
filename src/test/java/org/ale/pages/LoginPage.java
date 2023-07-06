package org.ale.pages;

/**
 * * @Author Alessandro Lima 23/10/2022
 */

import org.ale.utils.GlobalParameters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends BasePage{

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@id='username']")
    private WebElement nomeDeUsuarioInputText;

    @FindBy(xpath = "//input[@class='width-40 pull-right btn btn-success btn-inverse bigger-110']")
    private WebElement entrarNomeButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement senhaInputTextArea;

    @FindBy(xpath = "//input[@class='width-40 pull-right btn btn-success btn-inverse bigger-110']")
    private WebElement entrarSenhaButton;

    @FindBy(xpath = "//span[@class='user-info']")
    private WebElement nomelabelDropDownBarTop;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void acessaNovaUrl(String url){
        driver.quit();
        this.openNewTab();
        //driver.navigate().to(url);
        driver.switchTo().activeElement();
    }

    public void acessaTelaDeLogin(){
        this.openNewTab();
        //this.open();
        driver.navigate().to(GlobalParameters.URL_DEFAULT);
        waitUntilPageReady();
    }

    public void preencherNomeDeUsuarioTextArea(String dado){
        waitForElement(nomeDeUsuarioInputText);
        nomeDeUsuarioInputText.sendKeys(dado);
    }

    public void clicarEmEntrarNomeButton(){
        waitForElement(entrarNomeButton);
        entrarNomeButton.click();
    }

    public void preencherSenhaTextArea(String dado){
        waitForElement(senhaInputTextArea);
        senhaInputTextArea.sendKeys(dado);
    }

    public void clicarEntrarSenhaButton(){
        waitForElement(entrarSenhaButton);
        entrarSenhaButton.click();
    }

    public String retornaNomeLabelDropDownBarTop(){
        waitForElement(nomelabelDropDownBarTop);
        return nomelabelDropDownBarTop.getText();
    }

}
