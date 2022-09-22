package basic.windowsTabs;

import base.BasePage;
import base.TestBase;
import basic.tables.TablePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static base.TestBase.getDriver;

public class windowsTabsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(windowsTabsPage.class);
    String parentWindow = getDriver().getWindowHandle();

    @FindBy(css = "#newBrowserWindow")
    private WebElement newBrowserWindowButton;
    @FindBy(css = "#newMessageWindow")
    private WebElement newMessageWindowButton;
    @FindBy(css = "#newBrowserTab")
    private WebElement newBrowserTabButton;
    @FindBy(css = "body")
    private WebElement messageWindowBody;

    public windowsTabsPage(){
        super();
    }

    public void switchToNewBrowserWindow(){
        log.info("My parent window is: " + parentWindow);
        newBrowserWindowButton.click();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!windowHandle.equals(parentWindow)){
                getDriver().switchTo().window(windowHandle);
                log.info("My new window is: " + windowHandle);
            }
        }
        new TablePage().selectSpecificData();
        log.info("Exercise 4 completed");
        getDriver().close();
        log.info("New browser window closed");
        getDriver().switchTo().window(parentWindow);
        log.info("Switched to parent window" + parentWindow);
    }

    public void switchToNewMessageWindow(){
        log.info("My parent window is: " + parentWindow);
        newMessageWindowButton.click();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!windowHandle.equals(parentWindow)){
                getDriver().switchTo().window(windowHandle);
                log.info("My new window is: " + windowHandle);
            }
        }
        System.out.println(messageWindowBody.getText());
        getDriver().close();
        log.info("New message window closed");
        getDriver().switchTo().window(parentWindow);
        log.info("Switched to parent window" + parentWindow);
    }

    public void switchToNewTab(){
        log.info("My parent tab is: " + parentWindow);
        newBrowserTabButton.click();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!windowHandle.equals(parentWindow)){
                getDriver().switchTo().window(windowHandle);
                log.info("My new tab is: " + windowHandle);
            }
        }
        new TablePage().selectSpecificData();
        log.info("Exercise 4 completed");
        getDriver().close();
        log.info("New tab closed");
        getDriver().switchTo().window(parentWindow);
        log.info("Switched to parent tab" + parentWindow);
    }
}
