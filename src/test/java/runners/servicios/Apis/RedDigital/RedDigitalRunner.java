package runners.servicios.Apis.RedDigital;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/Apis/RedDigital/RedDigital.feature",
        glue = "stepdefinitions")

public class RedDigitalRunner {
}
