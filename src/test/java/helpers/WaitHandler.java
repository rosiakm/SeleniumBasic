package helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.TestBase.getDriver;

public class WaitHandler {
    public static void waitForAlertToBePresent()
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
