package org.ale.pages;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciarUsuariosPage extends BasePage{

    private static final Logger LOGGER = LoggerFactory.getLogger(GerenciarUsuariosPage.class);

    @FindBy(xpath = "//a[@href='/manage_user_page.php']")
    private WebElement gerenciarUsuariosButton;

    @FindBy(xpath = "//div[@class='pull-left']//a[@href='manage_user_create_page.php']")
    private WebElement criarNovaContaButton;

    @FindBy(xpath = "//input[@id='user-username']")
    private WebElement nomeDeUsuarioInputText;

    @FindBy(xpath = "//input[@id='user-realname']")
    private WebElement nomeVerdadeiroInputText;

    @FindBy(xpath = "//input[@id='email-field']")
    private WebElement emailInputText;

    @FindBy(xpath = "//select[@id='user-access-level']")
    private WebElement nivelDeAcessoSelect;

    @FindBy(xpath = "//input[@id='user-enabled']")
    private WebElement habilitadoCheckCriarNovaConta;

    @FindBy(xpath = "//input[@id='user-protected']")
    private WebElement protegidoCheck;

    @FindBy(xpath = "//input[@class='btn btn-primary btn-white btn-round']")
    private WebElement criarUsuarioButton;

    @FindBy(xpath = "//div[@class='alert alert-success center']")
    private WebElement operacaoComSucessoLabel;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p[contains(text(),'APPLICATION ERROR #800')]")
    private WebElement nomeDeUsuarioJaUtilizadoErrorCard;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p[contains(text(),'APPLICATION ERROR #813')]")
    private WebElement emailDeUsuarioJaUtilizadoErrorCard;

    @FindBy(xpath = "//a[@href='manage_user_page.php?sort=username&dir=ASC&save=1&hideinactive=0&showdisabled=0&filter=UNUSED&search=']")
    private WebElement naoUtilizadoButton;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement pesquisarUsuarioInputText;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement aplicarFiltroButton;

    @FindBy(xpath = "//tr//td//a[@href]")
    private WebElement nomeDeUsuarioLabelForm;

    @FindBy(xpath = "//a[@href='manage_user_page.php?sort=username&dir=ASC&save=1&hideinactive=0&showdisabled=0&filter=NEW&search=']")
    private WebElement novoButton;

    @FindBy(xpath = "//input[@id='edit-enabled']//following-sibling::span")
    private WebElement habilitadoCheckAlterarUsuario;

    @FindBy(xpath = "(//div[@class='widget-toolbox padding-8 clearfix']//input[@type='submit' and @value])[1]")
    private WebElement atualizarUsuarioButtonAlterarUsuario;

    @FindBy(xpath = "//input[@name='showdisabled']//following-sibling::span")
    private WebElement mostrarDesativadosCheck;

    @FindBy(xpath = "//form[@id='manage-user-impersonate-form']//input[@type='submit']")
    private WebElement representarUsuarioButtonAlterarUsuario;

    @FindBy(xpath = "//form[@id='manage-user-delete-form']//input[@type='submit']")
    private WebElement apagarUsuarioButtonAlterarUsuario;

    @FindBy(xpath = "//input[@name='manage_user_delete_token']//following-sibling::input[@type='submit']")
    private WebElement apagarContaConfirmaButtonAlterarUsuario;

    @FindBy(xpath = "//a[@href='manage_user_page.php?sort=username&dir=ASC&save=1&hideinactive=0&showdisabled=0&filter=ALL&search=']")
    private WebElement todosButton;

    @FindBy(xpath = "//tr//td//a[contains(text(),'')]")
    private List<WebElement> nomeDeUsuarioButtonVariavelList;
    //private By nomeDeUsuarioButtonVariavelList = By.xpath("//tr//td//a[contains(text(),'')]");

    @FindBy(xpath = "//a[@class='btn btn-xs btn-white btn-primary ']")
    private List<WebElement> alfabetoMenuSearchLista;
    @FindBy(xpath = "//form[@id='manage-user-reset-form']//input[@type='submit']")
    private WebElement redefinirSenhaButton;
    private By listaDeUsuarioNaoUtilizados = By.xpath("//tr//td//a[@href]");

    public GerenciarUsuariosPage(WebDriver driver) {
        super(driver);
    }

    public void clicarGerenciarUsuariosButton(){
        waitForElement(gerenciarUsuariosButton);
        gerenciarUsuariosButton.click();
    }

    public void clicarCriarNovaContaButton(){
        waitForElement(criarNovaContaButton);
        criarNovaContaButton.click();
    }

    public void preencherNomeDeUsuarioInputText(String dado){
        waitForElement(nomeDeUsuarioInputText);
        nomeDeUsuarioInputText.clear();
        nomeDeUsuarioInputText.sendKeys(dado, Keys.TAB);
    }

    public void preencherNomeVerdadeiroInputText(String dado){
        waitForElement(nomeVerdadeiroInputText);
        nomeVerdadeiroInputText.sendKeys(dado,Keys.TAB);
    }

    public void preencherEmailInputText(String dado){
        waitForElement(emailInputText);
        emailInputText.sendKeys(dado,Keys.TAB);
    }

    public void selecionarNivelDeAcesso(String dado){
        waitForElement(nivelDeAcessoSelect);
        Select select = new Select(nivelDeAcessoSelect);
        select.selectByVisibleText(dado);
    }

    public void clicarHabilitadoCheck(){
        waitForElement(habilitadoCheckCriarNovaConta);
        habilitadoCheckCriarNovaConta.click();
    }

    public void clicarProtegidoCheck(){
        waitForElement(protegidoCheck);
        protegidoCheck.click();
    }

    public void clicarCriarUsuario(){
        waitForElement(criarUsuarioButton);
        criarUsuarioButton.click();
    }

    public boolean retornaOperacaoComSucesso(){
        return operacaoComSucessoLabel.getText().contains("Clique aqui para prosseguir");
    }

    public boolean nomeDeUsuarioJaUtilizadoErrorCard(){
        waitForElement(nomeDeUsuarioJaUtilizadoErrorCard);
        return nomeDeUsuarioJaUtilizadoErrorCard.isDisplayed();
    }

    public boolean emailDeUsuarioJaUtilizadoErrorCard(){
        waitForElement(emailDeUsuarioJaUtilizadoErrorCard);
        return emailDeUsuarioJaUtilizadoErrorCard.isDisplayed();
    }

    public void clicarNaoUtilizadoButton(){
        waitForElement(naoUtilizadoButton);
        naoUtilizadoButton.click();
    }

    public boolean retornaSeUsuarioEstaNaListaDePesquisa(String nomeUsuario){
        waitForElement(listaDeUsuarioNaoUtilizados);
        ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(listaDeUsuarioNaoUtilizados);
        ArrayList<String> nomes = new ArrayList<>();
        for (WebElement loop:elements){
            nomes.add(loop.getText());
        }
        nomes.sort(Collections.reverseOrder());
        boolean result = false;
        for(String nome: nomes){
            if(nome.contains(nomeUsuario)){
                return true;
            }
        }

        return result;
    }

    public boolean retornaSeAListaDaPesquisaEstaVazia(){
        if(!returnIfElementExists(listaDeUsuarioNaoUtilizados)){
            return true;
        }
        return false;
    }

    public void preencherPesquisarUsuarioInputText(String dado){
        waitForElement(pesquisarUsuarioInputText);
        pesquisarUsuarioInputText.sendKeys(dado);
    }

    public void clicarAplicarFiltroButton(){
        waitForElement(aplicarFiltroButton);
        aplicarFiltroButton.click();
    }

    public boolean retornaNomeDeUsuarioLabelForm(){
        waitForElement(nomeDeUsuarioLabelForm);
        return nomeDeUsuarioLabelForm.getText().contains(Serenity.sessionVariableCalled("nomeUsuario"));
    }

    public void clicarNovoButton(){
        waitForElement(novoButton);
        novoButton.click();
    }

    public void clicarEmUsuarioPorNome(String dado){
        for (WebElement element: nomeDeUsuarioButtonVariavelList){
            if (element.getText().contains(dado)){
                element.click();
                break;
            }
        }
    }

    public void clicarHabilitadoCheckAlterarUsuario(){
        waitForElement(habilitadoCheckAlterarUsuario);
        habilitadoCheckAlterarUsuario.click();
    }

    public void clicarAtualizarUsuarioButtonAlterarUsuario(){
        waitForElement(atualizarUsuarioButtonAlterarUsuario);
        atualizarUsuarioButtonAlterarUsuario.click();
    }

    public void clicarMostrarDesativadosCheck(){
        waitForElement(mostrarDesativadosCheck);
        mostrarDesativadosCheck.click();
    }

    public void clickRepresentarUsuarioButtonAlterarUsuario(){
        waitForElement(representarUsuarioButtonAlterarUsuario);
        representarUsuarioButtonAlterarUsuario.click();
    }

    public void clickApagarUsuarioButtonAlterarUsuario(){
        waitForElement(apagarUsuarioButtonAlterarUsuario);
        apagarUsuarioButtonAlterarUsuario.click();
    }

    public void clickApagarContaConfirmaButtonAlterarUsuario(){
        waitForElement(apagarContaConfirmaButtonAlterarUsuario);
        apagarContaConfirmaButtonAlterarUsuario.click();
    }

    public boolean retornaSeUsuarioEVisivelNaPesquisa(String dado){
        for (WebElement element: nomeDeUsuarioButtonVariavelList){
            if (element.getText().contains(dado)){
                return true;
            }
        }

        return false;
    }

    public void clicarTodosButton(){
        waitForElement(todosButton);
        todosButton.click();
    }

    public void clicarPrimeiraLetraAlfabetoMenuSearchLista(String nome){
        String primeiraLetra = String.valueOf(nome.charAt(0));
        for(WebElement element:alfabetoMenuSearchLista){
            if(element.getText().equals(primeiraLetra)){
                element.click();
                break;
            }
        }
    }

    public void clicarRedefinirSenhaButton(){
        waitForElement(redefinirSenhaButton);
        redefinirSenhaButton.click();
    }
}
