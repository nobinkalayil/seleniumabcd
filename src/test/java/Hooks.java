import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;
import org.junit.Test;

public class Hooks {
    DriverManager driverManager= new DriverManager();
    //@Before
@Before
    public void setUp(){
        driverManager.openBrowser();

        driverManager.navigate("https://www.coop.co.uk/");
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
