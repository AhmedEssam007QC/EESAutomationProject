package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class contactUS extends BasePage{
    private final By fullName=By.id("ContactInquiryFormSection_Input_1");
    private final By email=By.id("ContactInquiryFormSection_Input_2");
    private final By typeOfInquiry=By.id("ContactInquiryFormSection_Input_3");
    private final By message=By.id("ContactInquiryFormSection_Textarea_1");
    private final By sendButton=By.id("ContactInquiryFormSection_Button_1");
    private final By okButton=By.xpath("//*[@class=\"swal2-confirm swal2-styled\"]");

    public contactUS(WebDriver driver) {
        super(driver);
    }
    public void info(String name, String personalEmail,String type,String infoMessage)
    {
        sendKeys(fullName,name);
        sendKeys(email,personalEmail);
        sendKeys(typeOfInquiry,type);
        sendKeys(message,infoMessage);
        click(sendButton);
        waitForText("تم إرسال استفسارك بنجاح.");
    }
    public void confirmSucessMessage()
    {

        click(okButton);
    }
}
