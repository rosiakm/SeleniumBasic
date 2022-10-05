package basic.alerts;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(AlertsTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/alerts.php";

    @Test
    @Tag("Alert")
    public void simpleAlertPositiveTest() {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new AlertsPage(getDriver()).clickAndAcceptSimpleAlert();
    }

    @Test
    @Tag("Alert")
    public void promptAlertPositiveTest() {
        getDriver().get(websiteAddress);
        log.info("My website address is " + websiteAddress);
        new AlertsPage(getDriver()).clickFillAndAcceptPromptAlert();
    }

    @Test
    @Tag("Alert")
    public void confirmAlertPositiveTest() {
        getDriver().get(websiteAddress);
        log.info("My website address is " + websiteAddress);
        new AlertsPage(getDriver()).clickAndAcceptConfirmAlert();
    }

    @Test
    @Tag("Alert")
    public void delayedAlertPositiveTest() {
        getDriver().get(websiteAddress);
        log.info("My website address is " + websiteAddress);
        new AlertsPage(getDriver()).clickAndAcceptDelayedAlert();
    }
}
