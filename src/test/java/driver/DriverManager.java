package driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private TakesScreenshot screenshotTaker;
    public static WebDriver driver;
    private String browser;
    public void openBrowser(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       // WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

    }
    public void navigate(String url){
        driver.get(url);
    }
    public void maximise(){driver.manage().window().maximize();}
    public void implicitWait(){driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);}
    public void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement waitUntilElementClickable(WebElement element) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void takeSceenShot(Scenario scenario) {
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
    }
}
