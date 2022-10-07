package widgets.autocomplete;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(AutocompleteTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/autocomplete.php";

    @Test
    @Tag("Widget")
    public void checkTheInputValueTest() {
        AutocompletePage page = new AutocompletePage(getDriver());
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        page.typeInSearchInput();
        page.printAllOptions();
        page.selectRandomOption();
        assertThat(page.getSelectedOptionValue()).isEqualTo(page.getSelectedElementAttribute("value"));
    }
}
