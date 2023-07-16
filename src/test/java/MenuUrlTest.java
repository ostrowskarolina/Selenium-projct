import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class MenuUrlTest extends BaseTest {
    HomePage homePage;

    @BeforeClass
    public void login() {

        String email = "test@test.com";
        String password = "Test1!";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        homePage = loginPage.submitLogin();
    }

    @Test
    public void CorrectDashboardUrlTest() {
        DashboardPage dashboardPage = homePage.goToDashboard();
        String pageUrl = "http://localhost:4444/";
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
    }

    @Test
    public void CorrectProcessesUrlTest() {
        ProcessPage processPage = homePage.goToProcesses();
        String pageUrl = "http://localhost:4444/Projects";
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
    }

    @Test
    public void CorrectCharacterUrlTest() {
        CharacterPage characterPage = homePage.goToCharacteristics();
        String pageUrl = "http://localhost:4444/Characteristics";
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
    }

}
