package widgets.autocomplete;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutocompleteTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(AutocompleteTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/autocomplete.php";

    @Test
    @Tag("Widget")
    public void checkTheInputValueTest(){
        AutocompletePage page = new AutocompletePage();
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        page.typeInSearchInput();
        page.printAllOptions();
        page.selectRandomOption();
    }

}
