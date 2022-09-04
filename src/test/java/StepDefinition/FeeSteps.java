package StepDefinition;

import POM.DialogContentElements;
import POM.NavigationBarElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeeSteps {

    NavigationBarElements navigationBarElements;
    DialogContentElements dialogContentElements;


    @And("User create Fee {string} and {string} and {string} and {string}")
    public void userCreateFeeAndAndAnd(String feeName, String feeCode, String intCode, String priority) {

        navigationBarElements = new NavigationBarElements();

        dialogContentElements = new DialogContentElements();

        navigationBarElements.navigateToFeePage();
        dialogContentElements.createFee(feeName,feeCode,intCode,priority);


    }

    @And("User edit Fee {string} and change it to {string}")
    public void userEditFeeAndChangeItTo(String existingFeeName, String newFeeName) {

        navigationBarElements = new NavigationBarElements();
        navigationBarElements.navigateToFeePage();

        dialogContentElements = new DialogContentElements();
        dialogContentElements.editFee(existingFeeName, newFeeName);
    }

    @And("User delete Fee {string}")
    public void userDeleteFee(String FeeName) {

        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.navigateToFeePage();
        dialogContentElements.deleteFee(FeeName);
    }
}
