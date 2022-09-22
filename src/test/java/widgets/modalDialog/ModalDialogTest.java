package widgets.modalDialog;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

public class ModalDialogTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(ModalDialogTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/modal-dialog.php";

    @Test
    @Tag("Widget")
    public void addNewUserTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        new ModalDialogPage().addNewUser();
    }
}
