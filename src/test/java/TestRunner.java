import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber_json/cucumber.json"},
        features = "src/test/resources/GamesFeatures",
        glue = "StepDefinitions",
        /* MODIFICAR LOS DECORADORES SEGÚN SEA EL CASO*/
        tags = "@Escenario2"
)
public class TestRunner {
}
