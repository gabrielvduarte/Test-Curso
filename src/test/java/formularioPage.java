import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class formularioPage extends PageObject{

    protected final String URL_CADASTRO (){
        return "http://prova.stefanini-jgr.com.br/teste/qa/";
    };

    public formularioPage() {
        super(null);
    }

    public void preencheFormulario(String name, String email, String password) {
        browser.findElement(By.id("name")).sendKeys(name);
        browser.findElement(By.id("email")).sendKeys(email);
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.id("register")).click();
    }

    public Boolean verifiqueSeExiste(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public String pegaOtexto(String id){
       return browser.findElement(By.id(id)).getText();
    }

}


