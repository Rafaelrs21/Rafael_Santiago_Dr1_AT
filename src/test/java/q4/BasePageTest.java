package q4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import q4.utils.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasePageTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("https://automationexercise.com");
    }

    @Test
    public void testHomePageTitle() {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals("Automation Exercise", expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}