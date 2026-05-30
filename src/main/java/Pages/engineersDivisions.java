package Pages;

import Browsers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class engineersDivisions extends BasePage{
    private final By SearchDivision= By.id("EngineeringDivisionList_Input_1");
    private final By selectDivisionName=By.id("NewsCard_Div_8");
    public engineersDivisions(WebDriver driver) {
        super(driver);
    }
    public void searchForDivision(String searchText){
        driver.findElement(SearchDivision).sendKeys(searchText, Keys.ENTER);
    }
    public void selectDivision()
    {
        click(selectDivisionName);
    }
}
