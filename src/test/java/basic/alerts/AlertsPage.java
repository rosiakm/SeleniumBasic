package basic.alerts;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static base.TestBase.getDriver;
import static helpers.WaitHandler.waitForAlertToBePresent;
import static org.assertj.core.api.Assertions.assertThat;

public class AlertsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(AlertsPage.class);

    @FindBy(css = "#simple-alert")
    private WebElement simpleAlertButton;
    @FindBy(css = "#simple-alert-label")
    private WebElement simpleAlertLabel;
    @FindBy(css = "#prompt-alert")
    private WebElement promptAlertButton;
    @FindBy(css = "#prompt-label")
    private WebElement promptAlertLabel;
    @FindBy(css = "#confirm-alert")
    private WebElement confirmAlertButton;
    @FindBy(css = "#confirm-label")
    private WebElement confirmAlertLabel;
    @FindBy(css = "#delayed-alert")
    private WebElement delayedAlertButton;
    @FindBy(css = "#delayed-alert-label")
    private WebElement delayedAlertLabel;

    public AlertsPage() {
        super();
        log.info("Elements on the website are initialized");
    }

    public void clickAndAcceptSimpleAlert() {
        simpleAlertButton.click();
        log.info("Button has been found");
        getDriver().switchTo().alert().accept();
        log.info("Switched to alert");

        assertThat(simpleAlertLabel.getText()).isEqualTo("OK button pressed");
    }

    public void clickFillAndAcceptPromptAlert() {
        String name = "Lord Vader";
        promptAlertButton.click();
        log.info("Button has been clicked");
        getDriver().switchTo().alert().sendKeys(name);
        getDriver().switchTo().alert().accept();
        assertThat(promptAlertLabel.getText()).isEqualTo("Hello " + name + "! How are you today?");
    }

    public void clickAndAcceptConfirmAlert(){
        confirmAlertButton.click();
        log.info("Button has been clicked");
        getDriver().switchTo().alert().accept();
        assertThat(confirmAlertLabel.getText()).isEqualTo("You pressed OK!");
    }

    public void clickAndAcceptDelayedAlert(){
        delayedAlertButton.click();
        log.info("Button has been clicked");
        waitForAlertToBePresent();
        getDriver().switchTo().alert().accept();
        assertThat(delayedAlertLabel.getText()).isEqualTo("OK button pressed");
    }
}
