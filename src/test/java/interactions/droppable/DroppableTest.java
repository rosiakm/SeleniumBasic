package interactions.droppable;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroppableTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(DroppableTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/droppable.php";

    @Test
    @Tag("Interactions")
    public void dragAndDropTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new DroppablePage().dragAndDropElement();
    }
}
