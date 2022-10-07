package widgets.slider;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SliderTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(SliderTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/slider.php";

    @Test
    @Tag("Widget")
    public void moveTheSliderTest() {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new SliderPage(getDriver()).moveSliderToSpecificLocations();
    }
}
