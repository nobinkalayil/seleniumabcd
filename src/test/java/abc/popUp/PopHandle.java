package abc.popUp;

import driver.DriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class PopHandle extends DriverManager {

    DriverManager driverManager = new DriverManager();
      @Before
    public void setUp(){
        driverManager.openBrowser();

       driverManager.navigate("http://www.popuptest.com/goodpopups.html");
         // driverManager.navigate("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
        driverManager.maximise();
        driverManager.implicitWait();
    }


    @Test
public void browserpopUp()  {


    driver.findElement(By.cssSelector(".blac")).click();


    Set<String> handlers = driver.getWindowHandles();
    Iterator<String> iterator = handlers.iterator();
    String parentWindowId = iterator.next();
    System.out.println("Parent window ID = "+ parentWindowId);
    String childWindowId = iterator.next();
        System.out.println("child window id = " + childWindowId);

        driver.switchTo().window(childWindowId);
        System.out.println("child window title is "+ driver.getTitle());
        sleep(2000);
        driver.close();

        driver.switchTo().window(parentWindowId);
        System.out.println("parent window title is "+ driver.getTitle());


}

//alert pop up
@Test
    public void alertPopUp(){
        driver.findElement(By.xpath("//input[@name='proceed']")).click();
       Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

    }
@Test
    public void alert(){
          driver.findElement(By.cssSelector("#identifierId")).sendKeys("naithankalayil@gmail.com");
          driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
          sleep(1000);
          driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("N4ass165ee");
   driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
   sleep(2000);
   driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
   sleep(2000);

driver.findElement(By.xpath("//img[@class='Hq aUG']")).click();
sleep(1000);
    driver.findElement(By.xpath("//div[@id=':jj']"))
            .sendKeys("/Users/nobinbabu/Desktop/dummy/Untitled.pages");
    }
    @Test
    public void alertTwo(){
          driver.findElement(By.name("Filedata")).sendKeys("/Users/nobinbabu/Desktop/dummy/Untitled.pages");
    }


    }

