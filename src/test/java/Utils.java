import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static ChromeDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dolko\\AppData\\Roaming\\npm\\node_modules\\protractor\\node_modules\\webdriver-manager\\selenium\\chromedriver_2.32.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        try {
//            chromeDriver.get("https://et.coresystems.net/workforce-management/#/skills");
//        }
//        catch (TimeoutException e){
//            chromeDriver.quit();
//            new Assertion().fail("page load timeout!");
//        }
        return chromeDriver;
    }

    public static void waitForAjaxLoad(WebDriver driver) throws InterruptedException{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        if((Boolean) executor.executeScript("return window.jQuery != undefined")){
            while(!(Boolean) executor.executeScript("return jQuery.active == 0")){
                Thread.sleep(1000);
            }
        }
        return;
    }
}