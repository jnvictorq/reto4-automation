import { When, Then } from "@badeball/cypress-cucumber-preprocessor";

When("selecciona la opción Login", () => {
  cy.get("#login2").click();
});

When("ingresa un usuario y contraseña válidos", () => {
  cy.get("#loginusername").type("juanvictor01");
  cy.get("#loginpassword").type("123456");
});

When("presiona el botón Log in", () => {
  cy.get("button[onclick='logIn()']").click();
});

Then("debe visualizar el mensaje de bienvenida", () => {
  cy.on("window:alert", (text) => {
    expect(text).to.contain("Welcome");
  });
});

When("ingresa credenciales incorrectas", () => {
  cy.get("#loginusername").type("usuario_malo");
  cy.get("#loginpassword").type("clave_mala");
});

Then("debe visualizar un mensaje de error", () => {
  cy.on("window:alert", (text) => {
    expect(text).to.contain("Wrong password");
  });
});