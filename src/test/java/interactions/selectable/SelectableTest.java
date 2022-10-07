package interactions.selectable;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(SelectableTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/selectable.php";

    @Test
    @Tag("Interactions")
    public void selectMultipleItemsTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        SelectablePage selectable = new SelectablePage(getDriver());
        selectable.selectItems(getDriver());
        assertThat(selectable.toString()).isEqualTo("You've selected: #1 #3 #4");
    }
}
