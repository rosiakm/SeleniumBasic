package basic.alerts;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public AlertsPage(WebDriver driver) {
        super(driver);
        log.info("Elements on the website are initialized");
    }

    public void clickOnSimpleAlertButton(){
        simpleAlertButton.click();
        log.info("Button has been found");
    }

    public void switchAndAcceptSimpleAlert(WebDriver driver){
        driver.switchTo().alert().accept();
        log.info("Switched to alert");
    }

    public String getSimpleAlertText(){
        return simpleAlertLabel.getText();
    }
    public void clickOnPromptAlertButton(){
        promptAlertButton.click();
        log.info("Button has been clicked");
    }
    public String switchAndSendKeysToPromptAlert(WebDriver driver, String name){
        driver.switchTo().alert().sendKeys(name);
        return name;
    }
    public void switchToAndAcceptPromptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    public String getPromptAlertLabel(){
        return promptAlertLabel.getText();
    }
    public void clickOnConfirmAlertButton(){
        confirmAlertButton.click();
        log.info("Button has been clicked");
    }

    public void switchToAndAcceptConfirmAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    public String getConfirmAlertLabel(){
        return confirmAlertLabel.getText();
    }
    public void clickOnDelayedAlertButton(){
        delayedAlertButton.click();
        log.info("Button has been clicked");
    }
    public void switchToAndAcceptDelayedAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    public String getDelayedAlertLabel(){
        return delayedAlertLabel.getText();
    }
}
