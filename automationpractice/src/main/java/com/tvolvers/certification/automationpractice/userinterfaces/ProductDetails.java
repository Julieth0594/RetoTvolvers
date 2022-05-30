package com.tvolvers.certification.automationpractice.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetails {
    public static final Target QUANTITY_OF_PRODUCTS = Target.the("quantity of products").located(By.id("quantity_wanted"));
    public static final Target ADD_TO_CART = Target.the("add products to cart").located(By.id("add_to_cart"));
    public static final Target PROCEED_TO_CHECKOUT = Target.the("proceed to checkout").located(By.xpath("//a[@class='btn btn-default button button-medium']"));
    }

