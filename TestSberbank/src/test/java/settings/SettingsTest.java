package settings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class SettingsTest {
    private static WebDriver driver;
    private static WebDriverWait wait;


    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    @BeforeEach
    void initDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver1.exe");
        //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }
}
