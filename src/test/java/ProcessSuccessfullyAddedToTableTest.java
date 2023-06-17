import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class ProcessSuccessfullyAddedToTableTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver();
    }

    @DataProvider
    public Object[][] correctLoginAndProcessData(){
        return new Object[][]{
                {"test@test.com", "Test1!", "process name", "process desc", "process notes"}
        };
    }

    @Test(dataProvider = "correctLoginAndProcessData")
    public void processAddedTest(String email, String password, String name, String desc, String notes) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        HomePage homePage = loginPage.submitLogin();
        ProcessPage processPage = homePage.goToProcesses();
        CreateProcessPage createProcessPage = processPage.addNewProcess();
        createProcessPage.typeName(name);
        createProcessPage.typeDesc(desc);
        createProcessPage.typeName(notes);
        createProcessPage.createBtn.click();

        List<WebElement> rows = processPage.processesTable.findElements(By.cssSelector("tr"));
        WebElement lastRow = rows.get(rows.size() - 1);
        WebElement lastProcessName = lastRow.findElements(By.tagName("td")).get(0);
        Assert.assertEquals(lastProcessName.getText(), name);

        WebDriverFactory.quitDriver();
    }
}
