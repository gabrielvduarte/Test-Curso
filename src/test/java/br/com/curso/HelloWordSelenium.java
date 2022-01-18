package br.com.curso;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWordSelenium {

    @Test
    public void hello(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://prova.stefanini-jgr.com.br/teste/qa/");
        browser.quit();
    }

}
