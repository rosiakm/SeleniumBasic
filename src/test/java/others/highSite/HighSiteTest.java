package others.highSite;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HighSiteTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(HighSiteTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/high-site.php";

    @Test
    @Tag("Others")
    public void scrollDownTest() throws IOException {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        HighSitePage highSite = new HighSitePage(getDriver());
        highSite.scrollToSpecificElement(getDriver());
        highSite.scrollBySpecificAmount(getDriver(),0,200);
        highSite.takeScreenshotOfElement(getDriver());
    }
}
