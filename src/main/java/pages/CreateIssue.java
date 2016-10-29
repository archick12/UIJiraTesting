package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CreateIssue {
    String issueKey ="";
    private WebDriver driver;


    public CreateIssue(WebDriver driver) {this.driver = driver;}

    public void createBug(){

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement createButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"create_link\"]")));

        driver.findElement(By.xpath("//*[@id=\"create_link\"]")).click();
        WebElement summary = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"summary\"]")));
        driver.findElement(By.xpath("//*[@id='issuetype-field']")).clear();
        driver.findElement(By.xpath("//*[@id='issuetype-field']")).sendKeys("Bug");

    }
     public void createSummary(){
         //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         WebElement reporter = (new WebDriverWait(driver, 10))
                 .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"reporter-field\"]")));
         driver.findElement(By.xpath("//*[@id='summary']")).clear();
         driver.findElement(By.xpath("//*[@id='summary']")).sendKeys(" This summary was created via WebDriver");
         //WebElement assignee = driver.findElement(By.xpath("//*[@id=\"assignee-container\"]/label"));
         WebElement assignee = (new WebDriverWait(driver, 10))
                 .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"assignee-container\"]/label")));



     }
    public void createAssignee(){
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='assignee-field']")).clear();
        driver.findElement(By.xpath("//*[@id='assignee-field']")).sendKeys("katherinebilous", Keys.ENTER);
      //  WebElement createButton = driver.findElement(By.xpath("//*[@id='create_link']"));
        WebElement popup = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"aui-flag-container\"]/div/div")));


    }
    public void  getIssueKey(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        issueKey = driver
                .findElement(By.xpath("//*[@id=\"aui-flag-container\"]/div/div/a"))
                .getAttribute("data-issue-key");
        System.out.println(issueKey);
    }
    public void deleteIssue(){
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();


    }







}
