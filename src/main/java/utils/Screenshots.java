package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshots {
   public static void AddScreenshot(WebDriver driver, String ScreenName)
   {
      try
      {
          File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          File dest = new File("test-output/ScreenShots/"+ScreenName+".png");
          FileUtils.copyFile(src, dest);
          AllureUtils.attachScreenShotToAllure(ScreenName, dest.getAbsolutePath());
      }
      catch (Exception e)
      {
          System.out.println("Error in taking screenshot: " + e.getMessage());
      }
   }
}
