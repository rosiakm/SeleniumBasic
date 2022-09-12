package basic.iframes;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class iFramesTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(iFramesTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/iframes.php";

    @Test
    @Tag("iFrame")
    public void iFramesPositiveTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new iFramesPage().fillAllFramesOnTheSite();
    }
}
