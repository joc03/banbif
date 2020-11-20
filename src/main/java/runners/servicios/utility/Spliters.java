package runners.servicios.utility;

public class Spliters {

    public static String separar_palabrasToken(String text) {

        String token="";
        if (text.length() != 0) {
            String separador[] = text.split("token=", 0);
            //System.out.println(" el token vale -> " + separador[1].trim());
            token=separador[1];
        }

        return token;

    }
}