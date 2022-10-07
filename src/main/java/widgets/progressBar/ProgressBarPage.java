package widgets.progressBar;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class ProgressBarPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(ProgressBarPage.class);

    @FindBy(xpath = "//div[contains(text(),'Complete')]")
    private WebElement completeLabel;

    public ProgressBarPage(WebDriver driver){
        super(driver);
    }

    public void waitForProgressBarToComplete(WebDriver driver){
        waitForElementToBeVisible(driver, completeLabel);
    }
    public String getCompleteLabelText(){
        return completeLabel.getText();
    }
}
