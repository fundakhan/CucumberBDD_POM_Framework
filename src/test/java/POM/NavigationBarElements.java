package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBarElements extends BasePOM{

    public NavigationBarElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "(//span[text()='Parameters'])[1]")
    private WebElement parameters;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    private WebElement countries;

    @FindBy(xpath = "//span[text()='Citizenships']/..")
    private WebElement citizenshipBtn;

    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement fees;



    public void userClickOnNavBar(){

        setupOne.click();
        parameters.click();
        countries.click();
        wait.until(ExpectedConditions.urlContains("countries"));
    }

    public void navigateToCitizenshipPage(){

        setupOne.click();
        parameters.click();
        citizenshipBtn.click();
    }

    public void navigateToFeePage(){

        waitUntilVisibleAndClickableThenClick(setupOne);
        parameters.click();
        fees.click();

    }




}
