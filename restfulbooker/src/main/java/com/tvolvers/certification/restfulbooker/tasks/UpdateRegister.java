package com.tvolvers.certification.restfulbooker.tasks;

import com.tvolvers.certification.restfulbooker.interactions.CreateToken;
import com.tvolvers.certification.restfulbooker.models.ClientData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.tvolvers.certification.restfulbooker.utils.Constants.*;

public class UpdateRegister implements Task {
    private final int id;
    private final ClientData clientData;

    public UpdateRegister(ClientData clientData, int id) {
        this.id = id;
        this.clientData = clientData;
        this.clientData.setBookingdates(clientData.getCheckin(), clientData.getCheckout());
    }

    public static UpdateRegister ofUser(ClientData clientData, int id) {
        return Tasks.instrumented(UpdateRegister.class, clientData, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CreateToken.forUser(),
                Put.to(PATH + ID).with(request -> request
                        .pathParam("id", id)
                        .contentType(FORMAT).accept(FORMAT)
                        .header(COOKIE, "token=" + actor.recall(TOKEN))
                        .body(clientData)));

    }
}
