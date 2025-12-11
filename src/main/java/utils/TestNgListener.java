package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.ByteArrayInputStream;

public class TestNgListener implements ISuiteListener, ITestListener, IInvokedMethodListener {

    @Override
    public void onStart(ISuite Suite){
        System.out.println("Hello from Giza Systems interns 2025" + "\n" + "We are starting our execution from here" );
        PropertiesLoader.loadProperties();
    }

    @Override
    public void onFinish(ISuite Suite){
        System.out.println("Execution is Finished..., Thank You.");
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test started" + ":" + " " + result.getMethod().getDescription());
    }
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        WebDriver driver = DriverFactory.getDriver();
        if (ITestResult.FAILURE == testResult.getStatus() && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
        }
    }

}
