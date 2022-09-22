package interactions.resizeable;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResizeableTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(ResizeableTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/resizable.php";

    @Test
    @Tag("Interactions")
    public void resizeElementTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new ResizeablePage().resizeElement();
    }
}
