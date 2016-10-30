package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UpdateIssuePage {

    String issueKey = "";
    private WebDriver driver;


    public UpdateIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void updateReporter(){
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement reporter = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='reporter-val']")));

        reporter.click();
        reporter.sendKeys(Keys.DELETE);

        //reporter.clear();
        reporter.sendKeys("Arthur Piluck 2", Keys.ENTER);

    }

    public void updatePriority(){
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        WebElement priority = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='priority-field']")));
        priority.clear();
        priority.sendKeys("Low", Keys.ENTER);
        // TODO assert priority low

    }
    public void getIssueKey() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        issueKey = driver
                .findElement(By.xpath("//*[@id='aui-flag-container']/div/div/a"))
                .getAttribute("data-issue-key");
        System.out.println(issueKey);
    }
    public void addComment(){
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        WebElement comment = driver.findElement(By.xpath("//*[@id='comment-issue']/span[1]"));
        comment.click();
        WebElement addComment = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='comment']")));

        addComment.sendKeys("This comment was added via WebDriver", Keys.CONTROL, Keys.ENTER);

        // TODO assert button

    }
    public void updateIssueTitle(){
        WebElement title = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("Just now")));
        WebElement changeIssueTitle = driver.findElement(By.xpath(" //*[@id='summary-val']"));
        changeIssueTitle.click();
        // TODO add assert text bar
        changeIssueTitle.clear();
        changeIssueTitle.sendKeys(" This title was changed via WebDriver", Keys.ENTER);

    }


}
