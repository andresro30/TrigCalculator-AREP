package edu.escuelaing.arep.model;

import org.json.JSONObject;


/**
 * Hello world!
 *
 */
public class TrigCalculator {

    public static void main(String[] args) {
        getData("1","sin");
    }

    public static JSONObject getData(String number, String operator) {
        Calculator calculator = new Calculator();
        JSONObject obj = new JSONObject();

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
}
