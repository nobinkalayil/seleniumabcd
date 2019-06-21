import cucumber.api.Scenario;
import driver.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Hooks {
    DriverManager driverManager= new DriverManager();
    //@Before
@Before
    public void setUp(){
        driverManager.openBrowser();

        driverManager.navigate("http://www.popuptest.com/goodpopups.html");
        driverManager.maximise();
        driverManager.implicitWait();
    }
    @After
    public void tearDown(Scenario scenario){



        if(scenario.isFailed()){
            driverManager.takeSceenShot(scenario);
        }

    }

}
