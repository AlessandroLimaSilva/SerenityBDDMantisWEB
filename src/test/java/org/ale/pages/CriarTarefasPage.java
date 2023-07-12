package org.ale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CriarTarefasPage extends BasePage{

    @FindBy(xpath = "//select[@id='category_id']")
    private WebElement categoriaSelectButton;
    @FindBy(xpath = "//select[@id='category_id']")
    private WebElement categoriaOptions;

    @FindBy(xpath = "//select[@id='reproducibility']")
    private WebElement frequenciaOptions;

    @FindBy(xpath = "//select[@id='severity']")
    private WebElement gravidadeOptions;

    @FindBy(xpath = "//select[@id='priority']")
    private WebElement prioridadeOptions;

    @FindBy(xpath = "//select[@id='handler_id']")
    private WebElement atribuirAOptions;

    @FindBy(xpath = "//input[@id='summary']")
    private WebElement resumoInputText;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement descricaoInputText;

    @FindBy(xpath = "//input[@tabindex='15']")
    private WebElement visibilidadePublicoRadioButton;

    @FindBy(xpath = "//input[@tabindex='16']//following-sibling::span")
    private WebElement visibilidadePrivadoRadioButton;

    @FindBy(xpath = "//input[@tabindex='18']")
    private WebElement criarNovaTarefaButton;

    @FindBy(xpath = "//div[@class='alert alert-success center']")
    private WebElement operacaoComSucessoLabel;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p[contains(text(),'APPLICATION ERROR #11')]")
    private WebElement categoriaNaoInformadaError;

    public CriarTarefasPage(WebDriver driver) {
        super(driver);
    }

    public void selecionarCategoriaOptions(String nomeCategoria){
        selectOptionByTextJavaScript(categoriaOptions, nomeCategoria);
    }

    public void selecionarFrequenciaOptions(String nomeFrequencia){
        selectOptionByTextJavaScript(frequenciaOptions,nomeFrequencia);
    }

    public void selecionarGravidadeOptions(String nomeGravidade){
        selectOptionByTextJavaScript(gravidadeOptions,nomeGravidade);
    }

    public void selecionarPrioridadeOptions(String nomePrioridade){
        selectOptionByTextJavaScript(prioridadeOptions,nomePrioridade);
    }

    public void selecionarAtribuirAOptions(String nomeAtribuir){
        selectOptionByTextJavaScript(atribuirAOptions,nomeAtribuir);
    }

    public void preencherResumoInputText(String resumo){
        waitForElement(resumoInputText);
        resumoInputText.sendKeys(resumo);
    }

    public void preencherDescricaoInputText(String descricao){
        waitForElement(descricaoInputText);
        descricaoInputText.sendKeys(descricao);
    }

    public void selecionarVisibilidadeRadio(String estadoVisibilidade){
        if(estadoVisibilidade.contains("privado")){
            visibilidadePrivadoRadioButton.click();
        }
    }

    public void clicarCriarNovaTarefaButton(){
        waitForElement(criarNovaTarefaButton);
        criarNovaTarefaButton.click();
    }

    public boolean categoriaNaoInformadaErrorEVisivel(){
        waitForElement(categoriaNaoInformadaError);
        return categoriaNaoInformadaError.isDisplayed();
    }

    public boolean criarNovaTarefaButtonEVisivel(){
        waitForElement(criarNovaTarefaButton);
        return criarNovaTarefaButton.isDisplayed();
    }

}
