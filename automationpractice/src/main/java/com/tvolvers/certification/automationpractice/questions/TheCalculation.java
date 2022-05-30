package com.tvolvers.certification.automationpractice.questions;

import com.tvolvers.certification.automationpractice.utils.Operation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.tvolvers.certification.automationpractice.userinterfaces.PriceVerification.*;
import static com.tvolvers.certification.automationpractice.utils.Constants.QUANTITY_PRODUCTS;

public class TheCalculation implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        System.out.println("Operation "+ Operation.ofPrices(UNIT_PRICE.resolveFor(actor).getText(), actor.recall("quantity")));
        return Text.of(TOTAL).viewedBy(actor).asString().equals(Operation.ofPrices(UNIT_PRICE.resolveFor(actor).getText(),actor.recall(QUANTITY_PRODUCTS)));
    }
    public static TheCalculation ofPrice(){
        return new TheCalculation();
    }
}
