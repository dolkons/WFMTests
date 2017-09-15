import Pages.LoginPage;
import Pages.SkillsMgmtPage;
import Pages.WfmPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SkillsManagementTest {

    private ChromeDriver chromeDriver;
    private WfmPage wfmPage;
    private LoginPage loginPage;
    private SkillsMgmtPage skillPage;

    @BeforeClass
    public void setup(){
        chromeDriver = Utils.initializeChromeDriver();
        wfmPage = new WfmPage(chromeDriver);
        loginPage = new LoginPage(chromeDriver);
        skillPage = new SkillsMgmtPage(chromeDriver);
        loginPage.doLogin("core-doko-et", "manager", "vista7");
    }

    @BeforeMethod(enabled = false)
    public void loginToWfm(){
        loginPage.doLogin("core-doko-et", "manager", "vista7");
        WebDriverWait loginWait = new WebDriverWait(chromeDriver, 10);
        try {
            loginWait.until(ExpectedConditions.elementToBeClickable(wfmPage.getCreateServiceCallButton()));
        } catch (TimeoutException e){
            e.printStackTrace();
        }
    }

    @Test
    public void EmptyName() throws Exception {
        wfmPage.clickOnSkillsMgmtButton();
        skillPage.clickOnSkillButton();
        skillPage.typeSkillDescription("test");
        skillPage.getSkillDescriptionInput().sendKeys(Keys.TAB);
        assertEquals("Color is not valid! ", skillPage.getSkillNameInput().getCssValue("background-color"),"rgba(255, 191, 191, 1)");
    }

    @Test
    public void createSkill(){
        skillPage.typeSkillName("test");
        skillPage.clickOnHeader();
    }


    @AfterClass
    public void finish(){
        if (chromeDriver != null){
            chromeDriver.quit();
        }
    }
}
