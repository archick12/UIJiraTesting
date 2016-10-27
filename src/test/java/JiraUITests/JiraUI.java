package JiraUITests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class JiraUI {
    String created_issue="";


    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
    }
    @AfterTest
    public  void tearDown()
    {
        driver.close();
    }
    @Test
    public void jiraLogin() throws InterruptedException {




        driver.manage().window().maximize();
        driver.findElement(By.id("login-form-username")).sendKeys("katherinebilous");
        driver.findElement(By.id("login-form-password")).sendKeys("Polis484)");
        driver.findElement(By.id("login-form-submit")).click();

            sleep(3000);




    }
    @Test(dependsOnMethods = {"jiraLogin"})
    public void createIssue() throws InterruptedException {

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"create_link\"]")).click();
        driver.findElement(By.xpath("//*[@id='issuetype-field']")).clear();
        driver.findElement(By.xpath("//*[@id='issuetype-field']")).sendKeys("Bug");

            sleep(1000);

        driver.findElement(By.xpath("//*[@id='summary']")).clear();
        sleep(3000);
        driver.findElement(By.xpath("//*[@id='summary']")).sendKeys(" This summary was created via WebDriver");
        driver.findElement(By.xpath("//*[@id='assignee-field']")).clear();
        sleep(3000);
        driver.findElement(By.xpath("//*[@id='assignee-field']")).sendKeys("katherinebilous", Keys.ENTER);



            sleep(3000);
        created_issue = driver
                .findElement(By.xpath("//*[@id=\"aui-flag-container\"]/div/div/a"))
                .getAttribute("data-issue-key");
        System.out.println(created_issue);


    }
    @Test (dependsOnMethods = {"jiraLogin", "createIssue"})
    public void deleteIssue() throws InterruptedException {
         driver.get("http://soft.it-hillel.com.ua:8080/browse/" +created_issue);
        sleep(5000);

        driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
        sleep(5000);

        driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
        sleep(5000);
        driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();
        sleep(3000);
    }


}
