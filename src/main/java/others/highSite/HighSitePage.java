package others.highSite;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

import static helpers.TakeScreenshot.takeScreenshot;
import static helpers.WaitHandler.waitForElementToBeVisible;

public class HighSitePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(HighSitePage.class);

    @FindBy(css = "p[class='lead high-site-paragraph show-button']")
    private WebElement submitButtonParagraph;
    @FindBy(css = "#scroll-button")
    private WebElement submitButton;

    public HighSitePage(WebDriver driver) {
        super(driver);
    }

    public void scrollToSpecificElement(WebDriver driver) {
        Actions action = new Actions(driver);
        action.scrollToElement(submitButtonParagraph).perform();
        log.info("Scroll to element");
    }

    public void scrollBySpecificAmount(WebDriver driver, int x, int y) {
        Actions action = new Actions(driver);
        action.scrollByAmount(x, y).perform();
        log.info("Scroll 200 pixels below to make the element visible in html structure");
        waitForElementToBeVisible(driver, submitButton);
    }

    public void takeScreenshotOfElement(WebDriver driver) throws IOException {
        takeScreenshot(driver, "src/main/resources/screenshot" + new Date().getTime() + ".png");
    }
}
