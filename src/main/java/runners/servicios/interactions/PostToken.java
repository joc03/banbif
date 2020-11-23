package runners.servicios.interactions;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import runners.servicios.utility.ExcelReader;
import runners.servicios.utility.Spliters;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostToken {




    private static final String EXCEL_FILE = "excel/Servicios.xlsx";
    private static final String EXCEL_SHEET = "Token";
    private static final String COULMNA_BASE_URL = "BASE_URL";
    private static final String COLUMNA_RESOURCES = "RESOURCES";
    private static final String COLUMNA_BODY = "BODY";
    private static final String COLUMNA_HEADER = "HEADER";



    private static final String EXCEL_SHEET2 = "Services";
    private static final String COLUMNA_NUM_TOKEN = "TOKEN";


    private static List<HashMap<String, String>> getDataFromExcel() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }

    private static List<HashMap<String, String>> getDataFromExcel2() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET2);
    }

    /*ADICIONAL*/
    private static List<HashMap<String, String>> getDataFromExcelSheet(String sheet) throws Throwable {
        return ExcelReader.data(EXCEL_FILE, sheet);
    }



    public static String postToken(String baseUrl,String body, String header,String resources){
        String token;
        RestAssured.baseURI =baseUrl;

        RequestSpecification request = given();

        String separador []=body.split(";",0);

        for (String a : separador){
            String separador2 []=a.split(":",0);

            if(separador2[0].trim().equals("content-type")){

                if(separador2[1].trim().equals("application/json")){request.contentType(ContentType.JSON);}
                if(separador2[1].trim().equals("application/x-www-form-urlencoded")){request.contentType(ContentType.URLENC);}

            }else {
                request.formParam(separador2[0].trim(), separador2[1].trim());

            }




        }



        String separadorHeader []=header.split(";",0);

        for (String a : separadorHeader){
            String separadorHeader2 []=a.split(":",0);


            request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());




        }

        Response response = request.post(resources);


        /*System.out.println(response.body().asString());*/
//GUARDANDO E IMPRIMIENDO VARIABLES
        String tokenaux = response.then().extract().path("access_token");
        String token_type = response.then().extract().path("token_type");
        token= tokenaux;

//
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//       // Assert.assertEquals(statusCodeString, "200");
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//
//
////        String successCode = response.jsonPath().get("SuccessCode");
////        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");

        return token;


    }



    public static String postTokenWithExcel(String casoDePrueba) throws Throwable {
        String token;

        int casoPruebaAux = Integer.parseInt(casoDePrueba) - 1;
        String numToken = getDataFromExcel2().get(casoPruebaAux).get(COLUMNA_NUM_TOKEN);

        int casoPrueba = Integer.parseInt(numToken) - 1;
        String baseUrl = getDataFromExcel().get(casoPrueba).get(COULMNA_BASE_URL);
        String body = getDataFromExcel().get(casoPrueba).get(COLUMNA_BODY);
        String header = getDataFromExcel().get(casoPrueba).get(COLUMNA_HEADER);
        String resources = getDataFromExcel().get(casoPrueba).get(COLUMNA_RESOURCES);


        RestAssured.baseURI =baseUrl;

        RequestSpecification request = given();

        String separador []=body.split(";",0);

        for (String a : separador){
            String separador2 []=a.split(":",0);

            if(separador2[0].trim().equals("content-type")){

                if(separador2[1].trim().equals("application/json")){request.contentType(ContentType.JSON);}
                if(separador2[1].trim().equals("application/x-www-form-urlencoded")){request.contentType(ContentType.URLENC);}

            }else {
                request.formParam(separador2[0].trim(), separador2[1].trim());

            }




        }



        String separadorHeader []=header.split(";",0);

        for (String a : separadorHeader){
            String separadorHeader2 []=a.split(":",0);


            request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());




        }

        Response response = request.post(resources);


        /*System.out.println(response.body().asString());*/
//GUARDANDO E IMPRIMIENDO VARIABLES
        String tokenaux = response.then().extract().path("access_token");
        String token_type = response.then().extract().path("token_type");
        token= tokenaux;


//
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        //Assert.assertEquals(statusCodeString, "200");
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//
//
////        String successCode = response.jsonPath().get("SuccessCode");
////        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");

        return token;


    }


    /*ADICIONAL*/

    public static String postTokenWithExcelSheet(String casoDePrueba, String sheet) throws Throwable {
        String token="";

        int casoPruebaAux = Integer.parseInt(casoDePrueba) - 1;
        String numToken = getDataFromExcelSheet(sheet).get(casoPruebaAux).get(COLUMNA_NUM_TOKEN);

        if(numToken.length()!=0) {


            int casoPrueba = Integer.parseInt(numToken) - 1;
            String baseUrl = getDataFromExcel().get(casoPrueba).get(COULMNA_BASE_URL);
            String body = getDataFromExcel().get(casoPrueba).get(COLUMNA_BODY);
            String header = getDataFromExcel().get(casoPrueba).get(COLUMNA_HEADER);
            String resources = getDataFromExcel().get(casoPrueba).get(COLUMNA_RESOURCES);


            RestAssured.baseURI = baseUrl;

            RequestSpecification request = given();

            request.relaxedHTTPSValidation();//Ignorar la verificacion del SSL

            String separador[] = body.split(";", 0);

            for (String a : separador) {
                String separador2[] = a.split(":", 0);

                if (separador2[0].trim().equals("content-type")) {

                    if (separador2[1].trim().equals("application/json")) {
                        request.contentType(ContentType.JSON);
                    }
                    if (separador2[1].trim().equals("application/x-www-form-urlencoded")) {
                        request.contentType(ContentType.URLENC);
                    }

                } else {
                    request.formParam(separador2[0].trim(), separador2[1].trim());

                }


            }


            String separadorHeader[] = header.split(";", 0);

            for (String a : separadorHeader) {
                String separadorHeader2[] = a.split(":", 0);


                request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());


            }

            Response response = request.post(resources);


            /*System.out.println(response.body().asString());*/
//GUARDANDO E IMPRIMIENDO VARIABLES
            String tokenaux = response.then().extract().path("access_token");
            String token_type = response.then().extract().path("token_type");
            token = tokenaux;


//
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        //Assert.assertEquals(statusCodeString, "200");
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//
//
////        String successCode = response.jsonPath().get("SuccessCode");
////        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
        }

        if (sheet.equals("AppEmpresas")) {
            token= Spliters.separar_palabrasToken(token);
        }
        return token;


    }

    public static String postTokenWithExcelSheetSslVerificaction(String casoDePrueba, String sheet) throws Throwable {
        String token="";

        int casoPruebaAux = Integer.parseInt(casoDePrueba) - 1;
        String numToken = getDataFromExcelSheet(sheet).get(casoPruebaAux).get(COLUMNA_NUM_TOKEN);

        if(numToken.length()!=0) {


            int casoPrueba = Integer.parseInt(numToken) - 1;
            String baseUrl = getDataFromExcel().get(casoPrueba).get(COULMNA_BASE_URL);
            String body = getDataFromExcel().get(casoPrueba).get(COLUMNA_BODY);
            String header = getDataFromExcel().get(casoPrueba).get(COLUMNA_HEADER);
            String resources = getDataFromExcel().get(casoPrueba).get(COLUMNA_RESOURCES);


            RestAssured.baseURI = baseUrl;

            RequestSpecification request = given();
            request.relaxedHTTPSValidation();


            String separador[] = body.split(";", 0);

            for (String a : separador) {
                String separador2[] = a.split(":", 0);

                if (separador2[0].trim().equals("content-type")) {

                    if (separador2[1].trim().equals("application/json")) {
                        request.contentType(ContentType.JSON);
                    }
                    if (separador2[1].trim().equals("application/x-www-form-urlencoded")) {
                        request.contentType(ContentType.URLENC);
                    }

                } else {
                    request.formParam(separador2[0].trim(), separador2[1].trim());

                }


            }


            String separadorHeader[] = header.split(";", 0);

            for (String a : separadorHeader) {
                String separadorHeader2[] = a.split(":", 0);


                request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());


            }

            Response response = request.post(resources);


            /*System.out.println(response.body().asString());*/
//GUARDANDO E IMPRIMIENDO VARIABLES
            String tokenaux = response.then().extract().path("access_token");
            String token_type = response.then().extract().path("token_type");
            token = tokenaux;


//
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        //Assert.assertEquals(statusCodeString, "200");
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//
//
////        String successCode = response.jsonPath().get("SuccessCode");
////        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
        }

        if (sheet.equals("AppEmpresas")) {
            token= Spliters.separar_palabrasToken(token);
        }
        return token;


    }


}
