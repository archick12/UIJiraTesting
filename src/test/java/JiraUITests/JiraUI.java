package JiraUITests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.NewIssuePage;
import pages.UpdateIssuePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class JiraUI {
    String issueKey = "";


    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();


    }

    @TestCaseId("TMS-1")
    @Features("Issue")
    @Stories({"CRUDIssue"})
    @Test
    public void createIssue() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        newIssuePage.getIssueKey();
        newIssuePage.deleteIssue();


    }

    @TestCaseId("TMS-2")
    @Features("Issue")
    @Stories({"CRUDIssue"})
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

    @TestCaseId("TMS-2")
    @Issue("CEV-9933") // Это ссылка на баг
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


