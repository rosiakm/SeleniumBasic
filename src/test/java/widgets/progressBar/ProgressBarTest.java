package widgets.progressBar;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressBarTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(ProgressBarTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/progressbar.php";

    @Test
    @Tag("Widget")
    public void waitForLabelTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new ProgressBarPage().waitForProgressBarToComplete();
    }
}
