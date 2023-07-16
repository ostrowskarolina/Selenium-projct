package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CharacterPage extends HomePage {
    protected WebDriver driver;

    public CharacterPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".btn btn-success")
    private WebElement addCharacterBtn;

    @FindBy(css=".table table-striped jambo_table")
    public WebElement processesTable;

//    public CreateProcessPage addNewCharacter() {
//        addCharacterBtn.click();
//        CreateProcessPage createProcessPage = new CreateProcessPage(driver);
//        return createProcessPage;
//    }


}
