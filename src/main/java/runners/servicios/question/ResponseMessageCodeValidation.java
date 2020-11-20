package runners.servicios.question;

import io.restassured.response.Response;
import org.junit.Assert;
import runners.servicios.utility.ExcelReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResponseMessageCodeValidation {

    private static final String EXCEL_FILE = "excel/Servicios.xlsx";
    private static final String EXCEL_SHEET = "Services";
    private static final String COULMNA_MENSAJE = "MENSAJE";

    private static List<HashMap<String, String>> getDataFromExcel() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }

    private static List<HashMap<String, String>> getDataFromExcelSheet(String sheet) throws Throwable {
        return ExcelReader.data(EXCEL_FILE, sheet);
    }

    public static void ValidationCode(Response response , String casoDePrueba) throws Throwable {


        int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
        String mensajeaux = getDataFromExcel().get(casoPrueba).get(COULMNA_MENSAJE);

        //VARIA DEPENDIENDO DEL PARAMETRO SI SON NUMEROS SERA INT PEOR SI SON LETRAS PROBARAS ENTRE ARRAY Y STRING
        ArrayList messageActual = response.then().extract().path("meta.mensajes.codigo");

//        Boolean example2 = response.then().extract().path("meta.resultado");
//        String example3 = response.then().extract().path("meta.idTransaccion");

        ArrayList<String> menssageExpected = new ArrayList<String>();
        menssageExpected.add(mensajeaux);




        Assert.assertEquals(menssageExpected, messageActual);

    }

    public static void ValidationCodeSheet(Response response , String casoDePrueba,String sheet) throws Throwable {


        int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
        String mensajeaux = getDataFromExcelSheet(sheet).get(casoPrueba).get(COULMNA_MENSAJE);
        String respuestaaux = response.asString();
        if (!respuestaaux.equals("Authentication parameters missing")) {

            //VARIA DEPENDIENDO DEL PARAMETRO SI SON NUMEROS SERA INT PEOR SI SON LETRAS PROBARAS ENTRE ARRAY Y STRING
            ArrayList messageActual = response.then().extract().path("meta.mensajes.codigo");

//        Boolean example2 = response.then().extract().path("meta.resultado");
//        String example3 = response.then().extract().path("meta.idTransaccion");

            ArrayList<String> menssageExpected = new ArrayList<String>();
            menssageExpected.add(mensajeaux);


            Assert.assertEquals(menssageExpected, messageActual);

        }
    }

}
