package runners.servicios.tasks;

import io.restassured.response.Response;
import runners.servicios.interactions.Del;
import runners.servicios.interactions.Get;
import runners.servicios.interactions.Post;
import runners.servicios.interactions.Put;
import runners.servicios.utility.ExcelReader;

import java.util.HashMap;
import java.util.List;

public class Consume {

    private static final String EXCEL_FILE = "excel/Servicios.xlsx";
    private static final String EXCEL_SHEET = "Services";
    private static final String COULMNA_PETICION = "PETICION";

    private static List<HashMap<String, String>> getDataFromExcel(String sheet) throws Throwable {
        return ExcelReader.data(EXCEL_FILE, sheet);
    }


    public static Response Petitions(String token, String casoPrueba,String sheet) throws Throwable {

//        private static final Logger LOGGER = LoggerFactory.getLogger(MetodosComunesCsv.class);
//
//
//        LOGGER.info("Se consume el Servicio: " + api);
//        LOGGER.info("Descripcion de la API: " + MetodosComunesCsv.getDescripcion());

        int casoDePrueba = Integer.parseInt(casoPrueba) - 1;
        String peticion = getDataFromExcel(sheet).get(casoDePrueba).get(COULMNA_PETICION);
        Response response=null;

        switch (peticion.toUpperCase()) {
            case "POST":
                response=Post.postWithExcelSheet("Bearer " +token,casoPrueba,sheet);
                break;
            case "DELETE":
                response= Del.delWithExcelSheet("Bearer " +token,casoPrueba,sheet);
                break;
            case "GET":
                response= Get.getWithExcelSheet("Bearer " +token,casoPrueba,sheet);
                break;
            case "PUT":
                response= Put.putWithExcelSheet("Bearer " +token,casoPrueba,sheet);
                break;
            case "GETWITHHEADER":
                System.out.println("GETWITHHEADER");
                break;
            default:
                System.out.println("PETICION NO VALIDA");

        }

        return response;


    }



}
