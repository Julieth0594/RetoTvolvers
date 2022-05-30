package com.tvolvers.certification.restfulbooker.tasks;

import cucumber.deps.com.thoughtworks.xstream.io.path.Path;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.tvolvers.certification.restfulbooker.utils.Constants.*;

public class GetRegister implements Task {
    private int id;

    public GetRegister(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(PATH + ID)
                        .with(request ->request.accept(FORMAT)
                        .pathParam("id",id)));
    }
    public static GetRegister ofuser(int id){
        return Tasks.instrumented(GetRegister.class,id);
    }
}
