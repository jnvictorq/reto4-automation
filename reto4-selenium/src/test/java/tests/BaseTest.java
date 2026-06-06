package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected WebDriver driver;

    @AfterMethod
    public void tearDown(ITestResult result)
            throws IOException {

        if (result.getStatus()
                == ITestResult.FAILURE) {

            File screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(
                                    OutputType.FILE
                            );

            FileUtils.copyFile(
                    screenshot,
                    new File(
                            "screenshots/"
                                    + result.getName()
                                    + ".png"
                    )
            );
        }

        if (driver != null) {
            driver.quit();
        }
    }
}