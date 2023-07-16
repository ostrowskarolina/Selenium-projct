import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

public class IncorrectRegistrationPasswordRequirementTest extends BaseTest {
    CreateAccountPage createAccountPage;

    private String generateLongPassword() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 102; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
    @DataProvider
    public Object[][] incorrectRegistrationData(){
        return new Object[][]{
                {"k@k.com", "Karolina1", "Karolina1", "Passwords must have at least one non alphanumeric character."},
                {"k@k.com", "Karolina!", "Karolina!", "Passwords must have at least one digit ('0'-'9')."},
                {"k@k.com", "karolina1!", "karolina1!", "Passwords must have at least one uppercase ('A'-'Z')."},
                {"k@k.com", "KAROLINA1!", "KAROLINA1!", "Passwords must have at least one lowercase ('a'-'z')."},
                {"k@k.com", "Kk1!", "Kk1!", "The Password must be at least 6 and at max 100 characters long."},
                {"k@k.com", generateLongPassword(), generateLongPassword(), "The Password must be at least 6 and at max 100 characters long."},
                {"k@k.com", "", "", "The Password field is required."}
        };
    }

    @BeforeClass
    public void createLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        createAccountPage = loginPage.goToRegister();
    }

    @Test(dataProvider = "incorrectRegistrationData")
    public void incorrectRegistrationTest(String email, String password, String confPassword, String expectedError) {

        createAccountPage.insertEmail(email);
        createAccountPage.insertPassword(password);
        createAccountPage.insertConfirmationPassword(confPassword);
        createAccountPage.submitRegistrationWithFailure();

        Assert.assertEquals(createAccountPage.loginErrors.get(0).getText(), expectedError);
    }
}
