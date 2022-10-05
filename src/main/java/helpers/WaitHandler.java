package helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.TestBase.getDriver;

public class WaitHandler {
    public static void waitForAlertToBePresent()
    {
        WebDriverWait wait = new WebDriverWait(TestBase.getDriver(),Duration.ofSeconds(5));
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForElementToBeClickable(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(TestBase.getDriver(),Duration.ofSeconds(5));
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(TestBase.getDriver(),Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
