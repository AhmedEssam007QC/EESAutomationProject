package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Register extends BasePage {
    final private By notACandidate = By.xpath(" //*[@class=\"register-page min-h-screen flex items-center justify-center p-4\"]//button[2]");
    final private By isACandidate=By.xpath("//*[@class=\"register-page min-h-screen flex items-center justify-center p-4\"]//button[1]");
    final private By fullNameLocator = By.xpath("//*[@formcontrolname=\"fullName\"]//input");
    final private By phoneLocator = By.xpath("//*[@formcontrolname=\"phoneNumber\"]//input");
    final private By emailLocator = By.xpath("//*[@formcontrolname=\"email\"]//input");
    final private By nationalityLocator = By.xpath("//*[@formcontrolname=\"nationality\"]//select");
    final private By passWordLocator = By.id("password");
    final private By confirmPasswordLocator = By.id("confirmPassword");
    final private By signUpButtonLocator = By.xpath("//*[@type=\"submit\"]");
    final private By IDLocator = By.xpath("//*[@formcontrolname=\"nationalId\"]//input");
    final private By passPortLocator = By.xpath("//*[@formcontrolname=\"passportNumber\"]//input");
    final private By accept=By.xpath("//*[contains(text(),\"موافق\")]");
    final private By nationalityLocator2=By.xpath("//*[@class=\"searchable-select\"]//select");
    final private By IDLocator2= By.xpath("//*[@formcontrolname=\"nationalId\"]//input");
    final private By memberShipLocator=By.xpath("//*[@formcontrolname=\"engineerMembershipNumber\"]//input");
    final private By passPortLocator2 =By.xpath("//*[@formcontrolname=\"passportNumber\"]//input");
    final private By memberPassword=By.id("memberPassword");






    public Register(WebDriver driver) {
        super(driver);

    }

    public void registerAsNotAmember(String fullName, String phone, String email, String country, String password, String confirmPassword, String ID, String passPort) {
        click(notACandidate);
        sendKeys(fullNameLocator, fullName);
        sendKeys(phoneLocator, phone);
        sendKeys(emailLocator, email);
        click(nationalityLocator);
        By countryOptionLocator = By.xpath("//*[@class=\"searchable-select__list\"]/option[text()=\"" + country + "\"]");
        click(countryOptionLocator);
        if(!country.equals("مصر"))
        {
            sendKeys(passPortLocator, passPort);
        }
        else
        {
            sendKeys(IDLocator, ID);

        }
        click(nationalityLocator);
        sendKeys(passWordLocator, password);
        sendKeys(confirmPasswordLocator, confirmPassword);
        click(signUpButtonLocator);
        click(accept);

    }
    public void registerAsMember(String country,String membership,String password,String passPort,String ID)
    {
       click(isACandidate);
       click(nationalityLocator);
       sendKeys(memberShipLocator,membership);
        By countryOptionLocator = By.xpath("//*[@class=\"searchable-select__list\"]/option[text()=\"" + country + "\"]");
        click(countryOptionLocator);
        if(!country.equals("مصر"))
        {
             sendKeys(passPortLocator2, passPort);
        }
        else
        {
             sendKeys(IDLocator2, ID);

        }
         sendKeys(memberPassword, password);
        click(signUpButtonLocator);
        click(accept);

    }
}
