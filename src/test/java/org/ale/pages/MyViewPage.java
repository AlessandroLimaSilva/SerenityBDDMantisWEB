package org.ale.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyViewPage extends BasePage{

    private static final Logger LOGGER = LoggerFactory.getLogger(MyViewPage.class);

    @FindBy(xpath = "//a[@class='dropdown-toggle' and @aria-expanded='false']")
    private WebElement menuUsuarioDropDownTopBar;

    @FindBy(xpath = "//a[@href='/account_page.php']//i")
    private WebElement minhaContaMenuUsuarioButtonDropDownTopBar;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm' and @href='manage_user_create_page.php']")
    private WebElement convidarUsuariosButton;

    @FindBy(xpath = "//a[@href='/manage_overview_page.php']")
    private WebElement gerenciarButtonLeftBar;

    @FindBy(xpath = "//a[@href='/manage_proj_page.php']")
    private WebElement gerenciarProjetosButton;
    @FindBy(xpath = "//a[@href='/bug_report_page.php']")
    private WebElement criarTarefaButtonLeftBar;

    @FindBy(xpath = "//a[@href='/view_all_bug_page.php']")
    private WebElement verTarefaButtonLeftBar;

    @FindBy(xpath = "//input[@id='set-default']//following-sibling::span[@class='lbl']")
    private By tornarProjetoPadraoCheck = By.xpath("//input[@id='set-default']//following-sibling::span[@class='lbl']");

    @FindBy(xpath = "//select[@id='select-project-id']")
    private WebElement selecionarProjetoSelect;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement selecionarProjetoButton;

    public MyViewPage(WebDriver driver) {
        super(driver);
    }

    public void clicarMenuUsuarioDropDownTopBar(){
        waitForElement(menuUsuarioDropDownTopBar);
    }

    public void clicarMinhaContaMenuUsuarioButtonDropDownTopBar(){
        waitForElement(minhaContaMenuUsuarioButtonDropDownTopBar);
        minhaContaMenuUsuarioButtonDropDownTopBar.click();
    }

    public void clicarConvidarUsuariosButton(){
        waitForElement(convidarUsuariosButton);
        convidarUsuariosButton.click();
    }

    public void clicarGerenciarButtonLeftBar(){
        waitForElement(gerenciarButtonLeftBar);
        gerenciarButtonLeftBar.click();
    }

    public void clicarGerenciarProjetosButton(){
        waitForElement(gerenciarProjetosButton);
        gerenciarProjetosButton.click();
    }

    public void clicarCriarTarefaButtonLeftBar(){
        waitForElement(criarTarefaButtonLeftBar);
        criarTarefaButtonLeftBar.click();
    }

    public void clicarVerTarefaButtonLeftBar(){
        waitForElement(verTarefaButtonLeftBar);
        verTarefaButtonLeftBar.click();
    }

    public void clicarTornarProjetoPadraoCheck(){
        waitForElement(tornarProjetoPadraoCheck);
        click(tornarProjetoPadraoCheck);
    }

    public void selecionarProjetoSelect(String nomeProjeto){
        selectOptionByTextJavaScript(selecionarProjetoSelect,nomeProjeto);

    }

    public void clicarSelecionarProjetoButton(){
        waitForElement(selecionarProjetoButton);
        selecionarProjetoButton.click();
    }

    public void escolherProjetoPadrao(String nomeProjeto){
        if(!driver.findElements(tornarProjetoPadraoCheck).isEmpty()){
            selecionarProjetoSelect(nomeProjeto);
            clicarTornarProjetoPadraoCheck();
            clicarSelecionarProjetoButton();
        }
    }


}
