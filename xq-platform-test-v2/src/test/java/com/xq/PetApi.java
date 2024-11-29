package com.xq;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;

public class PetApi {
    Long id = null;

    @Step("Create a pet")
    public void createPet() {
        Pet pet = new Pet("Kitty", "available");

        id = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .body(pet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Pet.class, ObjectMapperType.GSON).getId();
    }

    @Step("Get a pet")
    public void queryPet() {
        when().get("/" + id);
    }

    @Step("Check pet result")
    public void checkPetResult() {
        then().body("name", Matchers.equalTo("Kitty"));
    }
}
