import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import java.util.UUID;

public class CorrectRegistrationTest extends BaseTest {

    @Test()
    public void correctRegistrationTest() {

        String randomString = UUID.randomUUID().toString().substring(0, 5);
        String email = "user_" + randomString + "@mail.com";
        String password = "Passwd1!";
        String confPassword = "Passwd1!";

        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegister();
        createAccountPage.insertEmail(email);
        createAccountPage.insertPassword(password);
        createAccountPage.insertConfirmationPassword(confPassword);
        HomePage homePage = createAccountPage.submitRegister();

        Assert.assertTrue(homePage.welcomeElm.isDisplayed());
        Assert.assertTrue(homePage.welcomeElm.getText().contains("Welcome"));
    }

}
