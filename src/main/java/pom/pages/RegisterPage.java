package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {

    private WebDriver driver;

    private By newUserSignUpText = By.xpath("//div[@class='signup-form']/h2") ;
    private By nameInitialSignUp = By.xpath("//*[@data-qa='signup-name']");
    private By emailInitialSignUp = By.xpath("//*[@data-qa='signup-email']");
    private By signUpButton = By.xpath("//*[@data-qa='signup-button']");
    private By enterAccountInformationText = By.xpath("//div[@class='login-form']/h2[@class='title text-center']/b");
    private By maleGender = By.id("id_gender1");
    private By femaleGender = By.id("id_gender2");
    private By password = By.id("password");
    private By dayOfBirth = By.id("days");
    private By monthOfBirth = By.id("months");
    private By yearOfBirth = By.id("years");
    private By newsletter = By.id("newsletter");
    private By specialOffers = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By companyName = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipCode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountButton = By.xpath("//*[@data-qa='create-account']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill name and email in the initial signup form")
    public RegisterPage fillNameEmailSignUpForm(String name, String mail) {
        driver.findElement(nameInitialSignUp).sendKeys(name);
        driver.findElement(emailInitialSignUp).sendKeys(mail);
        driver.findElement(signUpButton).click();
        return this;
    }

    @Step("fill full signup form information")
    public RegisterPage fillFullInformationSignUpForm(String pass, String day, String month, String year,String name,String secondName, String company1, String address11, String address22, String origin, String state1, String city1, String zipCode1, String mobNumber) {
        clickOnMaleGender();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(dayOfBirth).sendKeys(day);
        driver.findElement(monthOfBirth).sendKeys(month);
        driver.findElement(yearOfBirth).sendKeys(year);
        driver.findElement(newsletter).click();
        driver.findElement(specialOffers).click();
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(secondName);
        driver.findElement(companyName).sendKeys(company1);
        driver.findElement(address1).sendKeys(address11);
        driver.findElement(address2).sendKeys(address22);
        driver.findElement(country).sendKeys(origin);
        driver.findElement(state).sendKeys(state1);
        driver.findElement(city).sendKeys(city1);
        driver.findElement(zipCode).sendKeys(zipCode1);
        driver.findElement(mobileNumber).sendKeys(mobNumber);
        driver.findElement(createAccountButton).click();
        return this;
    }

    @Step("Click on male gender")
    public RegisterPage clickOnMaleGender(){
        driver.findElement(maleGender).click();
        return this;
    }

    public RegisterPage clickOnFemaleGender(){
        driver.findElement(femaleGender).click();
        return this;
    }

    @Step("Assert on signUpLogin page loaded successfully")
    public RegisterPage assertOnInitialSignUpPageLoadedSuccessfully(){
        Assert.assertEquals(driver.findElement(newUserSignUpText).getText(), "New User Signup!");
        return this;
    }

    @Step("Assert on sign up full information form loaded successfully")
    public RegisterPage assertOnSignUpFullInformationFormLoadedSuccessfully(){
        Assert.assertEquals(driver.findElement(enterAccountInformationText).getText(), "ENTER ACCOUNT INFORMATION");
        return this;
    }
}
