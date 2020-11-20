package runners.servicios.Apis.Agentes;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/Apis/Agentes/Agentes.feature",
        glue = "stepdefinitions")

public class AgentesRunner {
}
