package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
       this.driver = driver;
       this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));

    }
    protected void click(By by)
    {

        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    protected void sendKeys(By by, String Text)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(Text);
    }
    protected void getText(By by)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).getText();
    }
    protected void selectFromDropdown(By by, String option)
    {

        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(option);

    }
    protected void waitForText(String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
    }

    protected void waitForUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    protected void waitForUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }
//    protected void scrollAndClick(By by) {
//        //waitForLoaderToDisappear();
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
//
//        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].scrollIntoView({block: 'center'});", element);
//
//        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
//    }
protected void scrollToBottom() {
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
}
    protected void scrollToViewportMiddle() {
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollBy(0, window.innerHeight / 3);"
        );
    }

}
