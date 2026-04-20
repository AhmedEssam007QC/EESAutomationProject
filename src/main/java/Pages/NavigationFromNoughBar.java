package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationFromNoughBar extends BasePage {

    private final By aboutTheSyndigateHeaderLocator = By.xpath("//*[@role=\"navigation\"]//*[contains(text(),\"عن النقابة \")]");
    private final By aboutTheSyndigateLink = By.id("Header_Li_2_Item_Loop_1_1");
    private final By currentPresident = By.id("Header_Li_2_Item_Loop_1_2");
    private final By previouspresident = By.id("Header_Li_2_Item_Loop_1_3");
    private final By syndicateCouncil = By.id("Header_Li_2_Item_Loop_1_4");
    private final By tripLocator = By.id("Header_A_3_Item_Loop_2_1");
    private final By serviceLocator = By.id("Header_Li_3_Item_Loop_2_2");
    private final By engineeringDivision= By.id("Header_A_3_Item_Loop_2_3");
    private final By newsAndEvents =By.id("Header_A_3_Item_Loop_2_4");
    private final By contactUS = By.id("Header_A_3_Item_Loop_2_5");



    public NavigationFromNoughBar(WebDriver driver) {
        super(driver);
    }

    public void clickOnAboutTheSyndigateHeader() {
        click(aboutTheSyndigateHeaderLocator);
        click(aboutTheSyndigateLink);

    }
    public void currentPresidentmenu()
    {
        click(aboutTheSyndigateHeaderLocator);
        click(currentPresident);
    }
    public void previousPresidentmenu()
    {
        click(aboutTheSyndigateHeaderLocator);
        click(previouspresident);
    }

    public void chooseSyndicateCouncilFromMenu()
    {
        click(aboutTheSyndigateHeaderLocator);
        click(syndicateCouncil);
    }
    public void clickOnTrip()
    {
        click(tripLocator);
    }
    public void  clickOnService()
    {
        click(serviceLocator);
    }
    public void clickOnEngineeringDivision()
    {
        click(engineeringDivision);
    }
    public void clickOnNewsAndEvents()
    {
        click(newsAndEvents);
    }

    public void clickOnContactUS()
    {
        click(contactUS);
    }


}
