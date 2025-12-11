package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.JsonFileManager;

public class NavigationBar {

    private WebDriver driver;
    private JsonFileManager testData = new JsonFileManager("src/test/resources/jsonTestDataFiles/jsonTestDataFile.json");

    private  By logOutButton = By.xpath("//div[@class=\"shop-menu pull-right\"]//a[@href='/logout']");
    private By loginOrSignup = By.cssSelector("a[href='/login']");
    private By loggedInAsUserText = By.xpath("//i[@class = 'fa fa-user']/parent::a");
    private By hrefDeleteAccount = By.cssSelector("a[href='/delete_account']");

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on signUp button")
    public NavigationBar clickOnSignUp(){
        driver.findElement(loginOrSignup).click();
        return this;
    }

    @Step("Click on log out button")
    public NavigationBar clickOnLogOutButton(){
        driver.findElement(logOutButton).click();
        return this;
    }

    @Step("Click on delete button")
    public NavigationBar clickOnDeleteAccountButton() {
        driver.findElement(hrefDeleteAccount).click();
        return this;
    }

    @Step("Assert on signed in as user is visible")
    public NavigationBar assertOnSignedInAsUser(){
        Assert.assertEquals(driver.findElement(loggedInAsUserText).getText(), "Logged in as" + " " + testData.getTestData("initialSignUp.name"));
        return this;
    }

}
