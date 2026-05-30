package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class trips extends BasePage{
    final private By searchTrips= By.id("TripList_Input_1");
    final private By clickOnTrip=By.id("NewsCard_Div_8");

    public trips(WebDriver driver) {
        super(driver);
    }
    public void searchForTrips(String name)
    {
        driver.findElement(searchTrips).sendKeys(name, Keys.ENTER);
    }
    public void clickTrip()
    {
        click(clickOnTrip);
    }
}
