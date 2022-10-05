package interactions.draggable;

import base.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static base.TestBase.getDriver;

public class DraggablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(DraggablePage.class);

    @FindBy(css = "#draggable")
    private WebElement draggableElement;
    @FindBy(css = "html")
    private WebElement screen;

    public DraggablePage(){
        super();
    }

    public void dragSquareToRightPlaces(){
        Point currentLocation = draggableElement.getLocation();
        log.info("My element location is: " + currentLocation);
        Dimension draggableElementSize = draggableElement.getSize();
        log.info("My element size is: " + draggableElementSize);
        Dimension screenSize = screen.getSize();
        log.info("Screen size is: " + screenSize);

        Actions action = new Actions(TestBase.getDriver());
        action.dragAndDropBy(draggableElement,(screenSize.width-currentLocation.getX()- draggableElementSize.getWidth())
                ,-currentLocation.getY()).perform();
        Point newLocation = draggableElement.getLocation();
        log.info("Element location in right top corner is: " + newLocation);
        action.dragAndDropBy(draggableElement, 0,screenSize.getHeight()).perform();
        action.dragAndDropBy(draggableElement,-(newLocation.getX()/2),-(screenSize.getHeight()/2)).perform();
        action.dragAndDropBy(draggableElement,-(newLocation.getX())/2, (screenSize.getHeight()/2)).perform();
    }
}
