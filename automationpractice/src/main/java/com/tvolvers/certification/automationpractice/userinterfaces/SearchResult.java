package com.tvolvers.certification.automationpractice.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchResult {

    public static final Target SELECT_PRODUCT = Target.the("select the product")
            .located(By.xpath("//div[@class='product-image-container']"));
}