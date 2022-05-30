package com.tvolvers.certification.restfulbooker.interactions;

import com.tvolvers.certification.restfulbooker.models.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.tvolvers.certification.restfulbooker.utils.Constants.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CreateToken implements Interaction {
    private Credentials credentials=new Credentials();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(PATH_AUTH)
                .with(request->request.contentType(FORMAT)
                        .body(credentials)));
            actor.remember(TOKEN,lastResponse().body().jsonPath().get(TOKEN).toString());
    }
    public static CreateToken forUser(){
        return Tasks.instrumented(CreateToken.class);
    }
}
