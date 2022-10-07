package basic.windowsTabs;

import base.TestBase;
import basic.tables.TablePage;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WindowsTabsTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(WindowsTabsTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/windows-tabs.php";
    WindowsTabsPage tabsPage = new WindowsTabsPage(getDriver());

    @Test
    @Tag("Basic")
    @Order(1)
    public void switchToNewBrowserWindowTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        log.info("My parent window is: " + tabsPage.getParentWindow(getDriver()));
        tabsPage.clickOnNewBrowserWindowButton();
        tabsPage.switchToNewBrowserWindow(getDriver());
        new TablePage(getDriver()).selectSpecificData();
        log.info("Exercise 4 completed");
        tabsPage.closeTheDriver(getDriver());
        tabsPage.switchToParentWindow(getDriver());
    }
    @Test
    @Tag("Basic")
    @Order(2)
    public void switchToNewMessageWindowTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        log.info("My parent window is: " + tabsPage.getParentWindow(getDriver()));
        tabsPage.clickOnMessageWindowButton();
        tabsPage.switchToNewMessageWindow(getDriver());
        tabsPage.closeTheDriver(getDriver());
        tabsPage.switchToParentWindow(getDriver());
    }
    @Test
    @Tag("Basic")
    @Order(3)
    public void switchToNewTabTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        log.info("My parent window is: " + tabsPage.getParentWindow(getDriver()));
        tabsPage.clickOnNewBrowserTabButton();
        tabsPage.switchToNewTab(getDriver());
        new TablePage(getDriver()).selectSpecificData();
        log.info("Exercise 4 completed");
        tabsPage.closeTheDriver(getDriver());
        tabsPage.switchToParentWindow(getDriver());
    }
}
