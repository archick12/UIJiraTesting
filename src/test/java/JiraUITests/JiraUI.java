package JiraUITests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.NewIssuePage;
import pages.LoginPage;

public class JiraUI {
    String issueKey = "";


    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        driver.manage().window().maximize();

        login();
    }

    @Test
    public void createIssue() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        newIssuePage.getIssueKey();
        newIssuePage.deleteIssue();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO assert
    }

    @Test
    public void updateIssue() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        newIssuePage.getIssueKey();
        newIssuePage.deleteIssue();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO assert
    }

    @AfterTest
    public void tearDown() {
        driver.close(); // TODO investigate why browser is not closed
        driver.quit();
    }

    private void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }

}


