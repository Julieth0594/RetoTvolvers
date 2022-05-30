package com.tvolvers.certification.automationpractice.utils;

import java.text.DecimalFormat;

public class Convert {
    public static double toDouble(String unitPrice){
         return Double.parseDouble(unitPrice.replace("$",""));
    }
    public static int toInteger(String quantity){
        return Integer.parseInt(quantity);
    }
    public static String toPrice(double price){
        DecimalFormat decimalFormat=new DecimalFormat("#.00");
        return "$"+decimalFormat.format(price).replace(",",".");
    }
}
