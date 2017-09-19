import Pages.LoginPage;
import Pages.ServiceCallsPage;
import Pages.WfmPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

public class ServiceCallsTest {

    private ChromeDriver chromeDriver;
    private LoginPage loginPage;
    private ServiceCallsPage serviceCallsPage;

    @BeforeClass
    public void setup(){
        chromeDriver = Utils.initializeChromeDriver();
        chromeDriver.get("https://et.coresystems.net/workforce-management/#/service-calls");
        loginPage = new LoginPage(chromeDriver);
        serviceCallsPage = new ServiceCallsPage(chromeDriver);
        loginPage.doLogin("core-doko-et2", "manager", "vista7");
    }

    @Test
    public void checkTechnicallyComplete() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, 10);
        if (!serviceCallsPage.getSelectViewButton().getText().split("\n")[0].equals("Finished")) {
            serviceCallsPage.getSelectViewButton().click();
            try {
                webDriverWait.until(ExpectedConditions.elementToBeClickable(serviceCallsPage.getFinishedFilter()));
                serviceCallsPage.getFinishedFilter().click();
            } catch (TimeoutException e) {
                fail("Timeout exception!!!");
            }
        }
        Utils.waitForAjaxLoad(chromeDriver);
        serviceCallsPage.getServiceCallList().findElements(By.className("material-icons")).get(0).click();
        assertTrue(serviceCallsPage.getTecoButton().isDisplayed());
    }

    @AfterClass
    public void finish(){
        if (chromeDriver != null){
            chromeDriver.quit();
        }
    }
}
