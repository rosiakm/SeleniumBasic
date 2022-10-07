package interactions.sortable;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SortablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(SortablePage.class);

    @FindBy(css = "#sortable span")
    private List<WebElement> items;

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public void shuffleAndSortItems(WebDriver driver) {
        Actions actions = new Actions(driver);
        List<Integer> numbers = createListOfNumbers();
        Map<Integer, WebElement> pairs = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            pairs.put(numbers.get(i), (items.get(i)));
        }
        Collections.shuffle(numbers);
        log.info("Numbers order: " + numbers);
        for (int i = 1; i <= pairs.size(); i++) {
            int numberIndex = numbers.indexOf(i);
            actions.clickAndHold(pairs.get(i)).moveToElement(items.get(numberIndex), 0, 5).release().perform();
        }
    }

    private List<Integer> createListOfNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
