//package pom.tests;
//
//import io.qameta.allure.Feature;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.*;
//import pom.pages.*;
//import utils.JsonFileManager;
//
//
//import java.time.Duration;
//
//@Feature("Automation exercise Registration test ")
//@Listeners({utils.TestNgListener.class})
//public class RegistrationTests {
//    WebDriver driver;
//    HomePage homePage;
//    RegisterPage registerPage;
//    JsonFileManager testData;
//    NavigationBar navigationBar;
//    AccountCreatedPage accountCreatedPage;
//    AccountDeletedPage accountDeletedPage;
//
//
//    @Test(description = "User registration")
//    @Severity(SeverityLevel.CRITICAL)
//    public void userRegister() {
//        homePage.assertOnHomePageLoadedSuccessfully();
//        navigationBar.clickOnSignUp();
//        registerPage.assertOnInitialSignUpPageLoadedSuccessfully();
//        registerPage.fillNameEmailSignUpForm(testData.getTestData("initialSignUp.name"), testData.getTestData("initialSignUp.email") );
//        registerPage.assertOnSignUpFullInformationFormLoadedSuccessfully();
//        registerPage.fillFullInformationSignUpForm(testData.getTestData("fullInforegistration.password"),
//                testData.getTestData("fullInforegistration.dayOfBirth"),
//                testData.getTestData("fullInforegistration.monthOfBirth"),
//                testData.getTestData("fullInforegistration.yearOfBirth"),
//                testData.getTestData("fullInforegistration.firstName"),
//                testData.getTestData("fullInforegistration.lastName"),
//                testData.getTestData("fullInforegistration.companyName"),
//                testData.getTestData("fullInforegistration.address1"),
//                testData.getTestData("fullInforegistration.address2"),
//                testData.getTestData("fullInforegistration.country"),
//                testData.getTestData("fullInforegistration.state"),
//                testData.getTestData("fullInforegistration.city"),
//                testData.getTestData("fullInforegistration.zipCode"),
//                testData.getTestData("fullInforegistration.mobileNumber"));
//        accountCreatedPage.assertOnAccountCreated();
//        accountCreatedPage.clickOnContinueButton();
//        navigationBar.assertOnSignedInAsUser();
//        navigationBar.clickOnDeleteAccountButton();
//        accountDeletedPage.assertOnAccountDeletedSuccessfully();
//        accountDeletedPage.clickOnContinueButton();
//    }
//
//    @BeforeClass(description = "initializing browser")
//    public void setUp() {
//        if(System.getProperty("targetBrowser").equals("chrome")) {
//            driver = new ChromeDriver();
//        }
//        else if(System.getProperty("targetBrowser").equals("firefox")) {
//            driver = new FirefoxDriver();
//        }
//        else if(System.getProperty("targetBrowser").equals("edge")) {
//            driver = new EdgeDriver();
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        homePage = new HomePage(driver);
//        registerPage = new RegisterPage(driver);
//        homePage.navigateToAutomationExercisePage();
//        testData = new JsonFileManager("src/test/resources/jsonTestDataFiles/jsonTestDataFile.json");
//
//    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
//
//}
