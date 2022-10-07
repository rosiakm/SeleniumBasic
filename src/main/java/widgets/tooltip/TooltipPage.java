package widgets.tooltip;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class TooltipPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(TooltipPage.class);

    @FindBy(css = "#age")
    private WebElement input;
    @FindBy(css = "div[role='tooltip'] div")
    private WebElement tooltipContent;

    public TooltipPage(WebDriver driver){
        super(driver);
    }

    public void hoverOverInput(WebDriver driver){
        Actions action = new Actions(driver);
        action.moveToElement(input).perform();
        log.info("Hovering over element");
    }
    public void waitForTooltipToBeVisible(WebDriver driver){
        waitForElementToBeVisible(driver, tooltipContent);
    }
    public void printTheTooltipContent(){
        System.out.println(tooltipContent.getText());
    }
    public String getTooltipContent(){
        return tooltipContent.getText();
    }
}
