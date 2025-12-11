package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletedPage {

    WebDriver driver;

    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private By accountDeletedText = By.xpath("//*[@data-qa='account-deleted']/b");

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on continue button")
    public AccountDeletedPage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return this;
    }

    @Step("Assert on Account deleted successfully")
    public AccountDeletedPage assertOnAccountDeletedSuccessfully(){
        Assert.assertEquals(driver.findElement(accountDeletedText).getText(), "ACCOUNT DELETED!");
        return this;
    }
}
