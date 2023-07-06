package org.ale.pages;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VerTarefaPage extends BasePage{

    @FindBy(xpath = "//td[@class='column-id']//a")
    private List<WebElement> numeroTarefaFormList;

    @FindBy(xpath = "//a[@href='print_all_bug_page.php']")
    private WebElement imprimirTarefasButton;

    @FindBy(xpath = "//select[@name='handler_id']")
    private WebElement atribuirAOptions;

    @FindBy(xpath = "//input[@value='Atribuir a:']")
    private WebElement atribuirAButton;

    @FindBy(xpath = "//td[@class='bug-assigned-to']//a")
    private WebElement atribuidoALabel;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-white btn-round btn-sm' and contains(text(),'lembrete')]")
    private WebElement enviarUmLembreteButton;

    @FindBy(xpath = "//select[@id='recipient']")
    private WebElement enviarLembreteParaSelect;

    @FindBy(xpath = "//textarea[@name='body']")
    private WebElement lembreteTextAreaInput;

    @FindBy(xpath = "//input[@value='Enviar']")
    private WebElement enviarLembreteButton;

    @FindBy(xpath = "//div[@class='alert alert-success center']")
    private WebElement operacaoComSucessoLabel;

    @FindBy(xpath = "//select[@name='tag_select']")
    private WebElement marcadoresAtuaisSelect;

    @FindBy(xpath = "//select[@name='tag_select']//option")
    private List<WebElement> marcadoresAtuaisOptions;

    @FindBy(xpath = "//input[@value='Aplicar']")
    private WebElement aplicarMarcadorButton;

    @FindBy(xpath = "//td[@class='bug-tags']//a")
    private List<WebElement> marcadoresAplicadosButtonList;

    @FindBy(xpath = "//input[@id='tag_string']")
    private WebElement aplicaMarcadoresInputText;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private WebElement categoriaErrorLabel;

    @FindBy(xpath = "//select[@name='new_status']")
    private WebElement alterarStatusSelect;
    @FindBy(xpath = "//input[@value='Alterar Status:']")
    private WebElement alterarStatusButton;

    @FindBy(xpath = "//td[@class='bug-status']")
    private WebElement estadoStatusFormLabel;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement alterarStatusFinalizarMorphButton;

    @FindBy(xpath = "//form[@action='bug_report_page.php']//input[@type='submit']")
    private WebElement criarCloneButton;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement criarNovaTarefaButton;

    @FindBy(xpath = "//form[@action='bug_change_status_page.php']//fieldset//input[@type='submit']")
    private WebElement fecharTarefaButton;

    @FindBy(xpath = "//form[@action='bug_change_status_page.php']//fieldset//input[@type='submit']")
    private WebElement reabrirTarefaButton;

    @FindBy(xpath = "//input[@value='DELETE']//following-sibling::input")
    private WebElement apagarTarefaButton;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement confirmarApagarTarefaButton;

    @FindBy(xpath = "//input[@name='bug_id']")
    private WebElement barraDePesquisaTopBarDireito;

    @FindBy(xpath = "//td[@class='bug-id']")
    private WebElement numeroDaTarefaTextFormVerTarefa;

    @FindBy(xpath = "//select[@name='rel_type']")
    private WebElement estaTarefaSelect;

    @FindBy(xpath = "//input[@name='add_relationship']")
    private WebElement adicionarRelacaoButton;

    @FindBy(xpath = "//input[@name='dest_bug_id']")
    private WebElement relacaoInputText;

    @FindBy(xpath = "//table//td//a[starts-with(@href, 'view.php')]")
    private WebElement numeroDaTarefaRelacaoFormList;

    @FindBy(xpath = "//input[@id='bug_monitor_list_username']")
    private WebElement nomeDeUsuarioInputText;

    @FindBy(xpath = "//input[@id='bug_monitor_list_username']//following-sibling::input")
    private WebElement adicionarUsuarioMonitorandoTarefaButton;

    @FindBy(xpath = "//td//div//a[starts-with(@href, 'http://')]")
    private WebElement usuarioMonitorandoTarefaListLabel;

    private String selecionarTarefaFormListPath = "//td[@class='column-id']//a[contains(text(),'$var')]//ancestor::tr//td[@class='column-selection']//input";

    public VerTarefaPage(WebDriver driver) {
        super(driver);
    }

    public void clicarNumeroTarefaFormList(String numeroTarefa){
        for(WebElement element: numeroTarefaFormList){
            waitForElement(element);
            if(element.getText().contains(numeroTarefa)){
                element.click();
                break;
            }
        }
    }

    public void selecionarTarefaFormList(String numeroTarefa){
        WebElement element = driver.findElement(By.xpath(selecionarTarefaFormListPath.replace("$var",numeroTarefa)));
        waitForElement(element);
        element.click();
    }

    public void clicarImprimirTarefasButton(){
        waitForElement(imprimirTarefasButton);
        imprimirTarefasButton.click();
    }

    public void selecionarAtribuirASelect(String nome){
        selectOptionByTextJavaScript(atribuirAOptions,nome);
    }

    public void clicarAtribuirAButton(){
        waitForElement(atribuirAButton);
        atribuirAButton.click();
    }

    public String getTextAtribuidoALabel(){
        waitForElement(atribuidoALabel);
        return atribuidoALabel.getText();
    }

    public void clicarEnviarUmLembreteButton(){
        waitForElement(enviarUmLembreteButton);
        enviarUmLembreteButton.click();
    }

    public void enviarLembreteParaSelect(String nomeUsuario){
        selectOptionByTextJavaScript(enviarLembreteParaSelect,nomeUsuario);
    }

    public void preencherLembreteTextAreaInput(String mensagem){
        waitForElement(lembreteTextAreaInput);
        lembreteTextAreaInput.sendKeys(mensagem);
    }

    public void clicarEnviarLembreteButton(){
        waitForElement(enviarLembreteButton);
        enviarLembreteButton.click();
    }

    public String retornaOperacaoComSucesso(){
        return operacaoComSucessoLabel.getText();
    }

    public void selecionarMarcadoresAtuaisSelect(String marcador){
        //waitForElement(marcadoresAtuaisSelect);
        //marcadoresAtuaisSelect.click();
        /*for(WebElement element: marcadoresAtuaisOptions){
            if(element.getText().contains(marcador)){
                element.click();
                break;
            }
        }*/
        selectAndRefreshOptionByTextJavaScript(marcadoresAtuaisSelect,marcador);
        Actions actions = new Actions(driver);
        actions.moveToElement(marcadoresAtuaisSelect)
                .click()
                .sendKeys(marcador)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void preencherAplicaMarcadoresInputText(String marcador){
        waitForElement(aplicaMarcadoresInputText);
        aplicaMarcadoresInputText.sendKeys(marcador);
    }

    public void clicarAplicarMarcadorButton(){
        waitForElement(aplicarMarcadorButton);
        aplicarMarcadorButton.click();
    }

    public boolean getTextMarcadoresAplicadosButtonList(String marcador){
        for(WebElement element: marcadoresAplicadosButtonList){
            waitForElement(element);
            if(element.getText().contains(marcador)){
                element.click();
                return true;
            }
        }
        return false;
    }

    public String getTextCategoriaErrorLabel(){
        waitForElement(categoriaErrorLabel);
        return categoriaErrorLabel.getText();
    }

    public void selecionarAlterarStatusSelect(String status){
        selectAndRefreshOptionByTextJavaScript(alterarStatusSelect,status);
    }

    public void clicarAlterarStatusButton(){
        waitForElement(alterarStatusButton);
        alterarStatusButton.click();
    }

    public String getTextEstadoStatusFormLabel(){
        waitForElement(estadoStatusFormLabel);
        return estadoStatusFormLabel.getText();
    }

    public void clicarAlterarStatusFinalizarMorphButton(){
        waitForElement(alterarStatusFinalizarMorphButton);
        alterarStatusFinalizarMorphButton.click();
    }

    public void clicarCriarCloneButton(){
        waitForElement(criarCloneButton);
        criarCloneButton.click();
    }

    public void clicarCriarNovaTarefaButton(){
        waitForElement(criarNovaTarefaButton);
        criarNovaTarefaButton.click();
    }

    public void clicarFecharTarefaButton(){
        waitForElement(fecharTarefaButton);
        fecharTarefaButton.click();
    }
    public void clicarReabrirTarefaButton(){
        waitForElement(reabrirTarefaButton);
        reabrirTarefaButton.click();
    }

    public void clicarApagarTarefaButton(){
        waitForElement(apagarTarefaButton);
        apagarTarefaButton.click();
    }

    public void clicarConfirmarApagarTarefaButton(){
        waitForElement(confirmarApagarTarefaButton);
        confirmarApagarTarefaButton.click();
    }

    public boolean confirmarSeTarefaExiste(){
        if(driver.findElements(
                By.xpath(
                        selecionarTarefaFormListPath.replace("$var",
                                Serenity.setSessionVariable("TAREFA_ID").
                                        toString()))).isEmpty()){
            return true;
        }
        return false;
    }

    public void preencherBarraDePesquisaTopBarDireito(String numeroTarefa){
        waitForElement(barraDePesquisaTopBarDireito);
        barraDePesquisaTopBarDireito.sendKeys(numeroTarefa,Keys.ENTER);
    }

    public String getTextNumeroDaTarefaTextFormVerTarefa(){
        waitForElement(numeroDaTarefaTextFormVerTarefa);
        return numeroDaTarefaTextFormVerTarefa.getText();
    }

    public void selecionarEstaTarefaSelect(String relacao){
        waitForElement(estaTarefaSelect);
        selectAndRefreshOptionByTextJavaScript(estaTarefaSelect,relacao);
    }

    public void clicarAdicionarRelacaoButton(){
        waitForElement(adicionarRelacaoButton);
        adicionarRelacaoButton.click();
    }

    public void preencherRelacaoInputText(String numeroTarefa){
        waitForElement(relacaoInputText);
        relacaoInputText.sendKeys(numeroTarefa);
    }

    public String getTextNumeroDaTarefaRelacaoFormList(){
        waitForElement(numeroDaTarefaRelacaoFormList);
        return numeroDaTarefaRelacaoFormList.getText();
    }

    public void preencherNomeDeUsuarioInputText(String usuario){
        waitForElement(nomeDeUsuarioInputText);
        nomeDeUsuarioInputText.sendKeys(usuario);
    }

    public void clicarAdicionarUsuarioMonitorandoTarefaButton(){
        waitForElement(adicionarUsuarioMonitorandoTarefaButton);
        adicionarUsuarioMonitorandoTarefaButton.click();
    }

    public String getTextUsuarioMonitorandoTarefaListLabel(){
        waitForElement(usuarioMonitorandoTarefaListLabel);
        return usuarioMonitorandoTarefaListLabel.getText();
    }
}
