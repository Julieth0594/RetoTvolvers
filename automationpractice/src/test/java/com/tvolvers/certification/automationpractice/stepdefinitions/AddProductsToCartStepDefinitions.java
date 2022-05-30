package com.tvolvers.certification.automationpractice.stepdefinitions;

import com.tvolvers.certification.automationpractice.exceptions.TotalPriceException;
import com.tvolvers.certification.automationpractice.questions.TheCalculation;
import com.tvolvers.certification.automationpractice.questions.TotalProduct;
import com.tvolvers.certification.automationpractice.tasks.Select;
import com.tvolvers.certification.automationpractice.tasks.Sections;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static com.tvolvers.certification.automationpractice.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;

public class AddProductsToCartStepDefinitions {
    @Before
    public void preparation(){
        setTheStage(new OnlineCast());
        theActorCalled(BUYER);

    }

    @Given("^the user is on the website automation practice$")
    public void theUserIsOnTheWebsiteAutomationPractice() {
        theActorInTheSpotlight().wasAbleTo(Open.url(PAGE_WEB));
    }


    @When("^the user adds (.*) products of (.*) to the cart$")
    public void theUserAddsAProductToTheCart(int quantity,String product) {
        theActorInTheSpotlight().attemptsTo(Select.ofProduct(product,quantity));

    }

    @Then("^the user will be able to visualize the total value of the purchase$")
    public void theUserWillBeAbleToVisualizeTheTotalValueOfThePurchase() {
        theActorInTheSpotlight().should(seeThat(TheCalculation.ofPrice(),Matchers.is(true))
                .orComplainWith(TotalPriceException.class,MESSAGE_PRICE_EXCEPTIONS));

    }



    @When("^the user selects (.*) products of (.*) from the women's section$")
    public void theUserSelectsAProductFromTheWomenSSection(int quantity,String product) {
        theActorInTheSpotlight().attemptsTo(Sections.womens(quantity,product));

    }

    @Then("^the user can verify the total (.*) of the products$")
    public void theUserCanVerifyTheTotalValueOfTheProducts(String totalValue) {
        theActorInTheSpotlight().should(seeThat(TotalProduct.value(), is(equalTo(totalValue)))
                .orComplainWith(TotalPriceException.class,
                "It was not possible to validate the total price of the product"));
    }



}
