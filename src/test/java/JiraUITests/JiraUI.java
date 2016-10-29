package JiraUITests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateIssue;
import pages.LoginPage;

public class JiraUI {
    String issueKey ="";


    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver= new FirefoxDriver();
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        driver.manage().window().maximize();

        login();
    }

    @Test
    public void createIssue()  {
        CreateIssue createIssue = new CreateIssue(driver);
        createIssue.createBug();
        createIssue.createSummary();
        createIssue.createAssignee();
        createIssue.getIssueKey();
        createIssue.deleteIssue();

    }

    @AfterTest
    public  void tearDown()
    {
        driver.quit();
    }

    private void login(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }

}


