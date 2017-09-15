package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input_0")
    private WebElement cloudAccountInput;

    @FindBy(id = "input_1")
    private WebElement accountNameInput;

    @FindBy(id = "input_2")
    private WebElement accountPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public WebElement getCloudAccountInput() {
        return cloudAccountInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void clickOnLoginButton(){
        this.loginButton.click();
    }

    public void typeCloudAccount(String value){
        this.cloudAccountInput.sendKeys(value);
    }

    public void typeAccount(String value){
        this.accountNameInput.sendKeys(value);
    }

    public void typePassword(String value){
        this.accountPassword.sendKeys(value);
    }

    public void doLogin(String cloudAccount, String account, String password){
        this.typeCloudAccount(cloudAccount);
        this.clickOnLoginButton();
        WebDriverWait loginWait = new WebDriverWait(driver, 10);
        try {
            loginWait.until(ExpectedConditions.elementToBeClickable(accountNameInput));
        }
        catch (TimeoutException e){
            e.printStackTrace();
        }
        this.typeAccount(account);
        this.typePassword(password);
        this.clickOnLoginButton();
    }
}
