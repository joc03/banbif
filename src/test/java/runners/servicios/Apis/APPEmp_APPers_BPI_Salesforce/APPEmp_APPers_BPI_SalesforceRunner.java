package runners.servicios.Apis.APPEmp_APPers_BPI_Salesforce;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/Apis/APPEmp_APPers_BPI_Salesforce/APPEmp_APPers_BPI_Salesforce.feature",
        glue = "stepdefinitions")

public class APPEmp_APPers_BPI_SalesforceRunner {
}
