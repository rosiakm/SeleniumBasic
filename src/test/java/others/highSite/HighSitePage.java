package others.highSite;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

import static base.TestBase.getDriver;
import static helpers.TakeScreenshot.takeScreenshot;
import static helpers.WaitHandler.waitForElementToBeVisible;

public class HighSitePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(HighSitePage.class);

    @FindBy(css = "p[class='lead high-site-paragraph show-button']")
    private WebElement submitButtonParagraph;
    @FindBy(css = "#scroll-button")
    private WebElement submitButton;

    public HighSitePage(){
        super();
    }
    public void scrollDownUntilSubmitButtonDisplays() throws IOException {
        Actions action = new Actions(getDriver());
        action.scrollToElement(submitButtonParagraph).perform();
        log.info("Scroll to element");
        action.scrollByAmount(0,200).perform();
        log.info("Scroll 200 pixels below to make the element visible in html structure");
        waitForElementToBeVisible(submitButton);
        takeScreenshot(getDriver(),"src/main/resources/screenshot" + new Date().getTime() +".png");
    }
}
