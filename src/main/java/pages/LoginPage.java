package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.RemoteDriverManager;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = RemoteDriverManager.getDriver();

    }

    public void open() {
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
    }

    @Step("Enter user name")
    public void enterUsername() {
        driver.findElement(By.id("login-form-username")).sendKeys("katherinebilous");
    }

    @Step("Enter user password")
    public void enterPassword() {
        driver.findElement(By.id("login-form-password2")).sendKeys("Polis484)");
    }

    @Step("Click login")
    public void clickLogin() {
        driver.findElement(By.id("login-form-submit")).click();
    }

}
