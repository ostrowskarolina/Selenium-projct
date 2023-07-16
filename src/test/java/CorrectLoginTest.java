import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CorrectLoginTest extends BaseTest {

    @Test
    public void correctLoginTest() {

        String email = "test@test.com";
        String password = "Test1!";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        HomePage homePage = loginPage.submitLogin();

        Assert.assertTrue(homePage.welcomeElm.isDisplayed());
        Assert.assertTrue(homePage.welcomeElm.getText().contains("Welcome"));
    }

}
