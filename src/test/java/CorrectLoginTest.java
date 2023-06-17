import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CorrectLoginTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver();
    }

    @DataProvider
    public Object[][] correctLoginData(){
        return new Object[][]{
                {"test@test.com", "Test1!"}
        };
    }

    @Test(dataProvider = "correctLoginData")
    public void correctLoginTest(String email, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.submitLogin();

        Assert.assertTrue(loginPage.welcomeElement.isDisplayed());
        Assert.assertTrue(loginPage.welcomeElement.getText().contains("Welcome"));

        WebDriverFactory.quitDriver();
    }
}
