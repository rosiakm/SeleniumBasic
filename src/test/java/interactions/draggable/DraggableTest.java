package interactions.draggable;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DraggableTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(DraggableTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/draggable.php";

    @Test
    @Tag("Interactions")
    public void dragElementTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        DraggablePage draggable = new DraggablePage(getDriver());
        draggable.getCurrentLocation();
        draggable.getDraggableElementSize();
        draggable.getScreenSize();
        draggable.dragAndDropElementInRightTopCorner(getDriver());
        draggable.getNewLocation();
        draggable.dragAndDropElementInRightDownCorner(getDriver());
        draggable.dragAndDropElementInTheCenter(getDriver());
        draggable.dragAndDropElementInLefDownCorner(getDriver());
    }
}
