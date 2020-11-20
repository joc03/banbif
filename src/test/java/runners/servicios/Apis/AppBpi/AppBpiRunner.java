package runners.servicios.Apis.AppBpi;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/Apis/AppBpi/AppBpi.feature",
        glue = "stepdefinitions")

public class AppBpiRunner {
}
