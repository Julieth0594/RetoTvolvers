package com.tvolvers.certification.restfulbooker.stepdefinitions;

import com.tvolvers.certification.restfulbooker.exceptions.ExpectedCodeException;
import com.tvolvers.certification.restfulbooker.models.ClientData;
import com.tvolvers.certification.restfulbooker.tasks.CreateRegister;
import com.tvolvers.certification.restfulbooker.tasks.GetRegister;
import com.tvolvers.certification.restfulbooker.tasks.UpdateRegister;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;



import java.util.List;

import static com.tvolvers.certification.restfulbooker.utils.Constants.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;


public class BookingStepDefinitions {
    @Before
    public void preparation(){
        setTheStage(new OnlineCast());
        theActorCalled(CLIENT);
    }

    @Given("^the user makes a reservation$")
    public void theUserMakesAReservation() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_URL));


    }

    @When("^the user performs the data registration$")
    public void theUserPerformsTheDataRegistration(List<ClientData> clientDataList) {
        theActorInTheSpotlight().attemptsTo(CreateRegister.ofUser(clientDataList.get(0)));

    }

    @Then("^the user will obtain a confirmation of their reservation$")
    public void theUserWillObtainAConfirmationOfTheirReservation() {
        theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(CREATE,response ->response.statusCode(CODE))
                .orComplainWith(ExpectedCodeException.class,MSG_EXCEPTION));

    }

    @When("^the user gets the data registration with (.*)$")
    public void the_user_gets_the_data_registration(int id) {
        theActorInTheSpotlight().attemptsTo(GetRegister.ofuser(id));
    }


    @Then("^the user will get the information from the registered with (.*)$")
    public void the_user_will_get_the_information_from_the_registered_data(int code) {
        theActorInTheSpotlight()
                .should(ResponseConsequence.seeThatResponse(REGISTER,response->response.statusCode(code))
                        .orComplainWith(ExpectedCodeException.class,MSG_EXCEPTION));

    }


    @When("^the user authorizes updating the information of (.*)$")
    public void theUserAuthorizesUpdatingTheInformation(int id,List<ClientData> clientDataList) {
        theActorInTheSpotlight().attemptsTo(UpdateRegister.ofUser(clientDataList.get(0),id));
    }

    @Then("^the user can validate that the data has been updated with (.*)$")
    public void theUserCanValidateThatTheDataHasBeenUpdated(int code) {
        theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse("succesful update",response->response.statusCode(code))
                .orComplainWith(ExpectedCodeException.class,MSG_EXCEPTION));

    }
}
