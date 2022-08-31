package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

    /**
     *
     *
     *  SINGLETON DRIVER CLASS
     *
     *  - We are using singleton driver because we need 1 driver for every class in our project
     */
   private static WebDriver driver;

    public static WebDriver getDriver(){

        // if the driver object is equal to null (there is no wctive driver instance) then we'll create a new driver

        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // terminaldeki kirmizi uyari yazilarini kaldirmak icin yaptik
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY,"Error"); // terminalde ilk basta cikan kirmizi iki satirlik uyari yazisini kaldirmak icin kullandik
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

        }
        return driver;
    }

    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver = null; // if we don't have this line next scenario will fail
                           // after driver.quit we need to set driver object to null
        }

    }
}
