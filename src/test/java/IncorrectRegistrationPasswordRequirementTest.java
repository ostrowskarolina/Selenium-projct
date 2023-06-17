import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

public class IncorrectRegistrationPasswordRequirementTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver();
    }

    @DataProvider
    public Object[][] incorrectRegistrationData(){
        return new Object[][]{
                {"k@k.com", "Karolina1", "Karolina1", "Passwords must have at least one non alphanumeric character."},
                {"k@k.com", "Karolina!", "Karolina!", "Passwords must have at least one digit ('0'-'9')."},
                {"k@k.com", "karolina1!", "karolina1!", "Passwords must have at least one uppercase ('A'-'Z')."}
        };
    }

    @Test(dataProvider = "incorrectRegistrationData")
    public void incorrectRegistrationTest(String email, String password, String confPassword, String expectedError) {
        this.setup();
        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegister();
        createAccountPage.insertEmail(email);
        createAccountPage.insertPassword(password);
        createAccountPage.insertConfirmationPassword(confPassword);
        createAccountPage.submitRegistrationWithFailure();

        Assert.assertEquals(createAccountPage.loginErrors.get(0).getText(), expectedError);
        WebDriverFactory.quitDriver();
    }
}
