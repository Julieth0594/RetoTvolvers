package com.tvolvers.certification.automationpractice.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PriceVerification {
    public static final Target TOTAL = Target.the("total products").locatedBy("//td[@class='cart_total']");
    public static final Target UNIT_PRICE = Target.the("unit price of product").locatedBy("//td[@class='cart_unit']");
    public static final Target QTY = Target.the("qty product").locatedBy("///input[@class='cart_quantity_input form-control grey']");
}
