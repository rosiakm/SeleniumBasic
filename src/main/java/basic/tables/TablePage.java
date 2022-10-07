package basic.tables;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(TablePage.class);

    @FindBy(css = "tbody tr")
    private List<WebElement> tableRows;
    @FindBy(css = "thead th")
    private List<WebElement> tableIndexes;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void selectSpecificData() {
        assertThat(tableRows.size()).isGreaterThan(0);
        for (WebElement tempRow : tableRows) {
            List<WebElement> cells = tempRow.findElements(By.cssSelector("th, td"));
            if (cells.get(3).getText().contains("Switzerland") && Integer.parseInt(cells.get(4).getText()) > 4000) {
                System.out.println(cells.get(0).getText() + " " + cells.get(1).getText() + " " + cells.get(2).getText());
            }
        }
    }
}
