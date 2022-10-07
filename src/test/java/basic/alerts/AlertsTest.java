package basic.alerts;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.WaitHandler.waitForAlertToBePresent;
import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(AlertsTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/alerts.php";
    AlertsPage alertsPage = new AlertsPage(getDriver());

    @Test
    @Tag("Alert")
    public void simpleAlertPositiveTest() {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        alertsPage.clickOnSimpleAlertButton();
        alertsPage.switchAndAcceptSimpleAlert(getDriver());
        assertThat(alertsPage.getSimpleAlertText()).isEqualTo("OK button pressed");
    }

    @Test
    @Tag("Alert")
    public void promptAlertPositiveTest() {
        String name = "Lord Vader";
        getDriver().get(websiteAddress);
        log.info("My website address is " + websiteAddress);
        alertsPage.clickOnPromptAlertButton();
        alertsPage.switchAndSendKeysToPromptAlert(getDriver(), name);
        alertsPage.switchToAndAcceptPromptAlert(getDriver());
        assertThat(alertsPage.getPromptAlertLabel()).isEqualTo("Hello " + name + "! How are you today?");
    }

    @Test
    @Tag("Alert")
    public void confirmAlertPositiveTest() {
        getDriver().get(websiteAddress);
        log.info("My website address is " + websiteAddress);
        alertsPage.clickOnConfirmAlertButton();
        alertsPage.switchToAndAcceptConfirmAlert(getDriver());
        assertThat(alertsPage.getConfirmAlertLabel()).isEqualTo("You pressed OK!");
    }

    @Test
    @Tag("Alert")
    public void delayedAlertPositiveTest() {
        getDriver().get(websiteAddress);
        log.info("My website address is " + websiteAddress);
        alertsPage.clickOnDelayedAlertButton();
        waitForAlertToBePresent(getDriver());
        alertsPage.switchToAndAcceptDelayedAlert(getDriver());
        assertThat(alertsPage.getDelayedAlertLabel()).isEqualTo("OK button pressed");
    }
}
