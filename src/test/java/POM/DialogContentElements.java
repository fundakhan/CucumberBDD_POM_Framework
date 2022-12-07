package POM;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DialogContentElements extends BasePOM{

    public DialogContentElements(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder, 'FIELD.NAME')]//input")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-edit-button//button")
    private WebElement editButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement trashBtn;

    @FindBy(xpath = "//button[@type='submit']//span[text()=' Delete ']")
    private WebElement deleteBtnTwo;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exist')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder, 'FIELD.INTEGRATION_CODE')]//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityInput;



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

    public void validateSuccessfullyMessage(){
      // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'successfully')]")));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));

//        wait.until(ExpectedConditions.visibilityOf(alreadyExist));
//        Assert.assertTrue(alreadyExist.getText().contains("already exists".toLowerCase()));
    }

    public void userEditCountry(){
        searchInput.sendKeys(country);
        searchButton.click();
       waitUntilVisibleAndClickableThenClick(editButton);
        nameInput.clear();
        nameInput.sendKeys(editCountry);
        codeInput.clear();
        codeInput.sendKeys(editCode);
        saveButton.click();

    }

    public void userDeleteCountry(){

        searchInput.sendKeys(editCountry);
        waitUntilVisibleAndClickableThenClick(searchButton);
        waitUntilVisibleAndClickableThenClick(trashBtn);
        deleteBtnTwo.click();
    }

    public void createCitizenship(String name, String shortNamee){

        addButton.click();
        nameInput.sendKeys(name);
        shortName.sendKeys(shortNamee);
        saveButton.click();
    }

    public void editCitizenship(String name, String updateName){

        searchInput.sendKeys(name);
        searchButton.click();
        waitUntilVisibleAndClickableThenClick(editButton);
        nameInput.clear();
        nameInput.sendKeys(updateName);
        shortName.clear();
        saveButton.click();

    }

    public void deleteCitizenship(String updateName){

        searchInput.sendKeys(updateName);
        searchButton.click();
        waitUntilVisibleAndClickableThenClick(trashBtn);
        waitUntilVisibleAndClickableThenClick(deleteBtnTwo);

    }

    public void  createFee(String feeName, String feeCode, String intCode,String priority){

        addButton.click();
        nameInput.sendKeys(feeName);
        codeInput.sendKeys(feeCode);
        integrationCode.sendKeys(intCode);
        priorityInput.clear();
        priorityInput.sendKeys(priority);
        nameInput.click();
        waitUntilVisibleAndClickableThenClick(saveButton);

    }

    public void editFee(String existingFeeName, String newFeeName){

        searchInput.sendKeys(existingFeeName);
        searchButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody[role='rowgroup']>tr"), 1));
        editButton.click();
        nameInput.clear();
        nameInput.sendKeys(newFeeName);
        waitUntilVisibleAndClickableThenClick(saveButton);

    }

    public void deleteFee(String FeeName){

        searchInput.sendKeys(FeeName);
        searchButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody[role='rowgroup']>tr"), 1));
        //Driver.wait(3);
        trashBtn.click();
        waitUntilVisibleAndClickableThenClick(deleteBtnTwo);



    }




}
