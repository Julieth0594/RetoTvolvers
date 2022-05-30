package com.tvolvers.certification.automationpractice.utils;

import net.serenitybdd.screenplay.actions.Open;

import java.text.DecimalFormat;

public class Operation {
    public static String ofPrices(String unitPrice,int quantity){
        double total = Convert.toDouble(unitPrice)*quantity;
        return Convert.toPrice(total);
    }
}
