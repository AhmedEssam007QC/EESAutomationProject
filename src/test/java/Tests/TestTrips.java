package Tests;

import Pages.NavigationFromNoughBar;
import Pages.trips;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTrips extends BaseTest{
    @Test
    public void trips()
    {
        NavigationFromNoughBar navigationFromNoughBar = new NavigationFromNoughBar(driver);
        navigationFromNoughBar.clickOnTrip();
        trips tripsPage = new trips(driver);
        tripsPage.searchForTrips("شتاء");
        tripsPage.clickTrip();
        Assert.assertTrue(driver.getPageSource().contains("رحلات شتاء المعموره"), "Page should contain 'رحلات شتاء المعموره'");
    }
}
