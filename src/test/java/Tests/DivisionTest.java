package Tests;

import Pages.NavigationFromNoughBar;
import Pages.engineersDivisions;
import net.minidev.json.writer.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.jsonReader;

public class DivisionTest extends BaseTest{
    NavigationFromNoughBar navigationFromNoughBar;
    jsonReader divisions;
    @Test

    public void divisionTest() throws InterruptedException {
        divisions= new jsonReader("divisions");
         navigationFromNoughBar = new NavigationFromNoughBar(driver);
        navigationFromNoughBar.clickOnEngineeringDivision();
        engineersDivisions engineersDivisions = new engineersDivisions(driver);
        engineersDivisions.searchForDivision(divisions.getData("divisionName"));

        engineersDivisions.selectDivision();

        Assert.assertTrue(driver.getPageSource().contains("شعبه الهندسه الكهربائيه"));


    }
}
