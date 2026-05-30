package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GlobalSearch extends BasePage {

    private final By searchButtonLocator = By.xpath("//*[@role=\"navigation\"]//*[@class=\"search-container flex items-center relative group\"]/button");
    private final By searchInputLocator = By.xpath("//*[@class=\"mb-6\"]//input");
    private final By submitButtonLocator = By.xpath("//*[@class=\"mb-6\"]//button[@type=\"submit\"]");

    public GlobalSearch(WebDriver driver) {
        super(driver);
    }

    public void search(String searchText) {
        click(searchButtonLocator);
        sendKeys(searchInputLocator, searchText);
        click(submitButtonLocator);
    }
}

