package widgets.selectMenu;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectMenuTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(SelectMenuTest.class);

    private final String websiteAddress = "https://seleniumui.moderntester.pl/selectmenu.php";

    @Test
    @Tag("Widget")
    public void selectOptionsTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        SelectMenuPage selectMenu = new SelectMenuPage(getDriver());
        selectMenu.clickOnSpeedButton();
        selectMenu.waitForSpeedOptionsToBeVisible(getDriver());
        selectMenu.clickOnRandomOptionFromSpeedList();
        selectMenu.clickOnFilesButton();
        selectMenu.waitForFilesOptionsToBeVisible(getDriver());
        selectMenu.clickOnOptionByText("jQuery.js");
        selectMenu.clickOnNumberButton();
        selectMenu.waitForNumberOptionsToBeVisible(getDriver());
        selectMenu.clickOnNumberOptionByIndex(10);
        selectMenu.clickOnSalutationButton();
        selectMenu.waitForSalutationOptionsToBeVisible(getDriver());
        selectMenu.clickOnRandomSalutationOption();
    }
}
