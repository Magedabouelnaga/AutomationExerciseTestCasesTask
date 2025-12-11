package pom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pom.pages.*;
import utils.DriverFactory;
import utils.JsonFileManager;

import java.time.Duration;

@Listeners({utils.TestNgListener.class})
public class LoginTests {
    WebDriver driver;
    JsonFileManager testData;


    @Test(description = "User valid Login")
    public void userValidLogin() {
        new HomePage(driver)
                .assertOnHomePageLoadedSuccessfully();
        new NavigationBar(driver)
                .clickOnSignUp();
        new LoginPage(driver)
                .assertOnLoginPageLoadedSuccessfully()
                .fillValidUserLogin(testData.getTestData("validLogin.email"), testData.getTestData("validLogin.password"));
        new NavigationBar(driver)
                .assertOnSignedInAsUser()
                .clickOnDeleteAccountButton();
        new AccountDeletedPage(driver)
                .assertOnAccountDeletedSuccessfully();
    }

    @Test(description = "User invalid Login")
    public void userInvalidLogin() {
        new HomePage(driver)
                .assertOnHomePageLoadedSuccessfully();
        new NavigationBar(driver)
                .clickOnSignUp();
        new LoginPage(driver)
                .assertOnLoginPageLoadedSuccessfully()
                .fillInvalidUserLogin(testData.getTestData("invalidLogin.email"), testData.getTestData("invalidLogin.password"))
                .assertOnMailOrPasswordIncorrectText();
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.initiateDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        testData = new JsonFileManager("src/test/resources/jsonTestDataFiles/jsonTestDataFile.json");

        new HomePage(driver)
                .navigateToAutomationExercisePage();
        new LoginPage(driver)
                .createUserForLogin();
        new AccountCreatedPage(driver)
                .clickOnContinueButton();
        new NavigationBar(driver)
                .clickOnLogOutButton();
        driver.quit();
    }

    @BeforeMethod
    public void MethodSetup(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        new HomePage(driver)
                .navigateToAutomationExercisePage();
        testData = new JsonFileManager("src/test/resources/jsonTestDataFiles/jsonTestDataFile.json");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
