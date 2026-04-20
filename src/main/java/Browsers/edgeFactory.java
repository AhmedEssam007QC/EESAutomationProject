package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class edgeFactory extends AbstractDrivers{
    private EdgeOptions options()
    {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable -infobars");
        options.setAcceptInsecureCerts(true);
        return options;
    }
    @Override
    public WebDriver getDriver() {
        return new EdgeDriver(options());
    }
}
