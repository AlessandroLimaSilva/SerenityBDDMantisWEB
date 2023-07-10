package org.ale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GerenciarProjetosPage extends BasePage{

    private static final Logger LOGGER = LoggerFactory.getLogger(GerenciarProjetosPage.class);


    @FindBy(xpath = "//div[@class='widget-toolbox padding-8 clearfix']//form//fieldset")
    private WebElement criarNovoProjetoButton;

    @FindBy(xpath = "//td//input[@id='project-name']")
    private WebElement nomeDoProjetoInputText;

    @FindBy(xpath = "//select[@id='project-status']")
    private WebElement estadoDoProjetoSelect;

    @FindBy(xpath = "//input[@id='project-inherit-global']//following-sibling::span")
    private WebElement herdarHabilidadesGlobaisCheck;

    @FindBy(xpath = "//select[@id='project-view-state']")
    private WebElement visibilidadeDoProjetoSelect;

    @FindBy(xpath = "//textarea[@id='project-description']")
    private WebElement descricaoDoProjetoTextArea;

    @FindBy(xpath = "//div[@class='widget-toolbox padding-8 clearfix']//input[@type='submit']")
    private WebElement adicionarProjetoButton;

    @FindBy(xpath = "//div[@class='alert alert-success center']")
    private WebElement operacaoComSucessoLabel;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p[contains(text(),'APPLICATION ERROR #701')]")
    private WebElement nomeDeProjetoJaUtilizadoErrorCard;

    @FindBy(xpath = "//form[@action='manage_proj_cat_add.php']//input[@class='input-sm']")
    private WebElement adicionarNovaCategoriaInputText;

    @FindBy(xpath = "(//form[@action='manage_proj_cat_add.php']//input[@class='btn btn-primary btn-sm btn-white btn-round'])[1]")
    private WebElement adicionarNovaCategoriaButton;

    @FindBy(xpath = "//div[@class='alert alert-sucess center'//p[@class='bold bigger-110']")
    private WebElement operacaoRealizadaComSucessoAlert;

    @FindBy(xpath = "//div[@id='project-delete-div']//input[@type='submit']")
    private WebElement apagarProjetoButtonEditarProjeto;

    @FindBy(xpath = "//div[@class='alert alert-warning center']//input[@type='submit']")
    private WebElement confirmarApagarProjetoButton;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-condensed table-hover']//tr//td//a")
    private List<WebElement> listaNomeDeProjetos;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-condensed table-hover']//ancestor::tr//td//i//ancestor::tr//td//a")
    private List<WebElement> listaProjetosHabilitados;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-condensed table-hover']//ancestor::a//ancestor::tr//td[@class='center' and text()]//ancestor::tr//td//a")
    private List<WebElement> listaProjetosDesabilitados;

    @FindBy(xpath = "//input[@id='project-enabled']//following-sibling::span")
    private WebElement habilitadoCheckEditarProjeto;

    @FindBy(xpath = "//div[@id='manage-proj-update-div']//div[@class='widget-toolbox padding-8 clearfix']//input[@type='submit']")
    private WebElement atualizarProjetoButtonEditarProjeto;

    @FindBy(xpath = "//tr//td[contains(text(),'')]//following-sibling::td//button[text()='Apagar']")
    private List<WebElement> categoriasGlobaisApagarListButton;

    @FindBy(xpath = "//tr//td[contains(text(),'')]//following-sibling::td//button[text()='Alterar']")
    private List<WebElement> categoriasGlobaisAlterarListButton;

    @FindBy(xpath = "//div[@id='categories']//table[@class='table table-striped table-bordered table-condensed table-hover']//tbody//tr//td[1]")
    private List<WebElement> categoriasGlobaisCategoriaLabelList;

    @FindBy(xpath = "//input[@class='btn btn-primary btn-white btn-round']")
    private WebElement confirmarApagarCategoriaButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p[contains(text(),'APPLICATION ERROR #1500')]")
    private WebElement nomeDeCategoriaGlobalJaUtilizadoErroCard;

    @FindBy(xpath = "//input[@id='proj-category-name']")
    private WebElement nomeDaCategoriaAlterarInput;

    @FindBy(xpath = "//input[@value='Atualizar Categoria']")
    private WebElement atualizarCategoriaButton;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Subprojeto')]")
    private WebElement criarNovoSubProjetoButton;

    @FindBy(xpath = "//input[@id='project-name']")
    private WebElement nomeDoSubProjetoInputText;

    @FindBy(xpath = "//input[@value='Adicionar projeto']")
    private WebElement adicionarSubProjetoButton;

    @FindBy(xpath = "//form[@id='manage-project-update-subprojects-form']//tr//td[1]//a")
    private List<WebElement> nomeSubProjetoListLabel;

    @FindBy(xpath = "//form[@id='manage-project-update-subprojects-form']//td//a//ancestor::td//div[@class='inline']//a[text()='Desvincular']")
    private List<WebElement> desvincularSubProjetoListButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private WebElement categoriaErrorLabel;

    @FindBy(xpath = "//select[@id='proj-category-assigned-to']")
    private WebElement atribuidoASelectButton;

    @FindBy(xpath = "//select[@id='proj-category-assigned-to']//option")
    private List<WebElement> atribuidoASelectList;

    private String categoriaNameTableFormPath = "//div[@id='categories']//tbody//tr//td[text()='###']";
    private String nomeDoProjetoButtonLinkPath = "//table[@class='table table-striped table-bordered table-condensed table-hover']//a[text()='###']";
    private String projetoHabilitadoLinkPath = "//table[@class='table table-striped table-bordered table-condensed table-hover']//ancestor::tr//td//i//ancestor::tr//td//a[text()='###']";
    private String projetoDesabilitadoLinkPath = "//table[@class='table table-striped table-bordered table-condensed table-hover']//ancestor::a[text()='###']//ancestor::tr//td[@class='center' and text()]//ancestor::tr//td//a";
    private String estadoDoProjetoFormPath = "(//table[@class='table table-striped table-bordered table-condensed table-hover']//a[text()='###']//ancestor::td//following-sibling::td)[1]";
    private String visiblidadeDoProjetoFormPath = "(//table[@class='table table-striped table-bordered table-condensed table-hover']//a[text()='###']//ancestor::td//following-sibling::td)[3]";

    public GerenciarProjetosPage(WebDriver driver) {
        super(driver);
    }

    public void clicarCriarNovoProjetoButton(){
        waitForElement(criarNovoProjetoButton);
        criarNovoProjetoButton.click();
    }

    public void preencherNomeDoProjetoInputText(String dado){
        waitForElement(nomeDoProjetoInputText);
        nomeDoProjetoInputText.sendKeys(dado);
    }

    public void selecionarEstadoDoProjetoSelect(String dado){
        waitForElement(estadoDoProjetoSelect);
        selectByText(estadoDoProjetoSelect,dado);
    }

    public void clicarHerdarHabilidadesGlobaisCheck(){
        waitForElement(herdarHabilidadesGlobaisCheck);
        herdarHabilidadesGlobaisCheck.click();
    }

    public void selecionarVisibilidadeDoProjetoSelect(String dado){
        waitForElement(visibilidadeDoProjetoSelect);
        selectByText(visibilidadeDoProjetoSelect,dado);
    }

    public void preencherDescricaoDoProjetoTextArea(String dado){
        waitForElement(descricaoDoProjetoTextArea);
        descricaoDoProjetoTextArea.sendKeys(dado);
    }

    public void clicarAdicionarProjetoButton(){
        waitForElement(adicionarProjetoButton);
        adicionarProjetoButton.click();
    }

    public String retornaOperacaoComSucesso(){
        return operacaoComSucessoLabel.getText();
    }

    public String nomeDeProjetoJaUtilizadoErrorCard(){
        waitForElement(nomeDeProjetoJaUtilizadoErrorCard);
        return nomeDeProjetoJaUtilizadoErrorCard.getText();
    }

    public boolean nomeDeCategoriaGlobalJaUtilizadoErroCard(){
        waitForElement(nomeDeCategoriaGlobalJaUtilizadoErroCard);
        return nomeDeCategoriaGlobalJaUtilizadoErroCard.isDisplayed();
    }

    public void preencherAdicionarNovaCategoria(String dado){
        waitForElement(adicionarNovaCategoriaInputText);
        adicionarNovaCategoriaInputText.sendKeys(dado);
    }

    public void clicarAdicionarNovaCategoriaButton(){
        waitForElement(adicionarNovaCategoriaButton);
        adicionarNovaCategoriaButton.click();
    }

    public String retornaCategoriaNomeTableFormPath(String dado){
        LOGGER.info("Dado = ".concat(dado));
        WebElement element = retornaNovoWebElement(categoriaNameTableFormPath,dado);
        waitForElement(element);
        return element.getText();
    }

    public String retornarErrorLabelCampoDaCategoriaGlobal(){
        waitForElement(categoriaErrorLabel);
        return categoriaErrorLabel.getText();
    }

    public void clicarNomeDoProjetoButtonLink(String dado){
        WebElement element = retornaNovoWebElement(nomeDoProjetoButtonLinkPath,dado);
        waitForElement(element);
        element.click();
    }

    public void clicarApagarProjetoButtonEditarProjeto(){
        waitForElement(apagarProjetoButtonEditarProjeto);
        apagarProjetoButtonEditarProjeto.click();
    }

    public void clicarConfirmarApagarProjetoButton(){
        waitForElement(confirmarApagarProjetoButton);
        confirmarApagarProjetoButton.click();
    }

    public boolean retornaSeUmProjetoNaoExiste(String dado){
        waitForElement(criarNovoProjetoButton);
        for (WebElement loop:listaNomeDeProjetos){
            if(loop.getText().equalsIgnoreCase(dado)){
                return false;
            }
        }
        return true;
    }

    public void clicarProjetoHabilitadoLink(String dado){
        WebElement element = retornaNovoWebElement(projetoHabilitadoLinkPath,dado);
        waitForElement(element);
        element.click();
    }

    public void clicarProjetoDesabilitadoLink(String dado){
        WebElement element = retornaNovoWebElement(projetoDesabilitadoLinkPath,dado);
        waitForElement(element);
        element.click();
    }

    public void clicarhabilitadoCheckEditarProjeto(){
        waitForElement(habilitadoCheckEditarProjeto);
        habilitadoCheckEditarProjeto.click();
    }

    public void clicarAtualizarProjetoButtonEditarProjeto(){
        waitForElement(atualizarProjetoButtonEditarProjeto);
        atualizarProjetoButtonEditarProjeto.click();
    }

    public boolean retornaProjetoDesabilitado(String dado){
        WebElement element = retornaNovoWebElement(projetoDesabilitadoLinkPath, dado);
        waitForElement(element);
        return element.isDisplayed();
    }

    public boolean retornaProjetoHabilitado(String dado){
        WebElement element = retornaNovoWebElement(projetoHabilitadoLinkPath, dado);
        waitForElement(element);
        return element.isDisplayed();
    }

    public boolean retornaEstadoDoProjeto(String dado,String tipoEstado){
        WebElement element = retornaNovoWebElement(estadoDoProjetoFormPath,dado);
        waitForElement(element);
        return element.getText().contains(tipoEstado);
    }

    public boolean retornaVisibilidadeDoProjeto(String dado,String tipoVisibilidade){
        WebElement element = retornaNovoWebElement(visiblidadeDoProjetoFormPath,dado);
        waitForElement(element);
        return element.getText().contains(tipoVisibilidade);
    }

    public void clicarApagarCategoriaDeCategoriaGlobal(String categoria){
        try{
            for (int y = 0; y < categoriasGlobaisCategoriaLabelList.size();y++){
                if (categoriasGlobaisCategoriaLabelList.get(y).getText().equals(categoria)){
                    categoriasGlobaisApagarListButton.get(y).click();
                    break;
                }
                if (y == (categoriasGlobaisCategoriaLabelList.size()-1)){
                    throw new WebDriverException();
                }
            }
        }catch (WebDriverException web){
            throw new WebDriverException(web.getMessage()+"\nCategoria Global nao encontrada : "+categoria);
        }

    }

    public void clicarAlterarCategoriaDeCategoriaGlobal(String categoria){
        try{
            for (int y = 0; y < categoriasGlobaisCategoriaLabelList.size();y++){
                if (categoriasGlobaisCategoriaLabelList.get(y).getText().equals(categoria)){
                    categoriasGlobaisAlterarListButton.get(y).click();
                    break;
                }
                if (y == (categoriasGlobaisCategoriaLabelList.size()-1)){
                    throw new WebDriverException();
                }
            }
        }catch (WebDriverException web){
            throw new WebDriverException(web.getMessage()+"\nCategoria Global nao encontrada : "+categoria);
        }

    }

    public void clicarConfirmarApagarCategoriaButton(){
        waitForElement(confirmarApagarCategoriaButton);
        confirmarApagarCategoriaButton.click();
    }

    public void clicarCriarNovoSubProjetoButton(){
        waitForElement(criarNovoSubProjetoButton);
        criarNovoSubProjetoButton.click();
    }

    public void preencherNomeDoSubProjetoInputText(String dado){
        waitForElement(nomeDoSubProjetoInputText);
        nomeDoSubProjetoInputText.sendKeys(dado);
    }

    public void clicarAdicionarSubProjetoButton(){
        waitForElement(adicionarSubProjetoButton);
        adicionarSubProjetoButton.click();
    }

    public void clicarDesvincularSubProjetoButton(String subprojeto){
        for(int x = 0;x < nomeSubProjetoListLabel.size();x++){
            waitForElement(nomeSubProjetoListLabel.get(x));
            if(nomeSubProjetoListLabel.get(x).getText().equals(subprojeto)){
                desvincularSubProjetoListButton.get(x).click();
                break;
            }
        }
    }

    public void preencherNomeDaCategoriaAlterarInput(String dado){
        waitForElement(nomeDaCategoriaAlterarInput);
        nomeDaCategoriaAlterarInput.clear();
        nomeDaCategoriaAlterarInput.sendKeys(dado);
    }

    public void clicarAtualizarCategoriaButton(){
        waitForElement(atualizarCategoriaButton);
        atualizarCategoriaButton.click();
    }

    public void selecionarAtribuidoASelect(String nome){
        waitForElement(atribuidoASelectButton);
        atribuidoASelectButton.click();
        for(WebElement element: atribuidoASelectList){
            if(element.getText().contains(nome)){
                element.click();
                break;
            }
        }

    }


}
