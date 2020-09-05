package edu.escuelaing.arep.model;

import org.json.JSONObject;

import static spark.Spark.port;
import static spark.Spark.get;



/**
 * Hello world!
 *
 */
public class TrigCalculator {


    public static void main(String[] args) {
        port(getPort());
        get("/calculateTrigonometric",(req,res)->{
            String operation = req.queryParams("operation");
            String number = req.queryParams("number");
            JSONObject jsonObject = new JSONObject();
            JSONObject respuesta = getData(number,operation);
            return respuesta;
        });
    }

    public static JSONObject getData(String number, String operator) {
        Calculator calculator = new Calculator();
        JSONObject obj = new JSONObject();
        System.out.println(operator+" "+number);
        if(operator.equals("sin"))
            obj.put("sin",calculator.sin(Double.parseDouble(number)));
        else if(operator.equals("cos"))
            obj.put("cos",calculator.cos(Double.parseDouble(number)));
        else if(operator.equals("tan"))
            obj.put("tan",calculator.tan(Double.parseDouble(number)));
        else
            obj.put("operator","Operación Invalida");

        return obj;
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 45555;
    }
}
