package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateProcessPage extends ProcessPage {

    protected WebDriver driver;

    public CreateProcessPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Name")
    private WebElement nameTxt;

    @FindBy(id = "Description")
    private WebElement descTxt;

    @FindBy(id = "Notes")
    private WebElement notesTxt;

    @FindBy(css=".btn btn-success")
    public WebElement createBtn;

    public CreateProcessPage typeName(String name) {
        nameTxt.clear();
        nameTxt.sendKeys(name);
        return this;
    }

    public CreateProcessPage typeDesc(String desc) {
        descTxt.clear();
        descTxt.sendKeys(desc);
        return this;
    }

    public CreateProcessPage typeNotes(String notes) {
        notesTxt.clear();
        notesTxt.sendKeys(notes);
        return this;
    }

}
