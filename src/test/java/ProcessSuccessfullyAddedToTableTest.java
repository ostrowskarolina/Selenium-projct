import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import java.util.UUID;
import java.util.List;

public class ProcessSuccessfullyAddedToTableTest extends BaseTest{

    @Test
    public void processAddedTest() {

        String email = "test@test.com";
        String password = "Test1!";
        String name = UUID.randomUUID().toString().substring(0, 5);
        String desc = "desc";
        String notes = "notes";

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
    }
}
