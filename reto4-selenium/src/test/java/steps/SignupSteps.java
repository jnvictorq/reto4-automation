package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.HomePage;
import pages.SignupPage;
import utils.DriverFactory;

public class SignupSteps {

    private WebDriver driver;
    private HomePage home;
    private SignupPage signup;

    private String alertMessage;

    @Given("el usuario se encuentra en la página principal")
    public void usuarioEnPaginaPrincipal() {

        driver = DriverFactory.getDriver();

        home = new HomePage(driver);
        signup = new SignupPage(driver);

        home.open();
    }

    @When("selecciona la opción Sign up")
    public void seleccionaSignUp() {
        home.clickSignUp();
    }

    @And("ingresa un nuevo usuario")
    public void ingresaNuevoUsuario() {
        String usuario = "usuario_nuevo_" + System.currentTimeMillis();
        alertMessage = signup.register(usuario, "Password123");
    }

    @And("ingresa un usuario ya registrado")
    public void ingresaUsuarioExistente() {
        alertMessage = signup.register("juanvictor01", "123456");
    }

    @Then("debe visualizar el mensaje {string}")
    public void validarMensaje(String mensajeEsperado) {

        Assert.assertTrue(
                alertMessage.contains(mensajeEsperado),
                "Mensaje recibido: " + alertMessage
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}