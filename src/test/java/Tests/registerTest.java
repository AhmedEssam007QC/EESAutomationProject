package Tests;

import Pages.Register;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class registerTest extends BaseTest {

    Register register;
    Faker faker = new Faker();
    @Test
    public void registerAsnotMember()
    {
        register = new Register(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/register");
        register.registerAsNotAmember("Ahmed Essam","01025741036","ahmed2@cloud.com","مصر","Ahmed.essam@007","Ahmed.essam@007","29508181401095", ""+faker.regexify("[A-Z][0-9]{8}"));

    }
    @Test
    public void loginAsAmember()
    {
        register = new Register(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/register");
        register.registerAsMember("مصر" ,"100","Ahmed.essam@001",""+faker.regexify("[A-Z][0-9]{8}"),"29607463984066");
    }


}
