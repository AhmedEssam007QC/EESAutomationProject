package Tests;

import Browsers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import utils.jsonReader;

public class BaseTest {
   protected WebDriver driver;
   jsonReader loginData;
  //  @BeforeClass
   // @Parameters({"browser"})
  //  public void setDriver(@Optional ("chrome")String browserName){
//        switch (browserName.toLowerCase()){
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//            case "safari":
//                driver = new SafariDriver();
//            default:
//                throw new IllegalArgumentException("Unsupported browser: " + browserName);
//        }
//        driver.manage().window().maximize();
   //  driver=  WebDriverFactory.initDriver("chrome");

    //}
    @BeforeClass
    public void setup()
    {
        loginData=new jsonReader("loginData.json");
        driver=WebDriverFactory.initDriver("edge");
        driver.get("http://dev.ees.cloud4rain.com:6329/home");
    }
    @AfterClass
    public void  teardown()
    {
        driver.quit();
    }


}
