package basic.windowsTabs;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsTabsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(WindowsTabsPage.class);

    @FindBy(css = "#newBrowserWindow")
    private WebElement newBrowserWindowButton;
    @FindBy(css = "#newMessageWindow")
    private WebElement newMessageWindowButton;
    @FindBy(css = "#newBrowserTab")
    private WebElement newBrowserTabButton;
    @FindBy(css = "body")
    private WebElement messageWindowBody;

    public WindowsTabsPage(WebDriver driver) {
        super(driver);
    }

    public String getParentWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public void clickOnNewBrowserWindowButton() {
        newBrowserWindowButton.click();
    }

    public void switchToNewBrowserWindow(WebDriver driver) {

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(getParentWindow(driver))) {
                driver.switchTo().window(windowHandle);
                log.info("My new window is: " + windowHandle);
            }
        }
    }

    public void closeTheDriver(WebDriver driver) {
        driver.close();
        log.info("New browser window closed");
    }

    public void switchToParentWindow(WebDriver driver) {
        driver.switchTo().window(getParentWindow(driver));
        log.info("Switched to parent window" + getParentWindow(driver));
    }

    public void clickOnMessageWindowButton() {
        newMessageWindowButton.click();
    }

    public void switchToNewMessageWindow(WebDriver driver) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(getParentWindow(driver))) {
                driver.switchTo().window(windowHandle);
                log.info("My new window is: " + windowHandle);
            }
        }
        System.out.println(messageWindowBody.getText());
    }

    public void clickOnNewBrowserTabButton() {
        newBrowserTabButton.click();
    }

    public void switchToNewTab(WebDriver driver) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(getParentWindow(driver))) {
                driver.switchTo().window(windowHandle);
                log.info("My new tab is: " + windowHandle);
            }
        }
    }
}
