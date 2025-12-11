package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreatedPage {

    WebDriver driver;

    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private By accountCreatedText = By.xpath("//*[@data-qa='account-created']/b");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on continue button")
    public AccountCreatedPage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return this;
    }

    @Step("Assert on Account created successfully")
    public AccountCreatedPage assertOnAccountCreated(){
        Assert.assertEquals(driver.findElement(accountCreatedText).getText(), "ACCOUNT CREATED!");
        return this;
    }


}
