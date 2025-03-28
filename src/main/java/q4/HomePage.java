package q4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Signup / Login")
    private WebElement signupLoginLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        signupLoginLink.click();
    }
}