package com.tvolvers.certification.automationpractice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.tvolvers.certification.automationpractice.userinterfaces.PriceVerification.TOTAL;

public class TotalProduct implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(TOTAL).viewedBy(actor).asString();
    }

    public static TotalProduct value(){
        return new TotalProduct();
    }
}
