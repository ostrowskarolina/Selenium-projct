import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProcessPage;

public class MenuUrlTest {
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
    public void CorrectProcessesUrlTest(String email, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        HomePage homePage = loginPage.submitLogin();
        ProcessPage processPage = homePage.goToProcesses();
        String pageUrl = "http://localhost:4444/Projects";
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

        WebDriverFactory.quitDriver();
    }
}
