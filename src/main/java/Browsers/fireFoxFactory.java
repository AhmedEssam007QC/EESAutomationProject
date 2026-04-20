package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class fireFoxFactory extends AbstractDrivers{
    public FirefoxOptions options()
    {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--allow -origin=*");
        options.setAcceptInsecureCerts(true);
        return options;
    }
    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver(options());
    }
}
