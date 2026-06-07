package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SignupPage;
import utils.DriverFactory;

public class SignupSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage home = new HomePage(driver);
    SignupPage signup = new SignupPage(driver);

    String alertMessage;

    @Given("el usuario se encuentra en la página principal")
    public void usuarioEnPaginaPrincipal() {
        home.open();
    }

    @When("selecciona la opción Sign up")
    public void seleccionaSignUp() {
        home.clickSignUp();
    }

    @And("ingresa un nuevo usuario")
    public void ingresaNuevoUsuario() {
        alertMessage = signup.register("usuario_nuevo_" + System.currentTimeMillis(), "Password123");
    }

    @Then("debe visualizar el mensaje \"Sign up successful\"")
    public void validarRegistroExitoso() {
        // Usamos contains para ignorar el punto final
        Assert.assertTrue(alertMessage.contains("Sign up successful"));
        driver.quit();
    }

    @And("ingresa un usuario ya registrado")
    public void ingresaUsuarioExistente() {
        alertMessage = signup.register("juanvictor01", "123456");
    }

    @Then("debe visualizar el mensaje \"This user already exist\"")
    public void validarUsuarioExistente() {
        Assert.assertTrue(alertMessage.contains("This user already exist"));
        driver.quit();
    }
}
