package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class login extends BasePage{
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.xpath("//*[@type=\"submit\"]");
    private final By profileLocator=By.xpath("//*[@class=\"user-dropdown-button flex items-center space-x-1 sm:space-x-2 space-x-reverse hover:text-green-600 transition-colors cursor-pointer focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-opacity-50 rounded-md p-2\"]");
    private final By logOutButton=By.xpath("//*[contains(text(),'تسجيل الخروج')] ");
    private final By confirmLogin=By.xpath(" //*[contains(text(),\"موافق\")]");
    private final By confirmLogout=By.xpath("//*[contains(text(),'نعم، تسجيل الخروج')]");
    private final By confirmLogout2=By.xpath(" //*[contains(text(),\"موافق\")]");
    public login(WebDriver driver) {
        super(driver);
    }
//    public void loginByUserName(String username, String password) {
//        if (username!="Ahmed Essam"&&password!="Ahmed.essam@008") {
//            click(By.xpath("//*[@routerlink=\"/auth/register\"]"));
//
//        }
//         else {
//
//            sendKeys(usernameLocator, username);
//            sendKeys(passwordLocator, password);
//            click(loginButtonLocator);
//        }
//    }
    public void loginByID(String ID,String password) {
        sendKeys(usernameLocator, ID);
        sendKeys(passwordLocator, password);

        click(loginButtonLocator);
        click(confirmLogin);
    }
    public void loginByEmail(String email,String password) {
        sendKeys(usernameLocator, email);
        sendKeys(passwordLocator, password);
        click(loginButtonLocator);
        click(confirmLogin);
    }
    public void forgetPassword(String username,String password)
    {
        sendKeys(usernameLocator,username);
        sendKeys(passwordLocator,password);
        if (!Objects.equals(password, "Ahmed.essam@008")) {
            click(By.xpath("//*[@routerlink=\"/auth/forgot-password\"]"));
        }
        else
        {
            click(loginButtonLocator);
        }
    }
    public void logOut()
    {
        //click(profileLocator);
        click(logOutButton);
        click(confirmLogout);
        click(confirmLogout2);
    }
}
