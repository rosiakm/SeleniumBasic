package widgets.selectMenu;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectMenuTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(SelectMenuTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/selectmenu.php";

    @Test
    @Tag("Widget")
    public void selectOptionsTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new SelectMenuPage().selectOptions();
    }
}
