package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceCallsPage {

    public ServiceCallsPage(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    private ChromeDriver chromeDriver;

    @FindBy(tagName = "filters-selector")
    WebElement selectViewButton;

    @FindBy(xpath = "//*[contains(text(), 'Finished')]")
    WebElement finishedFilter;

    @FindBy(id = "cs-grid")
    WebElement serviceCallList;

    @FindBy(className = "action-bar-button")
    WebElement tecoButton;

    public WebElement getSelectViewButton() {
        return selectViewButton;
    }

    public WebElement getFinishedFilter() {
        return finishedFilter;
    }

    public WebElement getServiceCallList() {
        return serviceCallList;
    }

    public WebElement getTecoButton() {
        return tecoButton;
    }
}
