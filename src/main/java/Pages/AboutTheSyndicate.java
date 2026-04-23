package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutTheSyndicate extends BasePage{
    private final By aboutTheSyndigateHeaderLocator = By.xpath("//*[@role=\"navigation\"]//*[contains(text(),\"عن النقابة \")]");
    private final By downloadFileButton=By.id("About_A_1");
    private final By seeMoreAbout= By.id("About_Button_1");
    private final By seeMoreVision=By.id("About_Button_2_Item_Loop_1_1");
    private final By seeMoreGoals=By.id("About_Button_2_Item_Loop_1_2");
    private final By seeMoreForming=By.id("About_Button_2_Item_Loop_1_3");
    private final By seeMoreResponsibilities=By.id("About_Button_4");
    private final By aboutTheSyndigateLink = By.id("Header_Li_2_Item_Loop_1_1");
    private final By closePopUPAbout=By.id("About_Button_3");
    private final By closePopupVision=By.id("About_Path_11");
    private final By closePopupGoals=By.id("About_Path_11");
    private final By closePopupForming=By.id("About_Path_11");
    private final By closePopupResponsibility=By.id("About_Path_11");
    public AboutTheSyndicate(WebDriver driver) {
        super(driver);
    }
    public void clickOnAboutTheSyndigateHeader() {
        click(aboutTheSyndigateHeaderLocator);
        click(aboutTheSyndigateLink);
        waitForUrlToBe("http://dev.ees.cloud4rain.com:6329/home/about");


    }
    public void clickOnSeeMoreAbout()
    {
    scrollToViewportMiddle();
     click(seeMoreAbout);
        waitForText("نشات فكره");
        click(closePopUPAbout);
    }
    public void clickonDownloadButtonFileAbout()
    {
        click(downloadFileButton);
    }
    public void clickonSeeMoreVision()
    {
        click(seeMoreVision);
        waitForText("تسعي");
        click(closePopupVision);
    }
    public void clickonSeeMoreGoals()
    {
        click(seeMoreGoals);
        waitForText("تهدف نقابه");
        click(closePopupGoals);
    }
    public void clickonSeeMoreForming()
    {
        click(seeMoreForming);
        waitForText("ترجع جذور");
        click(closePopupForming);
    }
    public void clickonSeeMoreResponsibilities()
    {
        click(seeMoreResponsibilities);
        waitForText("تتولي نقابه");
        click(closePopupResponsibility);
    }
}
