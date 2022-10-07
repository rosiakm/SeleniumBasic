package interactions.droppable;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class DroppablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(DroppablePage.class);

    @FindBy(css = "#draggable")
    private WebElement draggableElement;
    @FindBy(css = "#droppable")
    private WebElement droppableElement;
    @FindBy(css = "#droppable p")
    private WebElement droppableElementLabel;

    public DroppablePage(WebDriver driver){
        super(driver);
    }
    public void dragAndDropElement(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement,droppableElement).perform();
        waitForElementToBeVisible(driver, droppableElementLabel);
    }
    public String getDroppableElementLabel(){
        return droppableElementLabel.getText();
    }
}
