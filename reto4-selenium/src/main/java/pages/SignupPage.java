package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("sign-username");
    By password = By.id("sign-password");

    By signupButton =
            By.xpath("//button[text()='Sign up']");

    public String register(String user, String pass) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(username)
        );

        driver.findElement(username).sendKeys(user);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(signupButton).click();

        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());

        String message = alert.getText();

        alert.accept();

        return message;
    }
}