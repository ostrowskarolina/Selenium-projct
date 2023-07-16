import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

import java.util.UUID;

public class IncorrectRegistrationDifferentPasswordsTest extends BaseTest {

    @Test
    public void incorrectRegistrationTest() {

        String randomString = UUID.randomUUID().toString().substring(0, 5);
        String email = "user_" + randomString + "@mail.com";
        String password = "Passwd1!";
        String confPassword = "Passwd2!";
        String expectedError = "The password and confirmation password do not match.";

        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegister();
        createAccountPage.insertEmail(email);
        createAccountPage.insertPassword(password);
        createAccountPage.insertConfirmationPassword(confPassword);
        createAccountPage.submitRegister();

        Assert.assertEquals(createAccountPage.confirmPasswordError.getText(), expectedError);
        Assert.assertTrue(createAccountPage.confirmPasswordError.isDisplayed());
    }
}
