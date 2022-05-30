package com.tvolvers.certification.automationpractice.tasks;

import com.tvolvers.certification.automationpractice.interactions.AddTo;
import com.tvolvers.certification.automationpractice.interactions.Search;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.tvolvers.certification.automationpractice.userinterfaces.ProductDetails.*;
import static com.tvolvers.certification.automationpractice.userinterfaces.SearchResult.SELECT_PRODUCT;
import static com.tvolvers.certification.automationpractice.utils.Constants.QUANTITY_PRODUCTS;

public class Select implements Task {
    private String product;
    private int quantity;


    public Select(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Search.inTheBar(product),
                Click.on(SELECT_PRODUCT),
                Enter.theValue(String.valueOf(quantity)).into(QUANTITY_OF_PRODUCTS),
                AddTo.cart());
        actor.remember(QUANTITY_PRODUCTS,quantity);
    }

    public static Select ofProduct(String product, int quantity){
       // return new Search(product);
        return Tasks.instrumented(Select.class,product,quantity);
    }
}
