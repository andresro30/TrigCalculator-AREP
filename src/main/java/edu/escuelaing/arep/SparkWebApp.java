package edu.escuelaing.arep;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class SparkWebApp
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        port(getPort());
        //get("/submit", (req, res) -> getData(req, res));
        get("/", (req, res) -> "Hello Word!");
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
