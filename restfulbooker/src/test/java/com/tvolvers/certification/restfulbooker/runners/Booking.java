package com.tvolvers.certification.restfulbooker.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/booking.feature",
        glue ="com.tvolvers.certification.restfulbooker.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class Booking {
}
