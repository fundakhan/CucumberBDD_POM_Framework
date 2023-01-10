package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePOM{

    public LoginPage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(css= "input[formcontrolname='username']")
    private WebElement usernameInput;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement acceptCookiesBtn;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    private String username = "turkeyts";
    private String password = "TechnoStudy123";



    public void validateUserOnLoginPage(){

        wait.until(ExpectedConditions.urlToBe("https://demo.mersys.io/"));
        Assert.assertTrue(usernameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void userEnterAdminCredentials(){

        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
        passwordInput.sendKeys(password);
        waitUntilVisibleAndClickableThenClick(loginButton);
    }

    public void validateUserSuccessfullyLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(dashboard));
        Assert.assertTrue(dashboard.isDisplayed());
    }




    }


