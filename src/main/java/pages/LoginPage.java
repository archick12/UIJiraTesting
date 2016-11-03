package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter user name")
    public void enterUsername() {driver.findElement(By.id("login-form-username")).sendKeys("katherinebilous");}

    @Step("Enter user password")
    public void enterPassword() {
        driver.findElement(By.id("login-form-password")).sendKeys("Polis484)");
    }

    @Step("Click login")
    public void clickLogin() {
        driver.findElement(By.id("login-form-submit")).click();
    }

}
