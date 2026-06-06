package tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import utils.DriverFactory;

public class AddToCartTest {

    @Test
    public void addProduct() {

        WebDriver driver =
                DriverFactory.getDriver();

        try {

            HomePage home =
                    new HomePage(driver);

            ProductPage product =
                    new ProductPage(driver);

            CartPage cart =
                    new CartPage(driver);

            home.open();

            product.selectSamsungGalaxy();

            String message =
                    product.addProductToCart();

            Assert.assertEquals(
                    message,
                    "Product added"
            );

            cart.openCart();

            Assert.assertTrue(
                    cart.productExists(
                            "Samsung galaxy s6"
                    )
            );

        } finally {

            driver.quit();

        }
    }
}
