package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static base.TestBase.getDriver;

public class TakeScreenshot {
    public static void takeScreenshot(WebDriver driver, String path) throws IOException {
        TakesScreenshot scrShot = (TakesScreenshot) getDriver();
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(path);
        FileUtils.copyFile(srcFile,destFile);
    }
}
