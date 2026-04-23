package Tests;

import Pages.AboutTheSyndicate;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutTheSyndicateTest extends BaseTest {
    AboutTheSyndicate about;
    @Test(priority = 1)
    public void AboutTheSyndicate()
    {
        about  = new AboutTheSyndicate(driver);
        about.clickOnAboutTheSyndigateHeader();
        about.clickOnSeeMoreAbout();
        Assert.assertTrue(driver.getPageSource().contains("نبذة عن النقابة"));
      //  about.clickonDownloadButtonFileAbout();
    }
    @Test (priority = 2)
    public void visionOfTheSyndicate()
    {
        about  = new AboutTheSyndicate(driver);
        about.clickOnAboutTheSyndigateHeader();
        about.clickonSeeMoreVision();
        Assert.assertTrue(driver.getPageSource().contains("تسعي نقابه"));
    }
    @Test(priority = 3)
    public void goalsOfSyndicate()
    {
        about  = new AboutTheSyndicate(driver);
        about.clickOnAboutTheSyndigateHeader();
        about.clickonSeeMoreGoals();
        Assert.assertTrue(driver.getPageSource().contains("تهدف نقابه"));
    }
    @Test (priority = 4)
    public void formationOfSyndicate()
    {
        about  = new AboutTheSyndicate(driver);
        about.clickOnAboutTheSyndigateHeader();
        about.clickonSeeMoreForming();
        Assert.assertTrue(driver.getPageSource().contains("ترجع جذور"));

    }
    @Test(priority = 5)
    public void responsibilitiesOfSyndicate()
    {
        about  = new AboutTheSyndicate(driver);
        about.clickOnAboutTheSyndigateHeader();
        about.clickonSeeMoreResponsibilities();
        Assert.assertTrue(driver.getPageSource().contains("تتولي نقابه"));
    }

}
