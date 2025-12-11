package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementActions {

    @Step("Typing [{input}] on element with locator: {elementLocator}")
    public static void type(WebDriver driver, By elementLocator, String input) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

        if(!driver.findElement(elementLocator).getAttribute("value").isBlank()) {
            driver.findElement(elementLocator).clear();
        }
        try{
            driver.findElement(elementLocator).sendKeys(input);
    }
        catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
}
