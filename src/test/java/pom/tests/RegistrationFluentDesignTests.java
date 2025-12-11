package pom.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pom.pages.*;
import utils.DriverFactory;
import utils.JsonFileManager;

import java.time.Duration;

@Feature("Automation exercise Registration test ")
@Listeners({utils.TestNgListener.class})
public class RegistrationFluentDesignTests {

    WebDriver driver;
    JsonFileManager testData;

    @Test(description = "New user registration")
    @Severity(SeverityLevel.CRITICAL)
    public void userRegister() {
        new HomePage(driver)
                .assertOnHomePageLoadedSuccessfully();
        new NavigationBar(driver)
                .clickOnSignUp();
        new RegisterPage(driver)
                .assertOnInitialSignUpPageLoadedSuccessfully()
                .fillNameEmailSignUpForm(testData.getTestData("initialSignUp.name"), testData.getTestData("initialSignUp.email"))
                .assertOnSignUpFullInformationFormLoadedSuccessfully()
                .fillFullInformationSignUpForm(testData.getTestData("fullInforegistration.password"),
                        testData.getTestData("fullInforegistration.dayOfBirth"),
                        testData.getTestData("fullInforegistration.monthOfBirth"),
                        testData.getTestData("fullInforegistration.yearOfBirth"),
                        testData.getTestData("fullInforegistration.firstName"),
                        testData.getTestData("fullInforegistration.lastName"),
                        testData.getTestData("fullInforegistration.companyName"),
                        testData.getTestData("fullInforegistration.address1"),
                        testData.getTestData("fullInforegistration.address2"),
                        testData.getTestData("fullInforegistration.country"),
                        testData.getTestData("fullInforegistration.state"),
                        testData.getTestData("fullInforegistration.city"),
                        testData.getTestData("fullInforegistration.zipCode"),
                        testData.getTestData("fullInforegistration.mobileNumber"));
        new AccountCreatedPage(driver)
                .assertOnAccountCreated()
                .clickOnContinueButton();
        new NavigationBar(driver)
                .assertOnSignedInAsUser()
                .clickOnDeleteAccountButton();
        new AccountDeletedPage(driver)
                .assertOnAccountDeletedSuccessfully()
                .clickOnContinueButton();
    }

    @BeforeClass(description = "initializing browser and json file")
    public void setUp() {

        driver = DriverFactory.initiateDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        new HomePage(driver)
                .navigateToAutomationExercisePage();
        testData = new JsonFileManager("src/test/resources/jsonTestDataFiles/jsonTestDataFile.json");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
