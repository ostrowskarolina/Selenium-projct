import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void baseBeforeMethod(){
        driver = WebDriverFactory.getDriver();
    }

    @AfterClass
    public void baseAfterMethod(){
        WebDriverFactory.quitDriver();
    }
}
