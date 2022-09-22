package basic.windowsTabs;

import base.TestBase;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class windowsTabsTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(windowsTabsTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/windows-tabs.php";

    @Test
    @Tag("Basic")
    @Order(1)
    public void switchToNewBrowserWindowTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new windowsTabsPage().switchToNewBrowserWindow();
    }
    @Test
    @Tag("Basic")
    @Order(2)
    public void switchToNewMessageWindowTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new windowsTabsPage().switchToNewMessageWindow();
    }
    @Test
    @Tag("Basic")
    @Order(3)
    public void switchToNewTabTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new windowsTabsPage().switchToNewTab();
    }
}
