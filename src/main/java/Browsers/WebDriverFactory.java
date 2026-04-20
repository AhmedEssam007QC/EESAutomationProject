package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();

public static WebDriver getDriver(String browser)
{
    Browser browser1 = Browser.valueOf(browser.toLowerCase());
    AbstractDrivers factory= browser1.getfactory();
    return factory.getDriver();
}
public static WebDriver initDriver(String browser)
{
    WebDriver driver = ThreadGuard.protect(getDriver(browser));
    driverThread.set(driver);
    return driver;
}
}

