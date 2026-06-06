package tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import utils.DriverFactory;

public class DeleteCartTest extends BaseTest {

    @Test
    public void deleteProductFromCart() {

        driver =
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

            product.addProductToCart();

            cart.openCart();

            cart.deleteProduct();

            Thread.sleep(3000);

            Assert.assertTrue(
                    cart.isCartEmpty()
            );

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.quit();

        }
    }
}