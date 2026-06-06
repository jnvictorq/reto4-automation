package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;
public class LoginTest {

    @Test
    public void loginSuccess() {

        WebDriver driver = DriverFactory.getDriver();

        try {

            HomePage home = new HomePage(driver);
            LoginPage login = new LoginPage(driver);

            home.open();

            home.clickLogin();

            login.login(
                    "juanvictor01",
                    "123456"
            );

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("nameofuser")
                    )
            );

            String welcomeText =
                    driver.findElement(By.id("nameofuser"))
                            .getText();

            System.out.println("Mensaje encontrado: " + welcomeText);

            Assert.assertTrue(
                    welcomeText.contains("Welcome"),
                    "No se mostró el mensaje de bienvenida"
            );

        } finally {

            driver.quit();

        }
    }
}
