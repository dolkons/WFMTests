import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private ChromeDriver chromeDriver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup(){
        chromeDriver = Utils.initializeChromeDriver();
        loginPage = new LoginPage(chromeDriver);
    }

    @Test
    public void LoginTestEmptyPassword(){
        loginPage.typeCloudAccount("core-doko-et");
        loginPage.clickOnLoginButton();
    }

    @AfterClass
    public void finish(){
        if (chromeDriver != null){
            chromeDriver.quit();
        }
    }
}
