package widgets.datepicker;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class DatepickerPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(DatepickerPage.class);

    @FindBy(css = "#datepicker")
    private WebElement datepickerInput;
    @FindBy(css = "td[class*='ui-datepicker-today']")
    private WebElement currentDateButton;

    public void setParticularDate(){
        Date date = new Date();
    }
}
