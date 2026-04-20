package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeFactory extends AbstractDrivers{
    private ChromeOptions options()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable -infobars");
        options.setAcceptInsecureCerts(true);
        return options;
    }
    @Override
    public WebDriver getDriver() {
        return new ChromeDriver(options());

    }
}
