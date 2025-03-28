package q4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpPageTest extends BasePageTest {

    @Test
    public void testSignUp() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp("Test User", "testuserexample.com");

        assertTrue(signUpPage.isSignUpFormDisplayed(), "Formulário preenchido");
    }
}