package org.ale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlterarContaPage extends BasePage{

    @FindBy(xpath = "//input[@id='realname']")
    private WebElement nomeRealInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement senhaInput;
    @FindBy(xpath = "//input[@id='password-confirm']")
    private WebElement confirmaSenhaInput;

    @FindBy(xpath = "//span[@class='submit-button']//button")
    private WebElement atualizarUsuarioButton;


    public AlterarContaPage(WebDriver driver) {
        super(driver);
    }

    public void preencherNomeRealInput(String nomeReal){
        waitForElement(nomeRealInput);
        nomeRealInput.sendKeys(nomeReal);
    }

    public void preencherSenhaInput(String senha){
        waitForElement(senhaInput);
        senhaInput.sendKeys(senha);
    }

    public void preencherConfirmaSenhaInput(String senha){
        waitForElement(confirmaSenhaInput);
        confirmaSenhaInput.sendKeys(senha);
    }

    public void clicarAtualizarUsuarioButton(){
        waitForElement(atualizarUsuarioButton);
        atualizarUsuarioButton.click();
    }
}
