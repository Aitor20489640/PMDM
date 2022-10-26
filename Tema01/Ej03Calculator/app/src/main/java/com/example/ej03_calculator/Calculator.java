package com.example.ej03_calculator;

public class Calculator {

    public static String calculate(String operation) {
        int indice;

        if (operation.contains("+")) {
            indice = operation.lastIndexOf("+");
            String oper1 = operation.substring(0, indice);
            String oper2 = operation.substring(indice + 1);

            return String.valueOf(Integer.parseInt(calculate(oper1)) + Integer.parseInt(calculate(oper2)));

        } else if (operation.contains("*")){
            indice = operation.indexOf("*");
            if (operation.contains("+")) {
                int indice2 = operation.indexOf("+");
                String oper1 = operation.substring(0, indice);
                String oper2 = operation.substring(indice + 1, indice2);
                String oper3 = operation.substring(indice2 +1);

                return String.valueOf((Integer.parseInt(calculate(oper1)) * Integer.parseInt(calculate(oper2))) + Integer.parseInt(calculate(oper3)));
            }
            String oper1 = operation.substring(0, indice);
            String oper2 = operation.substring(indice + 1);

            return String.valueOf(Integer.parseInt(calculate(oper1)) * Integer.parseInt(calculate(oper2)));

        } else if (operation.contains("-")) {
            indice = operation.lastIndexOf('-');
            String oper1 = operation.substring(0, indice);
            String oper2 = operation.substring(indice+1);
            if (oper1.length() > 2 && oper1.charAt(2) == '-'){
                    return String.valueOf(Integer.parseInt(calculate(oper1)) + Integer.parseInt(calculate(oper2)));
            } else
                if (Integer.parseInt(calculate(oper1)) < Integer.parseInt(calculate(oper2))){
                    return "-" + (Integer.parseInt(calculate(oper2)) - Integer.parseInt(calculate(oper1)));
                } else {
                    return String.valueOf(Integer.parseInt(calculate(oper1)) - Integer.parseInt(calculate(oper2)));
            }


        } else {
            if (operation.isEmpty()) {
                return "0";
            } else {
                return operation;
            }
        }
    }
}
