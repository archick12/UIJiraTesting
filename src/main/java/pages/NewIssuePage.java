package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NewIssuePage {
    String issueKey = "";
    private WebDriver driver;


    public NewIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public void createBug() {
        WebElement createButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='create_link']")));
        createButton.click();

        WebElement summary = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='summary']")));

        summary.clear();
        summary.sendKeys("Bug");
    }

    public void createSummary() {
        WebElement summary = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='summary']")));
        summary.clear();
        summary.sendKeys(" This summary was created via WebDriver");
    }

    public void createAssignee() {
        WebElement assignee = driver.findElement(By.xpath("//*[@id='assignee-field']"));
        assignee.clear();
        assignee.sendKeys("katherinebilous", Keys.ENTER);

    }

    public void getIssueKey() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        issueKey = driver
                .findElement(By.xpath("//*[@id='aui-flag-container']/div/div/a"))
                .getAttribute("data-issue-key");
        System.out.println(issueKey);
    }

    public void deleteIssue() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();


    }

}
