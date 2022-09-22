package interactions.selectable;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static base.TestBase.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SelectablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(SelectablePage.class);

    @FindBy(css = "#selectable li")
    private List<WebElement> selectsList;
    @FindBy(css = "#feedback span")
    private List<WebElement> feedback;

    public SelectablePage(){
        super();
    }

    public void selectItems(){
        assertThat(selectsList.size()).isGreaterThan(0);
        new Actions(getDriver()).keyDown(Keys.CONTROL).click(selectsList.get(0)).click(selectsList.get(2)).
                click(selectsList.get(3)).build().perform();
        assertThat(toString()).isEqualTo("You've selected: #1 #3 #4");
    }

    @Override
    public String toString(){
        return feedback.get(0).getText() + " " + feedback.get(1).getText();
    }
}
