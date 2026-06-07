import { When, Then } from "@badeball/cypress-cucumber-preprocessor";

When("selecciona un producto", () => {
  cy.get(".hrefch").first().click();
});

When("agrega el producto al carrito", () => {
  cy.on("window:alert", (text) => {
    expect(text).to.contain("Product added");
  });

  cy.get(".btn-success").click();

  cy.wait(1000);
});

When("accede al carrito", () => {
  cy.get("#cartur").click();

  cy.url().should("include", "cart");

  cy.wait(2000);
});

When("completa el formulario de compra", () => {
  cy.contains("Place Order")
    .should("be.visible")
    .click();

  cy.get("#orderModal")
    .should("be.visible");

  cy.get("#name").type("Juan");
  cy.get("#country").type("Bolivia");
  cy.get("#city").type("La Paz");
  cy.get("#card").type("123456789");
  cy.get("#month").type("12");
  cy.get("#year").type("2026");
});

When("confirma la orden", () => {
  cy.contains("Purchase")
    .should("be.visible")
    .click();
});

Then("debe visualizar el mensaje de compra exitosa", () => {
  cy.contains("Thank you for your purchase!", {
    timeout: 15000
  }).should("be.visible");
});

Then("debe visualizar el mensaje de producto agregado", () => {
  // La validación ya se realiza en el paso
  // "agrega el producto al carrito"
});