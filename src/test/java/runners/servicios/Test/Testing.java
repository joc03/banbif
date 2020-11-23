//package runners.servicios.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.junit.Assert;
//import org.junit.Test;
//import runners.servicios.interactions.Get;
//import runners.servicios.interactions.Post;
//import runners.servicios.interactions.PostToken;
//import runners.servicios.utility.ExcelReader;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//
//public class Testing {
//
//
//    private static final String EXCEL_FILE = "excel/Servicios.xlsx";
//    private static final String EXCEL_SHEET = "Services";
//    private static final String COULMNA_BASE_URL = "BASE_URL";
//    private static final String COLUMNA_RESOURCES = "RESOURCES";
//    private static final String COLUMNA_BODY = "BODY";
//    private static final String COLUMNA_HEADER = "HEADER";
//    private static final String COLUMNA_MESSAGE = "MESSAGE";
//    private static final String COLUMNA_QUERY = "QUERY";
//    private static final String COLUMNA_TOKEN = "TOKEN";
//
//
//
//    private static List<HashMap<String, String>> getDataFromExcelSheet(String sheet) throws Throwable {
//        return ExcelReader.data(EXCEL_FILE, sheet);
//    }
//
//    public void test1(String baseUrl,String body, String header,String resources){
//        String token;
//        RestAssured.baseURI =baseUrl;
//
//        RequestSpecification request = given();
//
//        String separador []=body.split(";",0);
//
//        for (String a : separador){
//            String separador2 []=a.split(":",0);
//
//            if(separador2[0].trim().equals("content-type")){
//
//                if(separador2[1].trim().equals("application/json")){request.contentType(ContentType.JSON);}
//                if(separador2[1].trim().equals("application/x-www-form-urlencoded")){request.contentType(ContentType.URLENC);}
//
//            }else {
//                request.formParam(separador2[0].trim(), separador2[1].trim());
//
//            }
//
//
//        }
//
//
//
//        String separadorHeader []=header.split(";",0);
//
//        for (String a : separadorHeader){
//            String separadorHeader2 []=a.split(":",0);
//
//
//                request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());
//
//
//
//
//        }
//
//        Response response = request.post(resources);
//
//
//        System.out.println(response);
//        /*System.out.println(response.body().asString());*/
////GUARDANDO E IMPRIMIENDO VARIABLES
//        String tokenaux = response.then().extract().path("access_token");
//        String token_type = response.then().extract().path("token_type");
//        token="Bearer " + tokenaux;
//        System.out.println("TOKEN -> "+token);
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        Assert.assertEquals(statusCodeString, "200");
//
////        String successCode = response.jsonPath().get("SuccessCode");
////        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
//
//
//    }
//
//
//
//
//    public String postToken(String baseUrl,String body, String header,String resources){
//        String token;
//        RestAssured.baseURI =baseUrl;
//
//        RequestSpecification request = given();
//
//        String separador []=body.split(";",0);
//
//        for (String a : separador){
//            String separador2 []=a.split(":",0);
//
//            if(separador2[0].trim().equals("content-type")){
//
//                if(separador2[1].trim().equals("application/json")){request.contentType(ContentType.JSON);}
//                if(separador2[1].trim().equals("application/x-www-form-urlencoded")){request.contentType(ContentType.URLENC);}
//
//            }else {
//                request.formParam(separador2[0].trim(), separador2[1].trim());
//
//            }
//
//
//
//
//        }
//
//
//
//        String separadorHeader []=header.split(";",0);
//
//        for (String a : separadorHeader){
//            String separadorHeader2 []=a.split(":",0);
//
//
//            request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());
//
//
//
//
//        }
//
//        Response response = request.post(resources);
//
//
//        /*System.out.println(response.body().asString());*/
////GUARDANDO E IMPRIMIENDO VARIABLES
//        String tokenaux = response.then().extract().path("access_token");
//        String token_type = response.then().extract().path("token_type");
//        token=tokenaux;
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        Assert.assertEquals(statusCodeString, "200");
//
////        String successCode = response.jsonPath().get("SuccessCode");
////        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
//
//        return token;
//
//
//    }
//
//
//
//
//    public void post(String token,String baseUrl,String body, String header,String resources){
//        RestAssured.baseURI =baseUrl;
//
//        RequestSpecification request = given();
//
//        request.body(body);
//
//
//
//
//        String separadorHeader []=header.split(";",0);
//
//        for (String a : separadorHeader){
//            String separadorHeader2 []=a.split(":",0);
//
//
//            request.header(separadorHeader2[0].trim(), separadorHeader2[1].trim());
//
//
//
//
//        }
//       // String tokenaux=postToken()
//        request.header("Authorization",token);
//
//        Response response = request.post(resources);
//
//
//        ArrayList example = response.then().extract().path("meta.mensajes.mensaje");
//        Boolean example2 = response.then().extract().path("meta.resultado");
//        String example3 = response.then().extract().path("meta.idTransaccion");
//
//
//        System.out.println(response.body().asString());
//        System.out.println("===========================================================================");
//        System.out.println(example);
//        System.out.println("===========================================================================");
//        System.out.println("===========================================================================");
//        System.out.println(example2);
//        System.out.println("===========================================================================");
//        System.out.println("===========================================================================");
//        System.out.println(example3);
//        System.out.println("===========================================================================");
//
////  VALIDACION DE CODIGO DE STATUS
//        int statusCode = response.getStatusCode();
//        String statusCodeString = Integer.toString(statusCode);
//        Assert.assertEquals(statusCodeString, "200");
//
//    }
//
//    public void Separar_palabras(String text){
//
//        if(text.length()!=0){
//
//
//
//            String separador []=text.split("&",0);
//
//            for (String a : separador){
//                String separador2 []=a.split("=",0);
//
//
//                System.out.println(separador2[0].trim()+" este es lo que vale -> "+separador2[1].trim());
//
//
//
//            }
//
//
//        }else{
//            System.out.println("asdasdasdas");
//        }
//
//
//
//    }
//    public void Separar_palabrasToken(String text){
//
//        if(text.length()!=0){
//
//
//
//            String separador []=text.split("token=",0);
//
//
//
//            System.out.println(" el token vale -> "+separador[1].trim());
//
//
//
//
//
//
//        }
//
//
//
//    }
//    public void get(String token){
//        RestAssured.baseURI = "https://api-recaudaciones.uatapps.banbifapimarket.com.pe";
//        Response response = given()
//               // .contentType(ContentType.JSON)
//               // .pathParam("codigo","13")
//
//                .header("codigoCanal","BI")
//                .header("Authorization",token)
//                .param("codigoRecaudador", "BANBIF")
//                .when()
//                .get("/api-recaudaciones/v1/convenios/13")
//                .then()
//                .extract().response();
//
//        response.prettyPrint();
//
//    }
//
//    public void gettest(String token){
//
//        RestAssured.baseURI = "https://api-recaudaciones.uatapps.banbifapimarket.com.pe";
//        RequestSpecification request = given();
//
//        request.header("codigoCanal","BI");
//        request.header("Authorization",token);
//        request.param("codigoRecaudador", "BANBIF");
//        request.when();
//        Response response =  request.get("/api-recaudaciones/v1/convenios/13");
////        request.then();
//       // request.response();
//
////        Response response = given()
////               // .contentType(ContentType.JSON)
////               // .pathParam("codigo","13")
////
////                .header("codigoCanal","BI")
////                .header("Authorization",token)
////                .param("codigoRecaudador", "BANBIF")
////                .when()
////                .get("/api-recaudaciones/v1/convenios/13")
////                .then()
////                .extract().response();
//
//        response.prettyPrint();
//
//    }
//
//
//    @Test
//    public void testSeparadorPalbras() throws Throwable {
////
////      // Separar_palabras("grant_type:client_credentials;client_id:1f19985e;client_secret:989ad298d6c77800086f9cb9ddfaa9f2;content-type:application/x-www-form-urlencoded");
////      // Separar_palabras("user-key:71ac970647c7b36d5a9cc91a56387fa5");
////       // test1( "https://ssorh.uatapps.banbifapimarket.com.pe/auth/realms/Banbif-API-External/protocol/openid-connect", "grant_type:client_credentials;client_id:1f19985e;client_secret:989ad298d6c77800086f9cb9ddfaa9f2;content-type:application/x-www-form-urlencoded",  "user-key:71ac970647c7b36d5a9cc91a56387fa5", "/token");
////       String token= postToken( "https://ssorh.uatapps.banbifapimarket.com.pe/auth/realms/Banbif-API-External/protocol/openid-connect", "grant_type:client_credentials;client_id:1f19985e;client_secret:989ad298d6c77800086f9cb9ddfaa9f2;content-type:application/x-www-form-urlencoded",  "user-key:71ac970647c7b36d5a9cc91a56387fa5", "/token");
////      System.out.println(token);
////      post("Bearer " +  token,"https://banbif-sunat-service.uatapps.banbifapimarket.com.pe:443/api-sunat/v1", "{\"empresa\":{\"codigo\":\"12345678901\",\"razonSocial\":\"RED DIGITAL\",\"servicio\":{\"id\":\"12345678\"}},\"cliente\":{\"documento\":{\"tipo\":\"REGISTRO_UNICO_DEL_CONTRIBUYENTE\",\"numero\":\"10023958398\"},\"tributo\":{\"mesPeriodoTributario\":\"10\",\"yearPeriodoTributario\":2019,\"montoIngresosMes\":10000,\"montoComprasMes\":5000,\"montoCompensacionPagosEfectuados\":0,\"montoCompensacionPercepciones\":0,\"importePagar\":2000,\"declaratoria\":\"SI\"}},\"recaudadora\":{\"codigoCanal\":\"RD\",\"cajero\":\"REDD01\",\"codigoTerminalCanal\":\"TER01\",\"codigoOperadorTerminalCanal\":\"RED01\",\"numeroOperacionCanal\":\"00000000\"},\"fecha\":\"2019-10-25 15:49:17\"}",  "Content-Type:application/json;codigoCanal:BANCA_POR_INTERNET;numeroPagina:1", "/consultas/tributos/");
////        System.out.println("===========================================================================");
////        System.out.println("===========================================================================");
////
////
////        String mensaje="hola que fue";
////        ArrayList<String> arraymensaje = new ArrayList<String>();
////        arraymensaje.add("BMW");
////
////        System.out.println(arraymensaje);
//String palabra="asdasdsada!!#$%&/()(/&%$%&token=sdfsd fstsresres #$/()(/&)=+554664";
//
//       // Separar_palabras("ADADA=");
//        Separar_palabrasToken(palabra);
//
//
//
//    }
//
//    @Test
//    public void testPost() throws Throwable {
//
//         String TOKEN="";
//         String API="";
//         Response response;
//         String casoDePrueba="8";
//
//        API="AppBpi";
//        TOKEN= PostToken.postTokenWithExcelSheetSslVerificaction(casoDePrueba,API);
//        System.out.println(TOKEN);
//
//        response= Post.postWithExcelSheet("Bearer "+TOKEN,casoDePrueba,API);
//
//
//        String respuestaaux = response.asString();
//        if(!respuestaaux.equals("Authentication failed")){
//            response.prettyPrint();
//
//
//        }else {
//            System.out.println(respuestaaux);
//        }
//
//        //gettest("Bearer " +TOKEN);
//    }
//
//
//    @Test
//    public void testToken() throws Throwable {
//
//        String TOKEN="";
//        String API="";
//        Response response;
//        String casoDePrueba="6";
//
//        API="AppBpi";
//        TOKEN= PostToken.postTokenWithExcelSheet(casoDePrueba,API);
//        System.out.println(TOKEN);
//
//
//        //gettest("Bearer " +TOKEN);
//    }
//
//    @Test
//    public void testExcelReadBlank() throws Throwable {
//
//        String casoDePrueba="52";
//        String sheet="RedDigital";
//    int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
//    String query = getDataFromExcelSheet(sheet).get(casoPrueba).get(COLUMNA_QUERY);
//
//    System.out.println(query+"=aea");
//
//
//
//    }
//
//}
