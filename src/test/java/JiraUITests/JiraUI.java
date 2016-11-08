package JiraUITests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.NewIssuePage;
import pages.UpdateIssuePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import utils.TestListener;

@Listeners(TestListener.class)
public class JiraUI {
    String issueKey = "";


    @TestCaseId("TMS-1")
    @Features("Issue")
    @Stories({"CRUDIssue"})
    @Test
    public void createIssue() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

        NewIssuePage newIssuePage = new NewIssuePage();
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        newIssuePage.getIssueKey();
        newIssuePage.deleteIssue();

        LogoutPage logout = new LogoutPage();
        logout.Logout();
    }

    @TestCaseId("TMS-2")
    @Features("Issue")
    @Stories({"CRUDIssue"})
    @Test
    public void updateIssueAddComment() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

        NewIssuePage newIssuePage = new NewIssuePage();
        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
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
        LogoutPage logout = new LogoutPage();
        logout.Logout();
    }

//    @TestCaseId("TMS-2")
//    @Issue("CEV-9933") // Это ссылка на баг
//    @Test
//    public void updateIssueUpdateReporter() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.enterUsername();
//        loginPage.enterPassword();
//        loginPage.clickLogin();
//
//        NewIssuePage newIssuePage = new NewIssuePage();
//        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
//        newIssuePage.createBug();
//        newIssuePage.createSummary();
//        newIssuePage.createAssignee();
//        updateIssuePage.getIssueKey();
//
//
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        updateIssuePage.updateReporter();
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        updateIssuePage.deleteIssue();
//
//
//        // TODO assert
//        LogoutPage logout = new LogoutPage();
//        logout.Logout();
//    }
//
//    @Test
//    public void updatePriority() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.enterUsername();
//        loginPage.enterPassword();
//        loginPage.clickLogin();
//
//        NewIssuePage newIssuePage = new NewIssuePage();
//        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
//        newIssuePage.createBug();
//        newIssuePage.createSummary();
//        newIssuePage.createAssignee();
//        updateIssuePage.getIssueKey();
//
//
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        updateIssuePage.updatePriority();
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        updateIssuePage.deleteIssue();
//
//
//        // TODO assert
//        LogoutPage logout = new LogoutPage();
//        logout.Logout();
//    }
//
//    @Test
//    public void updateIssueTitle() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.enterUsername();
//        loginPage.enterPassword();
//        loginPage.clickLogin();
//
//
//        NewIssuePage newIssuePage = new NewIssuePage();
//        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
//        newIssuePage.createBug();
//        newIssuePage.createSummary();
//        newIssuePage.createAssignee();
//        updateIssuePage.getIssueKey();
//
//
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        updateIssuePage.updateIssueTitle();
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        updateIssuePage.deleteIssue();
//
//        LogoutPage logout = new LogoutPage();
//        logout.Logout();
//        // TODO assert
//    }


}


