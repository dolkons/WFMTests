package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillsMgmtPage {

    private WebDriver driver;

    public SkillsMgmtPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "action-button")
    WebElement createSkillButton;

    @FindBy(name = "name")
    WebElement skillNameInput;

    @FindBy(name = "description")
    WebElement skillDescriptionInput;

    @FindBy(id = "input-95")
    WebElement technicianInput;

    @FindBy(xpath = "//*[@id=\"threecolumns-center-container\"]/div/center-column/h2/span")
    WebElement header;

    @FindBy(className = "skills-list")
    WebElement skillsList;

    public WebElement getSkillNameInput() {
        return skillNameInput;
    }

    public WebElement getSkillDescriptionInput() {
        return skillDescriptionInput;
    }

    public WebElement getTechnicianInput() {
        return technicianInput;
    }

    public WebElement getSkillsList() {
        return skillsList;
    }

    public void clickOnSkillButton(){
        this.createSkillButton.click();
    }

    public void typeSkillName(String value){
        this.skillNameInput.sendKeys(value);
    }

    public void typeSkillDescription(String value){
        this.skillDescriptionInput.sendKeys(value);
    }

    public void clickOnHeader(){
        this.header.click();
    }

}
