package StepDefinition;

import POM.DialogContentElements;
import POM.NavigationBarElements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CountriesSteps {


    DialogContentElements dialogContentElements;

    NavigationBarElements navigationBarElements;
    @When("User create Country")
    public void user_create_country() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.userClickOnNavBar();
        dialogContentElements.userCreateNewCountry();

    }
    @When("User edit Country")
    public void user_edit_country() {

        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.userClickOnNavBar();
        dialogContentElements.userEditCountry();

    }

    @When("User delete country")
    public void user_delete_country() {

        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.userClickOnNavBar();
        dialogContentElements.userDeleteCountry();
    }

    @Then("Success message should be displayed")
    public void success_message_should_be_displayed() {

        dialogContentElements = new DialogContentElements();
        dialogContentElements.validateCountrySuccessfullyMessage();
    }




}
