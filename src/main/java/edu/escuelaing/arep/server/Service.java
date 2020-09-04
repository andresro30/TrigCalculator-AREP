package edu.escuelaing.arep.server;

import edu.escuelaing.arep.model.TrigCalculator;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.port;

public class Service {

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        port(getPort());
        get("/", (req, res) -> page(req,res));
        get("/submit", (req, res) -> result(req, res));
    }

    private static String page(Request req, Response res) {
        String page = "<DOCTYPE html"
                + "<html>"
                + "<title> Calculadora Trigonométrica</title>"
                + "<body>"
                + "<h1>Calculadora Trigonométrica</h1>"
                + "<form action=\"/submit\">"
                + "<p>Esta es una calculadora tiene las funciones de seno,coseno y tangente</p>"
                + "<p>Si vas a usar la función seno, pon la opción sin</p>"
                + "<p>Si vas a usar la función coseno, pon la opción cos</p>"
                + "<p>Si vas a usar la función tangente, pon la opción tan</p>"
                + "<br></br>"
                + "<label for=\"fdata\">Número:</label>"
                + "<input type=\"text\" id=\"fdata\" name=\"fdata\"><br><br>"
                + "<label for=\"fdata\">Función:</label>"
                + "<input type=\"text\" id=\"fop\" name=\"foperacion\"><br><br>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return page;
    }

    private static JSONObject result(Request req, Response res) {
        String number = req.queryParams("fdata");
        String operator = req.queryParams("foperacion");
        JSONObject obj = new TrigCalculator().getData(number,operator);
        return obj;
    }



    /**
     * Método enccargado de definir el puerto por donde corre el programa
     *
     * @return variable de tipo int
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 45555;
    }

}
