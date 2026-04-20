package Tests;

import Browsers.WebDriverFactory;
import Pages.GlobalSearch;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import net.minidev.json.writer.JsonReader;
import org.testng.annotations.Test;
import utils.Screenshots;
import utils.jsonReader;

public class globalSearchTest extends BaseTest {
    GlobalSearch globalSearch;
    @Epic("Search")
    @Story("Global Search")
    @Feature("Global Search")
    @Test
    public void globalSearch() {
        globalSearch = new GlobalSearch(driver);
       jsonReader jsonReader = new jsonReader("searchData");
        driver.get("http://dev.ees.cloud4rain.com:6329/home");
        globalSearch.search(jsonReader.getData("searchTerm"));
        Screenshots.AddScreenshot(driver, "GlobalSearchResults");
    }
}

