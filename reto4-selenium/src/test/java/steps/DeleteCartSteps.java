package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class DeleteCartSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage home = new HomePage(driver);
    ProductPage product = new ProductPage(driver);
    CartPage cart = new CartPage(driver);

    @Given("el usuario tiene un producto agregado al carrito")
    public void usuarioConProductoEnCarrito() {
        home.open();
        product.selectSamsungGalaxy();
        product.addProductToCart();
    }

    @When("accede al carrito")
    public void accedeAlCarrito() {
        cart.openCart();
    }

    @And("elimina el producto")
    public void eliminaProducto() {
        cart.deleteProduct();
    }

    @Then("el carrito debe quedar vacío")
    public void carritoDebeQuedarVacio() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(cart.isCartEmpty());
        driver.quit();
    }
}
