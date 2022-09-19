package basic.form;

import base.TestBase;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger(FormTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/form.php";

    @Test
    @Tag("Form")
    @Order(1)
    public void fillFormWithValidValuesTest() {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new FormPage().fillFormWithSuccess();
    }

    @Test
    @Tag("Form")
    @Order(2)
    public void downloadFilesTest() throws InterruptedException {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new FormPage().downloadFileFromForm();
    }

    @Test
    @Tag("Form")
    @Order(3)
    public void checkTheFileNameTest() {
        new FormPage().checkTheFileName();
    }
}
