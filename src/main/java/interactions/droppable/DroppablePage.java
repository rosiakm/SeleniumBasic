package interactions.droppable;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static base.TestBase.getDriver;
import static helpers.WaitHandler.waitForElementToBeVisible;
import static org.assertj.core.api.Assertions.assertThat;

public class DroppablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(DroppablePage.class);

    @FindBy(css = "#draggable")
    private WebElement draggableElement;
    @FindBy(css = "#droppable")
    private WebElement droppableElement;
    @FindBy(css = "#droppable p")
    private WebElement droppableElementLabel;

    public DroppablePage(){
        super();
    }

    public void dragAndDropElement(){
        Actions actions = new Actions(TestBase.getDriver());
        actions.dragAndDrop(draggableElement,droppableElement).perform();
        waitForElementToBeVisible(droppableElementLabel);
        Assertions.assertThat(droppableElementLabel.getText()).isEqualTo("Dropped!");
    }

}
