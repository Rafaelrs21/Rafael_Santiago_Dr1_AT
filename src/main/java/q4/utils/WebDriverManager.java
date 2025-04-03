package q4.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        driver = new FirefoxDriver();
        return driver;
    }

    public static void quitDriver() {
            driver.quit();
    }
}