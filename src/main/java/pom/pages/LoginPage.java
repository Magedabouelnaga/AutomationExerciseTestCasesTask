package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.JsonFileManager;
//import utils.JsonFileManager;

public class LoginPage {

    private WebDriver driver;
    private JsonFileManager testData = new JsonFileManager("src/test/resources/jsonTestDataFiles/jsonTestDataFile.json");

    private By loginToYourAccountText = By.xpath("//div[@class='login-form']/h2");
    private By email = By.xpath("//*[@data-qa='login-email']");
    private By password = By.xpath("//*[@data-qa='login-password']");
    private By signInButton = By.xpath("//*[@data-qa='login-button']");
    private By yourMailOrPasswordIncorrectText = By.xpath("//div[@class='login-form']//p");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill valid user login data")
    public LoginPage fillValidUserLogin(String mail, String pass) {
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();
        return this;
    }

    @Step("Fill invalid user login data")
    public LoginPage fillInvalidUserLogin(String mail, String pass) {
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();
        return this;
    }

    @Step("Assert on your email or password is incorrect text")
    public LoginPage assertOnMailOrPasswordIncorrectText(){
        Assert.assertEquals(driver.findElement(yourMailOrPasswordIncorrectText).getText(), "Your email or password is incorrect!");
        return this;
    }

    @Step("Assert on login page loaded successfully")
    public LoginPage assertOnLoginPageLoadedSuccessfully(){
        Assert.assertEquals(driver.findElement(loginToYourAccountText).getText(), "Login to your account");
        return this;
    }

    @Step("Prepare user Login data")
    public void createUserForLogin() {
        new NavigationBar(driver).clickOnSignUp();

        new RegisterPage(driver)
                .assertOnInitialSignUpPageLoadedSuccessfully()
                .fillNameEmailSignUpForm(
                        testData.getTestData("initialSignUp.name"),
                        testData.getTestData("initialSignUp.email"))
                .assertOnSignUpFullInformationFormLoadedSuccessfully()
                .fillFullInformationSignUpForm(
                        testData.getTestData("validLogin.password"),
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
    }


}
