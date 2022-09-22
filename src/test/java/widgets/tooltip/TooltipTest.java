package widgets.tooltip;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TooltipTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(TooltipTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/tooltip.php";

    @Test
    @Tag("Widget")
    public void getTextFromTooltipTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new TooltipPage().printTheTextFromTooltip();
    }
}
