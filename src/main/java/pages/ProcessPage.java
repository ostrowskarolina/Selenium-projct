package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProcessPage extends HomePage {
    protected WebDriver driver;

    public ProcessPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".btn btn-success")
    private WebElement addProcessBtn;

    @FindBy(css=".table table-striped jambo_table")
    public WebElement processesTable;


    public CreateProcessPage addNewProcess() {
        addProcessBtn.click();
        CreateProcessPage createProcessPage = new CreateProcessPage(driver);
        return createProcessPage;
    }


}
