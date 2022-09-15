package basic.tables;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(TableTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/table.php";

    @Test
    @Tag("Tables")
    public void printOutSpecificDataFromTableTest(){
        getDriver().get(websiteAddress);
        log.info("Website address is " + websiteAddress);
        new TablePage().selectSpecificData();
    }
}
