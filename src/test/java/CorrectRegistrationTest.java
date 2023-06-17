import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

public class CorrectRegistrationTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver();
    }

    @DataProvider
    public Object[][] correctRegistrationData(){
        return new Object[][]{
                {"k@k.com", "Karolina1!", "Karolina1!"}
        };
    }

    @Test(dataProvider = "correctRegistrationData")
    public void correctRegistrationTest(String email, String password, String confPassword) {

        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegister();
        createAccountPage.insertEmail(email);
        createAccountPage.insertPassword(password);
        createAccountPage.insertConfirmationPassword(confPassword);
        createAccountPage.submitRegister();

        Assert.assertTrue(createAccountPage.welcomeElement.isDisplayed());
        Assert.assertTrue(createAccountPage.welcomeElement.getText().contains("Welcome"));

        WebDriverFactory.quitDriver();
    }
}
