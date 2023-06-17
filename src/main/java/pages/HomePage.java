package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElm;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;


    public HomePage assertWelcomeElementIsShown() {
        Assert.assertTrue(welcomeElm.isDisplayed(), "Welcome element is not shown." );
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + welcomeElm.getText() + "' does not contain word 'Welcome'");
        return this;
    }

    @FindBy(css=".menu-workspace")
    private WebElement workspaceNav;

    @FindBy(css=".menu-home")
    private WebElement homeNav;

    @FindBy(css="a[href$=Projects]")
    private WebElement processMenu;

    @FindBy(css="a[href$=Characteristics]")
    private WebElement characterisicsMenu;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardMenu;



    private boolean isParentExpanded(WebElement menuLink) {
        WebElement parent = menuLink.findElement(By.xpath("./.."));
        return parent.getAttribute("class").contains("active");
    }

    public ProcessPage goToProcesses(){
        if (!isParentExpanded(workspaceNav)) {
            workspaceNav.click();
        }

        processMenu.click();

        return new ProcessPage(driver);
    }
//
//    public CharacteristicPage goToCharacteristics(){
//        if (!isParentExpanded(workspaceNav)){
//            workspaceNav.click();
//        }
//        processMenu.click();
//
//        return new CharacteristicPage(driver);
//
//    }
//
//    public DashboardsPage goToDashboards(){
//        if (!isParentExpanded(homeNav)){
//            homeNav.click();
//        }
//
//        dashboardMenu.click();
//
//        return new DashboardsPage(driver);
//    }
}

