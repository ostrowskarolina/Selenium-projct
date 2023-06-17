package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(id = "Email-error")
    public WebElement emailError;

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElement;

    @FindBy(css = "a[href*=Register]")
    public WebElement registerLnk;

    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();
        return new HomePage(driver);
    }

    public LoginPage submitLoginWithFailure() {
        loginBtn.click();
        return this;
    }

    public LoginPage expectLoginError(String expError) {
        boolean doesErrorExists = false;
        for (int i = 0; i < loginErrors.size(); i++) {
            if (loginErrors.get(i).getText().equals(expError)) {
                doesErrorExists = true;
                break;
            }
        }

        Assert.assertTrue(doesErrorExists);
        return this;
    }

    public CreateAccountPage goToRegister() {
        registerLnk.click();
        return new CreateAccountPage(driver);
    }

}
