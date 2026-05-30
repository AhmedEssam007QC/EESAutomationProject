package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationFromNoughBar extends BasePage {

    private final By aboutTheSyndigateHeaderLocator = By.xpath("//*[@role=\"navigation\"]//*[contains(text(),\"عن النقابة \")]");
    private final By aboutTheSyndigateLink = By.id("Header_Li_2_Item_Loop_1_1");
    private final By currentPresident = By.id("Header_Li_2_Item_Loop_1_2");
    private final By previouspresident = By.id("Header_Li_2_Item_Loop_1_3");
    private final By syndicateCouncil = By.id("Header_Li_2_Item_Loop_1_4");
    private final By tripLocator = By.id("Header_Li_3_Item_Loop_2_1");
    private final By serviceLocator = By.id("Header_Li_3_Item_Loop_2_2");
    private final By engineeringDivision= By.id("Header_A_3_Item_Loop_2_3");
    private final By newsAndEvents =By.id("Header_A_3_Item_Loop_2_4");
    private final By contactUS = By.id("Header_A_3_Item_Loop_2_5");
    private final By login=By.id("HeaderAuthActions_A_1");



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
        waitForText("نقيب المهندسين");
    }
    public void previousPresidentmenu()
    {
        click(aboutTheSyndigateHeaderLocator);
        click(previouspresident);
        waitForText("المهندس");
    }

    public void chooseSyndicateCouncilFromMenu()
    {
        click(aboutTheSyndigateHeaderLocator);
        click(syndicateCouncil);
        waitForText("مجلس النقابة");
    }
    public void clickOnTrip()
    {
        click(tripLocator);
        waitForUrlContains("trips");
    }
    public void  clickOnService()
    {
        click(serviceLocator);
        waitForUrlContains("services");
    }
    public void clickOnEngineeringDivision()
    {
        click(engineeringDivision);
        waitForUrlContains("EngineeringDivisions");
    }
    public void clickOnNewsAndEvents()
    {
        click(newsAndEvents);
        waitForUrlContains("news");
    }

    public void clickOnContactUS()
    {
        click(contactUS);
        waitForUrlToBe("http://dev.ees.cloud4rain.com:6329/home/contact");
    }
    public void clickOnLogin()
    {
        click(login);
    }



}
