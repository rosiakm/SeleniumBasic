package basic.iframes;

import base.TestBase;
import helpers.DataFaker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class iFramesTest extends TestBase {
    private final DataFaker dataFaker = new DataFaker();
    private static final Logger log = LoggerFactory.getLogger(iFramesTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/iframes.php";

    @Test
    @Tag("iFrame")
    public void iFramesPositiveTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        iFramesPage iFrames = new iFramesPage(getDriver());
        iFrames.switchToIFrameOne(getDriver());
        iFrames.setFirstName(dataFaker.setFirstName());
        iFrames.setSurname(dataFaker.setLastName());
        log.info("Fields in iFrame nr 1 has been filled");
        iFrames.switchToDefaultContent(getDriver());
        iFrames.switchToIFrameTwo(getDriver());
        iFrames.setLogin(dataFaker.setEmail());
        iFrames.setPassword(dataFaker.setPassword());
        iFrames.selectFromDropdownListByValue("europe");
        iFrames.getRandomRadioButton();
        log.info("Fields and selects in iFrame nr 2 has been filled");
        iFrames.switchToDefaultContent(getDriver());
        iFrames.clickOnBasicLinkText();
    }
}
