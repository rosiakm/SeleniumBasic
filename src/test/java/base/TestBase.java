package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class TestBase {
    private static Logger log = LoggerFactory.getLogger(TestBase.class);

    private static WebDriver driver;
    private static final String downloadDir = "C:\\Users\\matros\\IdeaProjects\\SeleniumBasic\\downloads";

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getDownloadDir() {
        return downloadDir;
    }

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        log.info("WebDriver started successfully");
    }

    @BeforeEach
    public void setupBrowser() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadDir);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("prefs", chromePrefs);
        log.info("Default download directory has been set");
        driver = new ChromeDriver(options);
        log.info("Maximized browser opened successfully");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        log.info("WebDriver closed");
    }
}
