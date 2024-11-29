package com.xq.stepdefinitions;
import com.xq.PetApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class PetSteps {
    @Steps
    PetApi petApi;

    @Given("Kitty is available in the pet store")
    public void givenKittyIsAvailableInPetStore() {
        petApi.createPet();
    }

    @When("I ask for a pet using Kitty's ID")
    public void iAskForAPetUsingKittySID() {
        petApi.queryPet();
    }

    @Then("I get Kitty as result")
    public void thenISeeKittyAsResult() {
        petApi.checkPetResult();
    }
}
