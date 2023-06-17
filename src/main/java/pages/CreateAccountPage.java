package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccountPage {

    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmationPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(id = "Email-error")
    public WebElement emailError;

    @FindBy(id = "ConfirmPassword-error")
    public WebElement confirmPasswordError;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElement;

    public CreateAccountPage insertEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;

    }

    public CreateAccountPage insertPassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;

    }

    public CreateAccountPage insertConfirmationPassword(String password) {
        confirmationPasswordTxt.clear();
        confirmationPasswordTxt.sendKeys(password);
        return this;
    }

    public CreateAccountPage submitRegistrationWithFailure() {
        registerBtn.click();
        return this;
    }

    public HomePage submitRegister() {
        registerBtn.click();
        return new HomePage(driver);
    }
}



