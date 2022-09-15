package basic.form;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger(FormTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/form.php";

    @Test
    @Tag("Form")
    public void fillFormWithValidValuesTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new FormPage().fillFormWithSuccess();
    }

    @Test
    @Tag("Form")
    public void downloadFilesTest() throws InterruptedException {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new FormPage().downloadFileFromForm();
    }

    @Test
    @Tag("Form")
    public void checkTheFileNameTest(){
        new FormPage().checkTheFileName();
    }
}
