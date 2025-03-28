package q4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage extends BasePage {

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement signUpEmailField;

    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUp(String name, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);

        wait.until(ExpectedConditions.visibilityOf(signUpEmailField));
        signUpEmailField.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
    }

    public boolean isSignUpFormDisplayed() {
        return signUpEmailField.isDisplayed();
    }
}
