package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterUsername() {
        driver.findElement(By.id("login-form-username")).sendKeys("katherinebilous");
    }

    public void enterPassword() {
        driver.findElement(By.id("login-form-password")).sendKeys("Polis484)");
    }

    public void clickLogin() {
        driver.findElement(By.id("login-form-submit")).click();
    }

}
