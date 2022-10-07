package interactions.resizeable;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResizeablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(ResizeablePage.class);

    @FindBy(css = "div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
    private WebElement icon;

    public ResizeablePage(WebDriver driver) {
        super(driver);
    }

    public void resizeElementInXAxis(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(icon, 100, 0).perform();
    }

    public void resizeElementInYAxis(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(icon, 0, 100).perform();
    }

    public void resizeElementInBothAxis(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(icon, 100, 100).perform();
    }
}
