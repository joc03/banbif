package runners.servicios.interactions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import runners.servicios.utility.ExcelReader;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Del {


    private static final String EXCEL_FILE = "excel/Servicios.xlsx";
    private static final String EXCEL_SHEET = "Services";
    private static final String COULMNA_BASE_URL = "BASE_URL";
    private static final String COLUMNA_RESOURCES = "RESOURCES";
    private static final String COLUMNA_BODY = "BODY";
    private static final String COLUMNA_HEADER = "HEADER";
    private static final String COLUMNA_MESSAGE = "MESSAGE";
    private static final String COLUMNA_QUERY = "QUERY";
    private static final String COLUMNA_TOKEN = "TOKEN";

    private static List<HashMap<String, String>> getDataFromExcel() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }

    private static List<HashMap<String, String>> getDataFromExcelSheet(String sheet) throws Throwable {
        return ExcelReader.data(EXCEL_FILE, sheet);
    }


    public static void del(String token,String baseUrl,String body, String header,String resources){
        RestAssured.baseURI =baseUrl;

        RequestSpecification request = given();

        request.body(body);


        if(header.length()!=0) {

            String separadorHeader[] = header.split(";", 0);

            for (String a : separadorHeader) {
                String separadorHeader2[] = a.split(":", 0);


                request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());


            }
        }
        // String tokenaux=postToken()
        request.header("Authorization",token);

        Response response = request.post(resources);

//
//
//        System.out.println(response.body().asString());
//
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String message = response.then().extract().path("mensaje");
//
//        String statusCodeString = Integer.toString(statusCode);
//       // Assert.assertEquals(statusCodeString, "200");
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//        ResponseMessageValidation.ValidationCode("",message);
//



    }


    public static Response delWithExcel(String token, String casoDePrueba) throws Throwable {

        int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
        String baseUrl = getDataFromExcel().get(casoPrueba).get(COULMNA_BASE_URL);
        String body = getDataFromExcel().get(casoPrueba).get(COLUMNA_BODY);
        String header = getDataFromExcel().get(casoPrueba).get(COLUMNA_HEADER);
        String resources = getDataFromExcel().get(casoPrueba).get(COLUMNA_RESOURCES);
        String query = getDataFromExcel().get(casoPrueba).get(COLUMNA_QUERY);
        String messageExpected = getDataFromExcel().get(casoPrueba).get(COLUMNA_MESSAGE);


        RestAssured.baseURI =baseUrl;

        RequestSpecification request = given();

        request.body(body);

        if(query.length()!=0) {
            String separadorParam[] = query.split("&", 0);

            for (String a : separadorParam) {
                String separadorParam2[] = a.split("=", 0);


                request.queryParams(separadorParam2[0].trim(), separadorParam2[1].trim());

            }
        }

        if(header.length()!=0) {

            String separadorHeader[] = header.split(";", 0);

            for (String a : separadorHeader) {
                String separadorHeader2[] = a.split(":", 0);


                request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());
            }
        }

        // String tokenaux=postToken()
        request.header("Authorization",token);

        Response response = request.post(resources);

//
//        System.out.println(response.body().asString());
//
//        //  VALIDACIONES
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        String message = response.then().extract().path("mensaje");
//
//
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//        ResponseMessageValidation.ValidationCode(messageExpected,message);
//
        return response;


    }






    /*ADICIONAL*/



    public static Response delWithExcelSheet(String token, String casoDePrueba,String sheet) throws Throwable {

        int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
        String baseUrl = getDataFromExcelSheet(sheet).get(casoPrueba).get(COULMNA_BASE_URL);
        String body = getDataFromExcelSheet(sheet).get(casoPrueba).get(COLUMNA_BODY);
        String header = getDataFromExcelSheet(sheet).get(casoPrueba).get(COLUMNA_HEADER);
        String resources = getDataFromExcelSheet(sheet).get(casoPrueba).get(COLUMNA_RESOURCES);
        String query = getDataFromExcelSheet(sheet).get(casoPrueba).get(COLUMNA_QUERY);
        String numToken = getDataFromExcelSheet(sheet).get(casoPrueba).get(COLUMNA_TOKEN);
        String messageExpected = getDataFromExcelSheet(sheet).get(casoPrueba).get(COLUMNA_MESSAGE);


        RestAssured.baseURI =baseUrl;

        RequestSpecification request = given();

        request.body(body);

        if(query.length()!=0) {
            String separadorParam[] = query.split("&", 0);

            for (String a : separadorParam) {
                String separadorParam2[] = a.split("=", 0);


                request.queryParams(separadorParam2[0].trim(), separadorParam2[1].trim());

            }
        }

        if(header.length()!=0) {

            String separadorHeader[] = header.split(";", 0);

            for (String a : separadorHeader) {
                String separadorHeader2[] = a.split(":", 0);


                request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());
            }
        }

        // String tokenaux=postToken()
        if(numToken.length()!=0) {
            request.header("Authorization", token);
        }
        Response response = request.delete(resources);

//
//        System.out.println(response.body().asString());
//
//        //  VALIDACIONES
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        String message = response.then().extract().path("mensaje");
//
//
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//        ResponseMessageValidation.ValidationCode(messageExpected,message);
//
        return response;


    }
    public static Response delTotal(String token, String casoDePrueba,String sheet) throws Throwable {
        Response response=null;



        int dato;

        List ListaCuentas;
        ListaCuentas = ExcelReader.data(EXCEL_FILE, sheet);
        dato = ListaCuentas.size();

        boolean estadoModalWork3;

        for (int i = 0; i < dato; i++) {


            int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
            String baseUrl = getDataFromExcelSheet(sheet).get(i).get(COULMNA_BASE_URL);
            String body = getDataFromExcelSheet(sheet).get(i).get(COLUMNA_BODY);
            String header = getDataFromExcelSheet(sheet).get(i).get(COLUMNA_HEADER);
            String resources = getDataFromExcelSheet(sheet).get(i).get(COLUMNA_RESOURCES);
            String query = getDataFromExcelSheet(sheet).get(i).get(COLUMNA_QUERY);
            String messageExpected = getDataFromExcelSheet(sheet).get(i).get(COLUMNA_MESSAGE);


            RestAssured.baseURI = baseUrl;

            RequestSpecification request = given();

            request.body(body);

            if (query.length() != 0) {
                String separadorParam[] = query.split("&", 0);

                for (String a : separadorParam) {
                    String separadorParam2[] = a.split("=", 0);


                    request.queryParams(separadorParam2[0].trim(), separadorParam2[1].trim());

                }
            }

            if (header.length() != 0) {

                String separadorHeader[] = header.split(";", 0);

                for (String a : separadorHeader) {
                    String separadorHeader2[] = a.split(":", 0);


                    request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());
                }
            }

            // String tokenaux=postToken()
            request.header("Authorization", token);

            response = request.delete(resources);

//
//        System.out.println(response.body().asString());
//
//        //  VALIDACIONES
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        String message = response.then().extract().path("mensaje");
//
//
//        ResponseStatusCodeValidation.ValidationCode("200",statusCodeString);
//        ResponseMessageValidation.ValidationCode(messageExpected,message);

        }
        return response;

    }

}
