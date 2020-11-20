package runners.servicios.question;

import io.restassured.response.Response;
import org.junit.Assert;
import runners.servicios.utility.ExcelReader;

import java.util.HashMap;
import java.util.List;

public class ResponseStatusCodeValidation {

    private static final String EXCEL_FILE = "excel/Servicios.xlsx";
    private static final String EXCEL_SHEET = "Services";
    private static final String COULMNA_STATUS_CODE = "STATUS_CODE";

    private static List<HashMap<String, String>> getDataFromExcel() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }

    private static List<HashMap<String, String>> getDataFromExcelSheet(String sheet) throws Throwable {
        return ExcelReader.data(EXCEL_FILE, sheet);
    }


    public static void ValidationCode(Response response,String casoDePrueba) throws Throwable {


        int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
        String statusCodeExpected = getDataFromExcel().get(casoPrueba).get(COULMNA_STATUS_CODE);

        int statusCode=response.statusCode();

        String statusCodeActual = String.valueOf(statusCode);

        Assert.assertEquals(statusCodeExpected, statusCodeActual);

    }

    public static void ValidationCodeSheet(Response response,String casoDePrueba, String sheet) throws Throwable {


        int casoPrueba = Integer.parseInt(casoDePrueba) - 1;
        String statusCodeExpected = getDataFromExcelSheet(sheet).get(casoPrueba).get(COULMNA_STATUS_CODE);

        int statusCode=response.statusCode();

        String statusCodeActual = String.valueOf(statusCode);

        Assert.assertEquals(statusCodeExpected, statusCodeActual);

    }
}
