package tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignupPage;

import utils.DriverFactory;

public class SignupTest extends BaseTest {

    @Test
    public void signupSuccess() {

        driver =
                DriverFactory.getDriver();

        try {

            HomePage home =
                    new HomePage(driver);

            SignupPage signup =
                    new SignupPage(driver);

            home.open();

            home.clickSignUp();

            String user =
                    "user" + System.currentTimeMillis();

            String message =
                    signup.register(
                            user,
                            "123456"
                    );

            Assert.assertTrue(
                    message.contains("Sign up successful")
            );

        } finally {

            driver.quit();

        }
    }
}