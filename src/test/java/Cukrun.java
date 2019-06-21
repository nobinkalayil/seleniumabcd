import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/basket",


        dryRun = false,
        strict = true, plugin = "json:target/cucumber.json"
)
public class Cukrun {
}
