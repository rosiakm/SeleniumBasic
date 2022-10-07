package widgets.accordion;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccordionWidgetsTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(AccordionWidgetsTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/accordion.php";

    @Test
    @Tag("Widget")
    public void printTheTextFromSectionOneTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new AccordionWidgetsPage(getDriver()).printOutTheTextFromSectionOne();
    }
    @Test
    @Tag("Widget")
    public void printTheTextFromSectionTwoTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new AccordionWidgetsPage(getDriver()).printOutTheTextFromSectionTwo();
    }
    @Test
    @Tag("Widget")
    public void printTheTextFromSectionThreeTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new AccordionWidgetsPage(getDriver()).printOutTheTextFromSectionThree(getDriver());
    }
    @Test
    @Tag("Widget")
    public void printTheTextFromSectionFourTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new AccordionWidgetsPage(getDriver()).printOutTheTextFromSectionFour(getDriver());
    }
}
