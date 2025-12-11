package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

public class DriverFactory {
   static WebDriver driver;

    public static WebDriver initiateDriver(){
        return initiateDriver(System.getProperty("targetBrowser"), Boolean.valueOf(System.getProperty("headless")), Boolean.valueOf(System.getProperty("maximizeWindow")));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @Step("initializing Browser: [{browserName}]" )
    public static WebDriver initiateDriver(String browserName, Boolean headless, Boolean maximize) {
        driver = null;
         browserName = System.getProperty("targetBrowser", "chrome");
         headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
         maximize = Boolean.parseBoolean(System.getProperty("maximizeWindow", "true"));

        if(browserName.equalsIgnoreCase("chrome")) {
            if(headless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
            }
            else {
                driver = new ChromeDriver();
            }
        }
        else if(browserName.equalsIgnoreCase("edge")) {
            if(headless) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                driver = new EdgeDriver(edgeOptions);
            }
            else{
                driver = new EdgeDriver();
            }
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            if(headless) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=new");
                driver = new FirefoxDriver(firefoxOptions);
            }
            else{
                driver = new FirefoxDriver();
            }
        }
        else{
            Assert.fail("Selected driver" + " " + browserName + " " + "does not exist");
        }

        if(maximize) {
            driver.manage().window().maximize();
        }
        return driver;
    }
}
