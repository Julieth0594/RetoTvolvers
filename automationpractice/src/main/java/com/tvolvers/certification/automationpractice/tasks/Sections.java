package com.tvolvers.certification.automationpractice.tasks;

import com.tvolvers.certification.automationpractice.interactions.AddTo;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import org.openqa.selenium.Keys;

import static com.tvolvers.certification.automationpractice.userinterfaces.ProductDetails.QUANTITY_OF_PRODUCTS;
import static com.tvolvers.certification.automationpractice.userinterfaces.ProductsWomen.SELECT_PRODUCT;
import static com.tvolvers.certification.automationpractice.userinterfaces.Section.SECTION_WOMENS;

public class Sections implements Task {
    private final int quantity;
    private final String product;

    public Sections(int quantity, String product) {
        this.quantity = quantity;
        this.product = product;
    }

    public static Sections womens(int quantity, String product) {
        return Tasks.instrumented(Sections.class, quantity, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SECTION_WOMENS),
                Click.on(SELECT_PRODUCT.of(product)),
                Enter.theValue(String.valueOf(quantity)).into(QUANTITY_OF_PRODUCTS),
                AddTo.cart());
    }
}
