package StepDefinition;

import POM.DialogContentElements;
import POM.NavigationBarElements;
import io.cucumber.java.en.When;

public class CitizenshipSteps {

    NavigationBarElements navigationBarElements;

    DialogContentElements dialogContentElements;

    @When("User create Citizenship with {string} name and {string} shortname")
    public void userCreateCitizenshipWithNameAndShortname(String name, String shortName) {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.navigateToCitizenshipPage();
        dialogContentElements.createCitizenship(name,shortName);

    }

    @When("User edit {string} citizenship to {string}")
    public void userEditCitizenshipTo(String name, String updateName) {

        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.navigateToCitizenshipPage();
        dialogContentElements.editCitizenship(name,updateName);

    }

    @When("User delete {string} citizenship")
    public void userDeleteCitizenship(String updateName) {

        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.navigateToCitizenshipPage();
        dialogContentElements.deleteCitizenship(updateName);
    }
}
