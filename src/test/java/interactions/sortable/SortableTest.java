package interactions.sortable;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortableTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(SortableTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/sortable.php";

    @Test
    @Tag("Interactions")
    public void sortItemsTest() {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new SortablePage(getDriver()).shuffleAndSortItems(getDriver());
    }
}
