package com.tvolvers.certification.automationpractice.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.tvolvers.certification.automationpractice.userinterfaces.ProductDetails.ADD_TO_CART;
import static com.tvolvers.certification.automationpractice.userinterfaces.ProductDetails.PROCEED_TO_CHECKOUT;

public class AddTo implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ADD_TO_CART),
                Click.on(PROCEED_TO_CHECKOUT));

    }
    public static AddTo cart(){
        return Tasks.instrumented(AddTo.class);
    }
}
