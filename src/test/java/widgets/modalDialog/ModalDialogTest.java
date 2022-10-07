package widgets.modalDialog;

import base.TestBase;
import helpers.DataFaker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;import static org.assertj.core.api.Assertions.assertThat;

public class ModalDialogTest extends TestBase {
    private final DataFaker dataFaker = new DataFaker();
    private static Logger log = LoggerFactory.getLogger(ModalDialogTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/modal-dialog.php";

    @Test
    @Tag("Widget")
    public void addNewUserTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        ModalDialogPage modal = new ModalDialogPage(getDriver());
        int startSize = modal.returnUserTableRowsSize();
        modal.clickOnCreateUserButton();
        modal.clearNameInput();
        String name = dataFaker.setFirstName() + " " + dataFaker.setLastName();
        modal.provideName(name);
        modal.clearEmailInput();
        String email = dataFaker.setEmail();
        modal.provideEmail(email);
        modal.clearPasswordInput();
        String password = dataFaker.setPassword();
        modal.providePassword(password);
        modal.clickOnCreateAccountButton();
        modal.waitForCreateUserButtonToBeClickable(getDriver());
        int endSize = modal.returnUserTableRowsSize();

        assertThat(endSize).isEqualTo(startSize+1);
        assertThat(modal.getNameFromNewRowData()).isEqualTo(name);
        assertThat(modal.getEmailFromNewRowData()).isEqualTo(email);
        assertThat(modal.getPasswordFromNewRowData()).isEqualTo(password);
    }
}
