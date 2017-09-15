package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WfmPage {

    public WfmPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "icon-skills")
    private WebElement skillsMgmtButton;

    @FindBy(id = "action-button")
    private WebElement createServiceCallButton;

    public WebElement getCreateServiceCallButton() {
        return createServiceCallButton;
    }

    public void clickOnSkillsMgmtButton(){
        try {
            skillsMgmtButton.click();
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }
}
