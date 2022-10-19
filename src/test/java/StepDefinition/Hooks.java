package StepDefinition;

import Utils.Driver;
import io.cucumber.core.backend.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver = Driver.getDriver();

    @Before  // this part before navigate is before each class
    public void setup(){

        driver.get("https://demo.mersys.io/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Scenario Started!");

    }

    @After
    public void tearDown(Scenario scenario){

        System.out.println("Scenario is done!");
        System.out.println("Scenario result : " + scenario.getStatus());
        System.out.println("Scenario isFailed ? : " + scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yy");

        if (scenario.isFailed()){

            TakesScreenshot screenshot = (TakesScreenshot) driver; // which driver to get a screenshot

            File screenFile = screenshot.getScreenshotAs(OutputType.FILE);

            String scenarioName = scenario.getName();

            File destinationFile = new File("target/FailedScreenshots/" + scenarioName + ".png");



            try {

                FileUtils.copyFile(screenFile,destinationFile);
                        new File("target/FailedScreenShots/" + scenario.getId() + date.format(formatter) + ".png" );
            }catch (IOException e){
                e.printStackTrace();
            }
        }


        Driver.quitDriver();


    }
}
