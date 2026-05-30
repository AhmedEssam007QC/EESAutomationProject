package Tests;

import Pages.NavigationFromNoughBar;
import Pages.contactUS;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.jsonReader;

public class contactUsTest extends BaseTest{
    jsonReader contact;
    contactUS contactUs;
    NavigationFromNoughBar navigationFromNoughBar;
    @Test
    public void contactUsTest() throws InterruptedException {
        navigationFromNoughBar = new NavigationFromNoughBar(driver);
        contactUs = new contactUS(driver);
        contact= new jsonReader("contactUS");
        navigationFromNoughBar.clickOnContactUS();
        contactUs.info(contact.getData("fullName"),contact.getData("email"),contact.getData("type"),contact.getData("message"));

        Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText(),"تم إرسال استفسارك بنجاح.");
        contactUs.confirmSucessMessage();
    }
}
