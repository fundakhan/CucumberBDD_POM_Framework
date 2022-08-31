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


    public void userClickOnNavBar(){

        setupOne.click();
        parameters.click();
        countries.click();
        wait.until(ExpectedConditions.urlContains("countries"));
    }




}
