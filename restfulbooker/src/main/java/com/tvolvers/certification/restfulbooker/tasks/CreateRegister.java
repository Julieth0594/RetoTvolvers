package com.tvolvers.certification.restfulbooker.tasks;

import com.tvolvers.certification.restfulbooker.models.ClientData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.tvolvers.certification.restfulbooker.utils.Constants.FORMAT;
import static com.tvolvers.certification.restfulbooker.utils.Constants.PATH;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CreateRegister implements Task {
    private ClientData clientData;

    public CreateRegister(ClientData clientData) {
        this.clientData = clientData;
        this.clientData.setBookingdates(clientData.getCheckin(),clientData.getCheckout());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(PATH)
                .with(request -> request.contentType(FORMAT)
                        .accept(FORMAT)
                        .body(clientData))); }

    public static CreateRegister ofUser(ClientData clientData){
        return Tasks.instrumented(CreateRegister.class,clientData);
    }
}


