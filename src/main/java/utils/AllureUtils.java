package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;

import static java.nio.file.Files.newInputStream;

public class AllureUtils {
    public static void cleanAllureResults()
    {
        FileUtils.deleteQuietly(new File("test-output/allure-results"));
    }
    public static void attachScreenShotToAllure(String screenName,String screenPath) {
      try
      {
          File screenShotFile = new File(screenPath);
          Allure.addAttachment(screenName, newInputStream(Path.of(screenPath)));
      }
      catch (Exception e)
      {
          System.out.println("Error in attaching the screenshot to allure: " + e.getMessage());
      }
    }
}
