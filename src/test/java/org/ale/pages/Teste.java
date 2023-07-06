package org.ale.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

public class Teste {

    /*
    void novo(String dado){
        try{
            File path = new File("C:/Users/ryzen/Documents/RepositorioBdd/QADesempenho/trunk/jmeter-portal-arena/src/test/jmeter/selenium/error.txt");
            FileUtils.writeStringToFile(path,dado+";\n",true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    boolean isElementPresent(By by, String mensagem) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by);
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    void getScreenshot (String pictureName,String downloadFilepath, ChromeDriver driver){
        try{
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(downloadFilepath+pictureName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void syncThread(int thread,int totalThread,int rampUpTotal){
        try{
            //int totalThread quantidade total de threads
            //int rampUpTotal quantidade total do tempo de rampup
            //Calcula o intervalo de tempo de unidade
            int rampUpUnity = ((rampUpTotal / totalThread) * thread);
            //Calcula o tempo de espera para a sincronia de uma unidade
            int timeSync = (((rampUpTotal - rampUpUnity) * 1000) +10);
            //Realiza o tempo de espera para sincronizar as unidades
            log.info("\n################## Entrando no sync\n################## Thread = "+thread+"\n################## RampUp de Unidade = "+rampUpUnity+"\n################## Tempo de sync = "+timeSync);
            Thread.sleep(timeSync);
            log.info("\n################## Saindo da sync           USUARIO VIRTUAL       ##################  Thread = "+thread);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void intervaloDeVotacao(int thread,int totalThread,int tempoTotal){
        try{
            //int totalThread quantidade total de threads
            //int rampUpTotal Tempo de espera Total quantidade total do tempo de rampup
            //Calcula o intervalo de tempo de unidade
            //Calcula o tempo de espera para a sincronia de uma unidade
            log.info("\n################## ENTRANDO NO INTERVALO VOTAÇÃO   USUARIO VIRTUAL       ##################  Thread = "+thread);
            int tempoUnitario = ((tempoTotal / totalThread) * thread);
            //Calcula o tempo de espera para a sincronia de uma unidade

            int time = (((tempoTotal - tempoUnitario) + 1) * 1000);
            //Realiza o tempo de espera para sincronizar as unidades
            Thread.sleep(time);
            log.info("\n################## SAINDO INTERVALO VOTAÇÃO   USUARIO VIRTUAL       ##################  Thread = "+thread);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void teste(){
        try {
            //================================================================
            // FAZER LOGIN NO PORTAL COOPERADO
            //================================================================
            //Acessar pagina de login

            driver.get(URL);
            Thread.sleep(waitPage);
            Thread.sleep(12000);
            driver.findElement(By.xpath("//input[@name='username']")).click();
            driver.findElement(By.xpath("//input[@name='username']")).clear();
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USUARIO);

            //PROD
            driver.findElement(By.xpath("//input[@id='password']")).click();
            driver.findElement(By.xpath("//input[@id='password']")).clear();
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(SENHA);

            //HML
            //driver.findElement(By.id("password")).click();
            //driver.findElement(By.id("password")).clear();
            //driver.findElement(By.id("password")).sendKeys(SENHA);


            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
            log.info("### USUÁRIO "+USUARIO+": CLICOU EM ENTRAR ###");
            Thread.sleep(waitPage);


            try{
                By login = By.xpath("//span[text() = 'Site do Cooperado']");
                erroMsg = "### USUÁRIO:"+USUARIO+" NÃO LOGOU ###";
                if(isElementPresent(login,driver,wait,erroMsg)){
                    log.info("### USUÁRIO "+USUARIO+": LOGOU NO PORTAL ###");
                }
            } catch (Exception e) {
                novo(USUARIO);
                driver.quit();
                e.printStackTrace();
                throw new IOException();
            }
            Thread.sleep(3000);

            try{
                ////div[@class='modal-content']//button[contains(text(),'Estou')]
                By aceiteBtn = By.xpath("//div[@class='modal-content']//button[contains(text(),'Estou')]");
                erroMsg = "### USUÁRIO:"+USUARIO+" NÃO ACHOU TERMO DE ACEITE ###";
                if(isElementPresent(aceiteBtn,driver,wait,erroMsg)){
                    log.info("### USUÁRIO "+USUARIO+": ACHO O TERMO DE ACEITE NO PORTAL ###");
                    driver.findElement(aceiteBtn).click();
                }
            } catch (Exception e) {
                driver.quit();
                e.printStackTrace();
            }

	/*
	Thread.sleep(3000);
	////div[@class='modal-content']//button[contains(text(),'Estou')]
	By aceiteBtn = By.xpath("//div[@class='modal-content']//button[contains(text(),'Estou')]");
	erroMsg = "### USUÁRIO:"+USUARIO+" NÃO ACHOU TERMO DE ACEITE ###";
	if(isElementPresent(aceiteBtn,driver,wait,erroMsg)){
		log.info("### USUÁRIO "+USUARIO+": ACHO O TERMO DE ACEITE NO PORTAL ###");
		driver.findElement(aceiteBtn).click();
	}else{
		driver.quit();
	}*/
    /*

            //Finalizado com Sucesso!
            driver.quit();
            SampleResult.setSuccessful(true);
            SampleResult.setResponseMessage("Finalizado com sucesso! VIRTUAL");
            SampleResult.setResponseData("Finalizado com sucesso! VIRTUAL" ,"UTF-8");

        } catch (Exception e) {
            log.info("EXCEPTION");
            log.info(erroMsg);
            SampleResult.setResponseMessage(erroMsg);
            SampleResult.setSuccessful(false);
            SampleResult.setResponseData(erroMsg ,"UTF-8");
            driver.quit();

        } catch (ConnectException ce) {
            log.info("CONNECT EXCEPTION");
        } finally {

            log.info("FINALLY VIRTUAL !");
            driver.quit();
        }
    }

    void preencherElement(By element, String dado){
        driver.findElement(element).click();
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(dado);
        wait.until
    }*/

}


