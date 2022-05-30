package com.tvolvers.certification.automationpractice.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsWomen {
    public static final Target SELECT_PRODUCT = Target.the("select product")
            .locatedBy("//img[@alt='{0}']");

}
