package JiraUITests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LogoutPage;
import pages.NewIssuePage;
import pages.LoginPage;
import pages.UpdateIssuePage;

public class JiraUI {
    String issueKey = "";


    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();


    }

    @Test
    public void createIssue() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        newIssuePage.getIssueKey();
        newIssuePage.deleteIssue();


    }


    @Test
    public void updateIssueAddComment() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateIssuePage.addComment();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateIssuePage.deleteIssue();


        // TODO assert
    }

    @Test
    public void updateIssueUpdateReporter() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateIssuePage.updateReporter();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateIssuePage.deleteIssue();


        // TODO assert
    }

    @Test
    public void updatePriority() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateIssuePage.updatePriority();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateIssuePage.deleteIssue();


        // TODO assert
    }

    @Test
    public void updateIssueTitle() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateIssuePage.updateIssueTitle();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateIssuePage.deleteIssue();


        // TODO assert
    }


    @AfterTest
    public void tearDown() {


        driver.close(); // TODO investigate why browser is not closed
        driver.quit();

    }


    @Test
    public void Logout() {
        LogoutPage logout = new LogoutPage(driver);
        logout.Logout();

    }

}


