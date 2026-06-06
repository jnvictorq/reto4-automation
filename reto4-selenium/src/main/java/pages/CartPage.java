package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartButton = By.id("cartur");

    public void openCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(cartButton)
        ).click();
    }

    public boolean productExists(String product) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(),'" + product + "')]")
                    )
            );

            return true;

        } catch (Exception e) {

            return false;

        }
    }

    By deleteLink =
            By.linkText("Delete");

    public void deleteProduct() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(deleteLink)
        ).click();
    }

    public boolean isCartEmpty() {

        try {

            driver.findElement(
                    By.xpath("//*[contains(text(),'Samsung galaxy s6')]")
            );

            return false;

        } catch (Exception e) {

            return true;

        }
    }
}