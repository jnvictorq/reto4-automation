package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By samsungGalaxy =
            By.xpath("//a[contains(text(),'Samsung galaxy s6')]");

    By addToCart =
            By.linkText("Add to cart");

    public void selectSamsungGalaxy() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        samsungGalaxy
                )
        ).click();
    }

    public String addProductToCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addToCart
                )
        ).click();

        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();

        alert.accept();

        return alertText;
    }
}
