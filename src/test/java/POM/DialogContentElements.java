package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DialogContentElements extends BasePOM{

    public  DialogContentElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ms-add-button[@tooltip='COUNTRY.TITLE.ADD']")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']") // //ms-save-button//button
    private WebElement saveButton;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder, 'FIELD.NAME')]//input")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement countryBtn;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@type='submit']//span[text()=' Delete ']")
    private WebElement deleteBtnTwo;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]")
    private WebElement successMessage;

    private String country = "America";
    private String code = "USA";
    private String editCountry = "Cuba";
    private String editCode = "Cb";

    public void userCreateNewCountry(){

        addButton.click();
        nameInput.sendKeys(country);
        codeInput.sendKeys(code);
        saveButton.click();
    }

    public void validateCountrySuccessfullyMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }

    public void userEditCountry(){
        searchInput.sendKeys(country);
        searchButton.click();
        countryBtn.click();
        nameInput.clear();
        nameInput.sendKeys(editCountry);
        codeInput.clear();
        codeInput.sendKeys(editCode);
        saveButton.click();

    }

    public void userDeleteCountry(){

        searchInput.sendKeys(editCountry);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        deleteBtnTwo.click();
    }




}
