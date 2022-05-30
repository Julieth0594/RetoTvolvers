package com.tvolvers.certification.automationpractice.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    public static final Target INPUT_SEARCH=Target.the("input search").located(By.id("search_query_top"));

}
