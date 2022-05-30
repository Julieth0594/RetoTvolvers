package com.tvolvers.certification.automationpractice.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.tvolvers.certification.automationpractice.userinterfaces.HomePage.INPUT_SEARCH;

public class Search implements Interaction {
    private String product;

    public Search(String product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(product).into(INPUT_SEARCH).thenHit(Keys.ENTER));

    }

    public static Search inTheBar(String product){
        return Tasks.instrumented(Search.class,product);
    }
}
