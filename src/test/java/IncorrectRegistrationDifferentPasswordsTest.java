import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

public class IncorrectRegistrationDifferentPasswordsTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver();
    }

    @DataProvider
    public Object[][] incorrectRegistrationData(){
        return new Object[][]{
                {"k@k.com", "Karolina1!", "Karolina2!", "The password and confirmation password do not match."}
        };
    }

    @Test(dataProvider = "incorrectRegistrationData")
    public void incorrectRegistrationTest(String email, String password, String confPassword, String expectedError) {

        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegister();
        createAccountPage.insertEmail(email);
        createAccountPage.insertPassword(password);
        createAccountPage.insertConfirmationPassword(confPassword);
        createAccountPage.submitRegister();

        Assert.assertEquals(createAccountPage.confirmPasswordError.getText(), expectedError);

        WebDriverFactory.quitDriver();
    }
}
