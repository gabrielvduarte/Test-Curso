import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageObject {

    public WebDriver browser;

    public PageObject(WebDriver Browser) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        if (browser == null){
            this.browser = new ChromeDriver();
            this.browser.navigate().to("http://prova.stefanini-jgr.com.br/teste/qa/");
        }else{
            this.browser = Browser;
        }
    }


    public void fechar(){
        browser.quit();
    }
}