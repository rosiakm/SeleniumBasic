package widgets.progressBar;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.WaitHandler.waitForElementToBeVisible;
import static org.assertj.core.api.Assertions.assertThat;

public class ProgressBarPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(ProgressBarPage.class);

    @FindBy(xpath = "//div[contains(text(),'Complete')]")
    private WebElement completeLabel;

    public ProgressBarPage(){
        super();
    }

    public void waitForProgressBarToComplete(){
        waitForElementToBeVisible(completeLabel);

        Assertions.assertThat(completeLabel.getText()).isEqualTo("Complete!");
    }
}
