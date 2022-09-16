package basic.tables;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(TablePage.class);

    @FindBy(css = "tbody tr")
    private List<WebElement> tableRows;
    @FindBy(css = "thead th")
    private List<WebElement> tableIndexes;

    public TablePage() {
        super();
        log.info("Elements on the website are initialized");
    }

    public void selectSpecificData() {
        int rankIndex = getColumnIndexByName("Rank");
        int peakIndex = getColumnIndexByName("Peak");
        int mountainRangeIndex = getColumnIndexByName("Mountain range");
        int stateIndex = getColumnIndexByName("State");
        int heightIndex = getColumnIndexByName("Height");

        for (WebElement tempRow : tableRows) {
            List<WebElement> cells = tempRow.findElements(By.cssSelector("th, td"));
            log.info("List of cells within specific row has been built");
            if (cells.get(stateIndex).getText().contains("Switzerland") && Integer.parseInt(cells.get(heightIndex).getText()) > 4000) {
                System.out.println(cells.get(rankIndex).getText() + " " + cells.get(peakIndex).getText() + " " + cells.get(mountainRangeIndex).getText());
            }
        }
    }

    public int getColumnIndexByName(String columnName) {
        for (int i = 0; i < tableIndexes.size(); i++) {
            if (tableIndexes.get(i).getText().equals(columnName)) {
                return i - 1;
            }
        }
        return -1;
    }
}
