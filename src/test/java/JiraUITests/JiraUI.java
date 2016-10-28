package JiraUITests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateIssue;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class JiraUI {
    String issueKey ="";


    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");

        //Explicit Waits
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("header")));

        LoginPage loginPage= new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();



    }
    @AfterTest
    public  void tearDown()
    {
        driver.close();
    }
    @Test
    public void jiraLogin() throws InterruptedException {
        driver.manage().window().maximize();


        LoginPage loginPage= new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();









      //  driver.findElement(By.id("login-form-username")).sendKeys("katherinebilous");
      //  driver.findElement(By.id("login-form-password")).sendKeys("Polis484)");
      //  driver.findElement(By.id("login-form-submit")).click();





    }
    @Test
    public void createIssue()  {

        driver.manage().window().maximize();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();


        CreateIssue createIssue = new CreateIssue(driver);
        createIssue.createBug();
        createIssue.createSummary();
        createIssue.createAssignee();
        createIssue.getIssueKey();

        createIssue.deleteIssue();





       /*
        issueKey = driver
                .findElement(By.xpath("//*[@id=\"aui-flag-container\"]/div/div/a"))
                .getAttribute("data-issue-key");
        System.out.println(issueKey);*/


    }
    @Test (dependsOnMethods = {"jiraLogin", "createIssue"})
    public void deleteIssue() throws InterruptedException {
        CreateIssue createIssue =new CreateIssue(driver);
        createIssue.deleteIssue();
         /*driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        sleep(5000);

        driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
        sleep(5000);

        driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
        sleep(5000);
        driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();
        sleep(3000);*/
    }
    @Test
    public void updateReporter(){

    }


}


