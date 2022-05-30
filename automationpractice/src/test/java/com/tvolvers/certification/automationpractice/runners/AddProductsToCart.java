package com.tvolvers.certification.automationpractice.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/add_products_to_cart.feature",
        glue = "com.tvolvers.certification.automationpractice.stepdefinitions",
        tags = "@SearchBar",
        snippets = SnippetType.CAMELCASE
)
public class AddProductsToCart {
}
