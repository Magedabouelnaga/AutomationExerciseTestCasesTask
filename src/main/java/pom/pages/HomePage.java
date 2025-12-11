package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;
    //private String automationExerciseUrl = "https://automationexercise.com/";
    private String automationExerciseUrl = System.getProperty("baseUrl");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate to home page")
    public HomePage navigateToAutomationExercisePage() {
        driver.navigate().to(automationExerciseUrl);
        return this;
    }

    @Step("Assert on home page loaded successfully")
    public HomePage assertOnHomePageLoadedSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(), automationExerciseUrl);
        return this;
    }
}
