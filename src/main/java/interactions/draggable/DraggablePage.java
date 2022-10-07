package interactions.draggable;

import base.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DraggablePage extends BasePage {
    @FindBy(css = "#draggable")
    private WebElement draggableElement;
    @FindBy(css = "html")
    private WebElement screen;

    public DraggablePage(WebDriver driver){
        super(driver);
    }

    public Point getCurrentLocation(){
        return draggableElement.getLocation();
    }
    public Dimension getDraggableElementSize(){
        return draggableElement.getSize();
    }
    public Dimension getScreenSize(){
        return screen.getSize();
    }

    public void dragAndDropElementInRightTopCorner(WebDriver driver) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(draggableElement, (getScreenSize().width -
                        getCurrentLocation().getX() -
                        getDraggableElementSize().getWidth())
                , -getCurrentLocation().getY()).perform();
    }
    public Point getNewLocation() {
        return draggableElement.getLocation();
    }
    public void dragAndDropElementInRightDownCorner(WebDriver driver){
        Actions action = new Actions(driver);
        action.dragAndDropBy(draggableElement, 0,getScreenSize().getHeight()).perform();
    }
    public void dragAndDropElementInTheCenter(WebDriver driver){
        Actions action = new Actions(driver);
        action.dragAndDropBy(draggableElement,-(getNewLocation().getX()/2),-(getScreenSize().getHeight()/2)).perform();
    }
    public void dragAndDropElementInLefDownCorner(WebDriver driver){
        Actions action = new Actions(driver);
        action.dragAndDropBy(draggableElement,-(getNewLocation().getX())/2, (getScreenSize().getHeight()/2)).perform();
    }
}
