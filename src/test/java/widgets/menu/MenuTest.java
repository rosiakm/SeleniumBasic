package widgets.menu;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(MenuTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/menu-item.php";

    @Test
    @Tag("Widget")
    public void getTheOptionFromMenuTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new MenuPage().getTheOptionFromMenu();
    }
}
