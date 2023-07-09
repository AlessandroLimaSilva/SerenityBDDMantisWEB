package org.ale.pages;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.core.pages.PageObject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage extends PageObject {

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public static final String VALUE = "value";

    // Variaveis globlais
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor javaScriptExecutor = null;
    protected long timeOutDefault;
    protected long implicitTimeOutDefault;

    // Construtor
    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.timeOutDefault = getWaitForTimeout().toMillis();
        this.implicitTimeOutDefault = getImplicitWaitTimeout().toMillis();
        this.wait = new WebDriverWait(driver, Duration.ofMillis(timeOutDefault));
        this.javaScriptExecutor = (JavascriptExecutor) driver;
        LOGGER.info("Driver Instanciado : "+driver.getClass().getSimpleName());
        validarURLS();
    }

    //Deletar apos validar as urls

    public static boolean isURLAvailable(String url) {
        try {
            new Socket(url, 80).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isPortAvailable(int port) {
        try {
            new Socket("localhost", port).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isURLAndPortAvailable(String url, int port) {
        try {
            new Socket(url, port).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void validarURLS() {
        ArrayList<String> url = new ArrayList<>();
        ArrayList<Integer> port = new ArrayList<>();
        url.add("mantisbt");
        url.add("mysql");
        url.add("selenium-hub");
        url.add("localhost");
        url.add("0.0.0.0");
        port.add(80);
        port.add(3306);
        port.add(4444);
        port.add(8989);
        port.add(3306);
        port.add(4444);
        for(String ur:url){
            for(Integer por:port){
                boolean isURLAvailable = isURLAvailable(ur);
                boolean isPortAvailable = isPortAvailable(por);
                boolean isURLAndPortAvailable = isURLAndPortAvailable(ur, por);

                //LOGGER.info(ur+" Acessivel: " + isURLAvailable+" e a porta : "+por+" ACESSIVEL : "+isPortAvailable);
                LOGGER.info(ur+" and port "+por+" ACESSIVEL: " + isURLAndPortAvailable);
            }
        }
    }

    //Deletar apos validar as urls
    public void setMessageLoggerInfo(String message){
        LOGGER.info(message);
    }



    //Utils
    //Custom Actions
    protected void waitUntilPageReady(){
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= timeOutDefault){
            if(javaScriptExecutor.executeScript("return document.readyState").toString() == "complete");{
                timeOut.stop();
                break;
            }
        }
    }

    protected WebElement waitForElement(By locator){
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    /*
    protected WebElement waitForElementByTime(By locator, int time){
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        waitTime.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }*/

    protected WebElement waitForElementDisabled(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element;
    }

    //Função usada para acessar os elementos que estão dentro de um #shadow-root
    //Ex:  WebElement root = driver.findElement(By.tagName("driver-app-shell"))---> elemento onde se encontra o shadow-root
    //     WebElement shadowRoot = expandShadowRootElement(root); ----> pegando os elementos que estão dentro do shadow-root
    protected WebElement expandShadowRootElement(By locator) {
        WebElement shadowRootElement = (WebElement) javaScriptExecutor.executeScript("return arguments[0].shadowRoot", waitForElement(locator));
        return shadowRootElement;
    }

    protected void click(By locator){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= timeOutDefault)
        {
            WebElement element = null;

            try
            {
                element = waitForElement(locator);
                element.click();
                timeOut.stop();
                return;
            }
            catch (StaleElementReferenceException e){
                continue;
            }
            catch(ElementClickInterceptedException e){
                continue;
            }
            catch (WebDriverException e){
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click"))
                {
                    continue;
                }

                throw e;
            }
        }

        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void sendKeys(By locator, String text){
        waitForElement(locator).sendKeys(text);
    }

    protected void sendKeysWithoutWaitVisible(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    protected void clear(By locator){
        WebElement webElement = waitForElement(locator);
        webElement.clear();
    }

    protected void clearAndSendKeys(By locator, String text){
        WebElement webElement = waitForElement(locator);
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(text);

    }

    protected void comboBoxSelectByVisibleText(By locator, String text){
        Select comboBox = new Select(waitForElement(locator));
        comboBox.selectByVisibleText(text);
    }

    protected void mouseOver(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(waitForElement(locator)).build().perform();
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        return text;
    }

    protected String getValue(By locator){
        String text = waitForElement(locator).getAttribute("value");
        return text;
    }

    protected boolean returnIfElementIsDisplayed(By locator){
        boolean result = waitForElement(locator).isDisplayed();
        return result;
    }

    protected boolean returnIfElementExists(By locator){
        boolean result = false;

        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
        }
        catch (Exception e)
        {

        }

        return result;
    }


    protected boolean returnIfElementIsEnabled(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        boolean result = driver.findElement(locator).isEnabled();
        return result;
    }

    protected boolean returnIfElementIsSelected(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        boolean result = driver.findElement(locator).isSelected();
        return result;
    }

    //Javascrip actions
    protected void sendKeysJavaScript(By locator, String value){
        WebElement element = waitForElement(locator);
        javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", element);
    }

    protected void sendKeysJavaScript(WebElement element, String value){
        waitForElement(element);
        javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", element);
    }

    protected void clickJavaScript(By locator){
        WebElement element = waitForElement(locator);
        javaScriptExecutor.executeScript("arguments[0].click();", element);;
    }

    protected void clickJavaScript(WebElement element){
        waitForElement(element);
        javaScriptExecutor.executeScript("arguments[0].click();", element);;
    }

    protected void scrollToElementJavaScript(By locator){
        WebElement element = waitForElement(locator);
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToElementJavaScript(WebElement element){
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToTop(){
        javaScriptExecutor.executeScript("window.scrollTo(0, 0);");
    }

    //Default actions
    public void refresh(){
        driver.navigate().refresh();
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public void openNewTab(){
        javaScriptExecutor.executeScript("window.open();");
    }
    public void closeTab(){
        driver.close();
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getURL(){
        String url = driver.getCurrentUrl();
        return url;
    }

    //###############################\#Metodos WebElements##################################

    //region Sincronização
    protected void waitLoadingScreen(WebElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        try
        {
            do
            {
                if (element.getAttribute("hidden") == "true")
                {
                    timeOut.stop();
                    return;
                }

            } while (timeOut.getTime() <= timeOutDefault);
        }
        catch (WebDriverException e)
        {

        }
    }

    protected void click(WebElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        while (timeOut.getTime() <= timeOutDefault)
        {
            //WebElement element = null;
            try
            {
                waitForElement(element);
                element.click();
                timeOut.stop();
                return;
            }
            catch (StaleElementReferenceException e) {
                continue;
            }
            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click")) {
                    continue;
                }
                throw e;
            }
        }
        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAndClickModal(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        click(element);
    }

    public String waitForAndReturnTextModal(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return getText(element);
    }

    public void elementIsDisplayed(WebElement element){
        element.isDisplayed();
        element.isEnabled();
    }

    protected  boolean waitForTextPresentElement(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitForElementToBeClickeable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /*
    protected void waitForElementByTime(WebElement element, long time){
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.visibilityOf(element));
    }*/

    protected void sendKeys(WebElement element, String text){
        waitForElement(element);
        element.sendKeys(text);

    }

    protected void sendKeysWithoutWaitVisible(WebElement element, String value){
        javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", element);
    }

    protected void clear(WebElement element){
        waitForElement(element);
        element.clear();
    }

    protected void clearAndSendKeys(WebElement element, String text){
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void clearAndSendKeysAlternative(WebElement element, String text){
        waitForElement(element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);

    }

    protected void enviarTeclaEnter(WebElement element){
        element.sendKeys(Keys.TAB);
    }

    protected String getText(WebElement element){
        waitForElement(element);
        return element.getText();
    }

    protected String getValue(WebElement element){
        waitForElement(element);
        return element.getAttribute("value");
    }

    protected boolean returnIfElementIsDisplayed(WebElement element){
        waitForElement(element);
        return element.isDisplayed();
    }

    protected boolean returnIfElementIsEnabled(WebElement element){
        waitForElement(element);
        return element.isEnabled();
    }

    protected boolean returnIfElementIsSelected(WebElement element){
        waitForElement(element);
        return element.isSelected();
    }

    //Meus metodos
    protected boolean retornaSeOElementoFoiMostrado(By locator){
        boolean result = waitForElement(locator).isDisplayed();
        return result;
    }

    protected void moveToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public void moveAndClickToActiveElement(By elemento){
        WebElement s = driver.switchTo().activeElement().findElement(elemento);
        s.click();
    }
    public void moveToContext(WebElement element){
        driver.switchTo().frame(element);
    }

    protected void moveToActivitContent(){
        driver.switchTo().activeElement();
    }

    public void selecionaUmaNovaPergunta(WebElement simConfirmarAtivacaoInteracaoButton){
        By teste = By.xpath("//span[contains(.,'')]//ancestor::td//ancestor::tr//td//button");
        List<WebElement> elemento = driver.findElements(teste);
        for (int y = 0;y < elemento.size();y++){
            if (elemento.get(y).getText().equalsIgnoreCase("Apurar")){
                click(elemento.get(y+2));
                waitForElement(simConfirmarAtivacaoInteracaoButton);
                click(simConfirmarAtivacaoInteracaoButton);
                return;
            }
        }
    }

    public void selecionaApurarAPerguntaAtiva(WebElement simConfirmarAtivacaoInteracaoButton){
        By teste = By.xpath("//span[contains(.,'')]//ancestor::td//ancestor::tr//td//button");
        List<WebElement> elemento = driver.findElements(teste);
        for (int y = 0;y < elemento.size();y++){
            if (elemento.get(y).getText().equalsIgnoreCase("Apurar")){
                click(elemento.get(y));
                waitForElement(simConfirmarAtivacaoInteracaoButton);
                click(simConfirmarAtivacaoInteracaoButton);
                return;
            }
        }
    }

    public void fecharPergunta(WebElement simConfirmarAtivacaoInteracaoButton){
        By teste = By.xpath("//span[contains(.,'')]//ancestor::td//ancestor::tr//td//button");
        List<WebElement> elemento = driver.findElements(teste);
        for (int y = 0;y < elemento.size();y++){
            if (elemento.get(y).getText().equalsIgnoreCase("Fechar")){
                click(elemento.get(y));
                waitForElement(simConfirmarAtivacaoInteracaoButton);
                click(simConfirmarAtivacaoInteracaoButton);
                return;
            }
        }
    }

    protected void removeElementJavaScriptWeb(WebElement locator){
        javaScriptExecutor.executeScript("arguments[0].remove();", locator);
    }

    public void eliminarBanner(String enderecoBanner) {
        String selector = "//div[@class='bg-carrousel']//a[@href]";
        List<WebElement> elemento = driver.findElements(By.xpath(selector));
        for(WebElement element:elemento){
            if(!element.getAttribute("href").equalsIgnoreCase(enderecoBanner)) {
                removeElementJavaScriptWeb(element);
            }
        }
    }

    public int onlyNumber(String dirty){
        String before = dirty.replaceAll("[a-zA-Z•()]", "").trim();
        return Integer.parseInt(before);
    }

    public WebElement retornaNovoWebElement(String xpath, String variavel){
        String troca = xpath.replace("###",variavel);
        By novoXpath = By.xpath(troca);
        WebElement element = driver.findElement(novoXpath);
        return element;
    }

    /*
    public void aguardarElementoWebElement(WebElement elementoWeb) {
        try {
            for(int x = 0;x < 40;x++){
                if (wait.until(ExpectedConditions.invisibilityOf(elementoWeb))){
                    WebDriverWait wait = new WebDriverWait(driver, 1);
                    LOGGER.info("Teste aguardarElementoWebElement =====   "+wait.until(ExpectedConditions.visibilityOf(elementoWeb)));
                }else {
                    break;
                }
            }
        } catch (WebDriverException ignored) {

        }
    }*/

    public void selecionarDownload() throws AWTException {

        //3 control 1 enter
        // hit enter
        Robot robot = new Robot();
        robot.delay(9000);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(5000);
        // switch back
        driver.switchTo().activeElement();
    }

    public void enviarKeyEnter() throws AWTException {
        Robot robot = new Robot();
        robot.delay(9000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void selectElementText(WebElement element, String text){
        Select seletor = new Select(element);
        seletor.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String text){
        Select seletor = new Select(element);
        seletor.selectByValue(text);
    }

    public void clicarEmOkPopUpAlert(){
        driver.switchTo().alert().accept();
    }

    public void anexarDocumentosFormularioCadastrarFornecedorJuridico(String docName) {
        WebElement label = driver.findElement(By.xpath("//input[@type='file']"));
        String win = System.getProperty("user.dir")+"\\src\\test\\resources\\upload\\"+docName;
        String unix = "/home/seluser/data/EspacoEmpresa/"+docName;
        String styleVisible = "visibility: visible; position: absolute; overflow: hidden; width: 500px; height: 200px; border: medium none; margin: 02px; padding: 02px;";
        String styleInvisible = label.getAttribute("style");

        //Habilita o botão de upload de arquivos
        javaScriptExecutor.executeScript("arguments[0].setAttribute('style', '" + styleVisible + "')", label);

        if (System.getProperty("os.name").contains("Windows 10")){
            label.sendKeys(win);
        }else {
            setMessageLoggerInfo("\n\n Caminho do Upload\n");
            setMessageLoggerInfo("\n path = "+System.getProperty("user.dir")+"\n");
            setMessageLoggerInfo(unix);
            label.sendKeys(unix);
        }

        //Desabilita o botao de upload de arquivos
        javaScriptExecutor.executeScript("arguments[0].setAttribute('style', '" + styleInvisible + "')", label);
        System.out.print("");
    }

    public void selectByText(WebElement element, String dado){
        Select select = new Select(element);
        select.selectByVisibleText(dado);
    }

    void preencherElement(By element, String dado){
        driver.findElement(element).click();
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(dado);
    }

    public void selectOptionByTextJavaScript(WebElement selectElement, String optionText) {
        String script = "var selectElement = arguments[0];" +
                "var optionText = arguments[1];" +
                "for (var i = 0; i < selectElement.options.length; i++) {" +
                "   if (selectElement.options[i].text.includes(optionText)) {" +
                "       selectElement.selectedIndex = i;" +
                "       break;" +
                "   }" +
                "}";
        javaScriptExecutor.executeScript(script, selectElement, optionText);
    }

    public void selectAndRefreshOptionByTextJavaScript(WebElement selectElement, String optionText) {
        String script = "var selectElement = arguments[0];" +
                "var optionText = arguments[1];" +
                "for (var i = 0; i < selectElement.options.length; i++) {" +
                "   if (selectElement.options[i].text.includes(optionText)) {" +
                "       selectElement.selectedIndex = i;" +
                "       break;" +
                "   }" +
                "}" +
                "var event = new Event('change');" +
                "selectElement.dispatchEvent(event);";
        javaScriptExecutor.executeScript(script, selectElement, optionText);
    }

    public static String encodeFileToBase64Binary(String caminho) {
        File file = new File(caminho);
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedfile;
    }

    public void injectImage(WebElement element,String imagemPath){

        //WebElement inputElement = driver.findElement(By.id("dropzone-preview-template"));
        WebElement inputElement = driver.findElement(By.cssSelector(".dropzone"));;
        String base= "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";
        String htmlCode = "<div id=\"dropzone-previews-box\" class=\"dropzone-previews dz-max-files-reached\">" +
                "<div class=\"dz-preview dz-image-preview\">" +
                "<div class=\"dz-filename\"><span data-dz-name=\"\">test.png</span></div>" +
                "<div><img data-dz-thumbnail=\"\" alt=\"test.png\" src=\"data:image/png;base64,$img;".replace("$img",encodeFileToBase64Binary(imagemPath));;
        String javascriptCode = "document.getElementById('dropzone-previews-box').innerHTML = " +
                "'<div id=\"dropzone-previews-box\" class=\"dropzone-previews dz-max-files-reached\">" +
                "<div class=\"dz-preview dz-image-preview\"><div class=\"dz-filename\"><span data-dz-name=\"\">test.png</span>" +
                "</div><div><img data-dz-thumbnail=\"\" alt=\"test.png\" src=\"data:image/png;base64,$img;".replace("$img",encodeFileToBase64Binary(imagemPath));;
        String javascriptCode2 = "var dropzonePreviewsBox = document.getElementById('dropzone-previews-box');" +
                ("dropzonePreviewsBox.innerHTML = '<div id=\"dropzone-previews-box\" " +
                        "class=\"dropzone-previews dz-max-files-reached\">" +
                        "<div class=\"dz-preview dz-image-preview\">" +
                        "<div class=\"dz-filename\"><span data-dz-name=\"\">test.png</span>" +
                        "</div><div><img data-dz-thumbnail=\"\" alt=\"test.png\" src=\"data:image/png;base64,$imagem</div></div>'").replace("$imagem",encodeFileToBase64Binary(imagemPath));
        String base64Image = "data:image/png;base64,$img=".replace("$img",encodeFileToBase64Binary(imagemPath));
        String javascriptCodee = "var dropzonePreviewsBox = document.getElementById('dropzone-previews-box');" +
                "dropzonePreviewsBox.innerHTML = '" +
                "<div class=\"dz-preview dz-image-preview\">" +
                "<div class=\"dz-filename\">" +
                "<span data-dz-name=\"\">test.png</span></div>" +
                "<div>" +
                "<img data-dz-thumbnail=\"\" alt=\"test.png\" src=\"data:image/png;base64," + base + "\">" +
                "</div></div>'";

        String z = "var dropzonePreviewsBox = document.getElementById('dropzone-previews-box');" +
                "dropzonePreviewsBox.innerHTML = '<div class=\"dz-preview dz-image-preview\">" +
                "<div class=\"dz-filename\"><span data-dz-name=\"\">test.png</span></div>" +
                "<div><img data-dz-thumbnail=\"\" alt=\"test.png\" src=\"data:image/png;base64,"+encodeFileToBase64Binary(imagemPath)+"=\"></div>" +
                "<div class=\"dz-size\" data-dz-size=\"\"><strong>40.6</strong> KB</div>" +
                "<div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress=\"\"></div></div>" +
                "<div class=\"dz-success-mark\"><span></span></div>" +
                "<div class=\"dz-error-mark\"><span></span></div>" +
                "<div class=\"dz-error-message\"><span data-dz-errormessage=\"\"></span></div>" +
                "<a class=\"dz-remove\" href=\"javascript:undefined;\" data-dz-remove=\"\">Remover arquivo</a></div>';";



        String script = "var img = document.createElement('img');".concat(
                "img.src = 'data:image/png;base64,$imagem';").concat(
                "arguments[0].appendChild(img);").replace("$imagem",encodeFileToBase64Binary(imagemPath));

        String script2 = "var img = document.createElement('img');" +
                "img.src = 'data:image/png;base64," + base64Image + "';" +
                "arguments[0].appendChild(img);";
        //<img data-dz-thumbnail="" alt="test.png" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAWEAAAEaCAYAAADAGubVAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpFQjhFMjk1MURERjIxMUU1OTM1Q0IwNDE3OTNDOEQwQSIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpFQjhFMjk1MkRERjIxMUU1OTM1Q0IwNDE3OTNDOEQwQSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkVCOEUyOTRGRERGMjExRTU5MzVDQjA0MTc5M0M4RDBBIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkVCOEUyOTUwRERGMjExRTU5MzVDQjA0MTc5M0M4RDBBIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+1HQ7RwAAmzlJREFUeNrsXQW4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">
        String script3 = "var img = document.createElement('img');"
                + "img.src = 'src/test/resources/imagem/test.png';"
                + "var dropzone = document.querySelector('.dropzone');"
                + "dropzone.appendChild(img);";

        javaScriptExecutor.executeScript(z);
    }

    private static byte[] loadFileData(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void injectCheckInRadio(WebElement element){
        javaScriptExecutor.executeScript("arguments[0].setAttribute('checked', 'checked');",element);
    }
}