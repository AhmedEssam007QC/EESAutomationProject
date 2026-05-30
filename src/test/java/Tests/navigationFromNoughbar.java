package Tests;

import Pages.NavigationFromNoughBar;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class navigationFromNoughbar extends BaseTest {
    NavigationFromNoughBar aboutTheSyndigate;

    @Test()
    @Description("Verify that the user can click on About The Syndicate header from navigation bar")
    @Severity(SeverityLevel.NORMAL)

    public void clickOnAboutTheSyndicate() {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);
       aboutTheSyndigate.clickOnAboutTheSyndigateHeader();
       Assert.assertTrue(driver.getPageSource().contains("عن النقابة"));
    }

    @Test(priority = 1)
    @Description("Verify that the user can choose the current president tab from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void chooseCurrentPresidentTab() throws InterruptedException {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);
        aboutTheSyndigate.currentPresidentmenu();
       // Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("نقيب المهندسين"));
      //  Thread.sleep(1000);
    }

    @Test (priority = 2)
    @Description("Verify that the user can choose the previous president tab from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void choosePreviousPresidentTab() {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);
        aboutTheSyndigate.previousPresidentmenu();
        Assert.assertTrue(driver.getPageSource().contains("المهندس"));
    }

    @Test  (priority = 3)
    @Description("Verify that the user can choose the syndicate council tab from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void chooseSyndicateCouncilTab() {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);
        aboutTheSyndigate.chooseSyndicateCouncilFromMenu();
        Assert.assertTrue(driver.getPageSource().contains("مجلس النقابة"));
    }

    @Test (priority = 4)
    @Description("Verify that the user can click on trips from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void clickOnTrips() throws InterruptedException {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);
        aboutTheSyndigate.clickOnTrip();
     //   Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://dev.ees.cloud4rain.com:6329/home/trips");
       // Thread.sleep(1000);
    }

    @Test (priority = 5)
    @Description("Verify that the user can click on services from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void clickOnServices() throws InterruptedException {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);
        aboutTheSyndigate.clickOnService();
       // Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://dev.ees.cloud4rain.com:6329/home/services");
      //  Thread.sleep(1000);
    }

    @Test (priority = 6)
    @Description("Verify that the user can click on news and events from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void clickOnNewsAndEvents() throws InterruptedException {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);

        aboutTheSyndigate.clickOnNewsAndEvents();
      //  Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://dev.ees.cloud4rain.com:6329/home/news");
      // Thread.sleep(1000);
    }

    @Test (priority = 7)
    @Description("Verify that the user can click on contact us from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void clickOnContactUS() {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);
        aboutTheSyndigate.clickOnContactUS();
        Assert.assertTrue(driver.getPageSource().contains("تواصل معنا"));
    }

    @Test (priority = 8)
    @Description("Verify that the user can click on engineering division from navigation bar")
    @Severity(SeverityLevel.NORMAL)
    public void clickOnEngineeringDivision() throws InterruptedException {
        aboutTheSyndigate = new NavigationFromNoughBar(driver);

        aboutTheSyndigate.clickOnEngineeringDivision();
      //  Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://dev.ees.cloud4rain.com:6329/home/EngineeringDivisions");
      //  Thread.sleep(1000);
    }



}

