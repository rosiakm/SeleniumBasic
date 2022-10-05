package widgets.tooltip;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static base.TestBase.getDriver;
import static helpers.WaitHandler.waitForElementToBeVisible;
import static org.assertj.core.api.Assertions.assertThat;

public class TooltipPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(TooltipPage.class);

    @FindBy(css = "#age")
    private WebElement input;
    @FindBy(css = "div[role='tooltip'] div")
    private WebElement tooltipContent;

    public TooltipPage(){
        super();
    }

    public void printTheTextFromTooltip(){
        Actions action = new Actions(TestBase.getDriver());
        action.moveToElement(input).perform();
        log.info("Hovering over element");
        waitForElementToBeVisible(tooltipContent);
        System.out.println(tooltipContent.getText());

        Assertions.assertThat(tooltipContent.getText()).isEqualTo("We ask for your age only for statistical purposes.");
    }
}
