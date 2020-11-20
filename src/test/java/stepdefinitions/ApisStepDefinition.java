package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import runners.servicios.interactions.PostToken;
import runners.servicios.question.ResponseMessageCodeValidation;
import runners.servicios.question.ResponseStatusCodeValidation;
import runners.servicios.tasks.Consume;

public class ApisStepDefinition {

    public String TOKEN="";
    public String API="";
    public Response response;
    public String respuestaaux ="";

    @Given("quiero ejecutar el API  con la peticion {string}")
    public void quieroEjecutarElAPIConLaPeticion(String casoPrueba) throws Throwable {

//        //PostTest.caso1Sunat();
//        //String token= PostToken.postToken( "https://ssorh.uatapps.banbifapimarket.com.pe/auth/realms/Banbif-API-External/protocol/openid-connect", "grant_type:client_credentials;client_id:1f19985e;client_secret:989ad298d6c77800086f9cb9ddfaa9f2;content-type:application/x-www-form-urlencoded",  "user-key:71ac970647c7b36d5a9cc91a56387fa5", "/token");
//
//        String token= PostToken.postTokenWithExcel(casoPrueba);
//
//        System.out.println(token);
//
//
//
//
//        /****/
//        // Post.post("Bearer " +  token,"https://banbif-sunat-service.uatapps.banbifapimarket.com.pe:443", "{\"empresa\":{\"codigo\":\"12345678901\",\"razonSocial\":\"RED DIGITAL\",\"servicio\":{\"id\":\"12345678\"}},\"cliente\":{\"documento\":{\"tipo\":\"REGISTRO_UNICO_DEL_CONTRIBUYENTE\",\"numero\":\"10023958398\"},\"tributo\":{\"mesPeriodoTributario\":\"10\",\"yearPeriodoTributario\":2019,\"montoIngresosMes\":10000,\"montoComprasMes\":5000,\"montoCompensacionPagosEfectuados\":0,\"montoCompensacionPercepciones\":0,\"importePagar\":2000,\"declaratoria\":\"SI\"}},\"recaudadora\":{\"codigoCanal\":\"RD\",\"cajero\":\"REDD01\",\"codigoTerminalCanal\":\"TER01\",\"codigoOperadorTerminalCanal\":\"RED01\",\"numeroOperacionCanal\":\"00000000\"},\"fecha\":\"2019-10-25 15:49:17\"}",  "Content-Type:application/json;codigoCanal:BANCA_POR_INTERNET;numeroPagina:1", "/api-sunat/v1/consultas/tributos/");
//        Post.postWithExcel("Bearer " +token,casoPrueba);



    }




    /*ADICIONALES*/

    @Given("quiero ejecutar el API Agentes  con la peticion {string}")
    public void quieroEjecutarElAPIAgentesConLaPeticion(String arg0) {

        API="Agentes";

    }

    @Given("quiero ejecutar el API Red Digital  con la peticion {string}")
    public void quieroEjecutarElAPIRedDigitalConLaPeticion(String arg0) {

        API="RedDigital";
    }

    @Given("quiero ejecutar el API Salesforce  con la peticion {string}")
    public void quieroEjecutarElAPISalesforceConLaPeticion(String arg0) {

        API="Salesforce";


    }


    @Given("quiero ejecutar el API AppBpi  con la peticion {string}")
    public void quieroEjecutarElAPIAppBpiConLaPeticion(String arg0) {

        API="AppBpi";
    }

    @Given("quiero ejecutar el API APPEmp_APPers_BPI_SALESFORCE  con la peticion {string}")
    public void quieroEjecutarElAPIAPPEmp_APPers_BPI_SALESFORCEConLaPeticion(String arg0) {
        API="APPEmp_APPers_BPI_SALESFORCE";
    }

    @When("gennero el token para ejecutarlo en el API {string}")
    public void genneroElTokenParaEjecutarloEnElAPI(String casoDePrueba) throws Throwable {

        TOKEN= PostToken.postTokenWithExcelSheet(casoDePrueba,API);
        System.out.println(TOKEN);


    }

    @And("consumo el api con la data de prueba {string}")
    public void consumoElApiConLaDataDePrueba(String casoDePrueba) throws Throwable {


        response= Consume.Petitions(TOKEN,casoDePrueba,API);
        respuestaaux = response.asString();
        response.prettyPrint();




    }


    @Then("verifico el status code {string}")
    public void verificoElStatusCode(String casoPrueba) throws Throwable {
        ResponseStatusCodeValidation.ValidationCodeSheet(response,casoPrueba,API);

    }

    @And("las respuestas esperadas en las rutas {string} del response")
    public void lasRespuestasEsperadasEnLasRutasDelResponse(String casoPrueba) throws Throwable {
        //if(!respuestaaux.equals("Authentication parameters missing")){

            ResponseMessageCodeValidation.ValidationCodeSheet(response , casoPrueba,API);

       // }
    }



}
