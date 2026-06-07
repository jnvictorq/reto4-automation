import { When, Then } from "@badeball/cypress-cucumber-preprocessor";

When("selecciona un producto", () => {
  cy.get(".hrefch").first().click();
});

When("agrega el producto al carrito", () => {
  cy.get(".btn-success").click();
});

When("accede al carrito", () => {
  cy.get("#cartur").click();
});

When("completa el formulario de compra", () => {
  cy.get(".btn-success").click(); // abrir modal

  cy.get("#orderModal").should("be.visible");

  cy.get("#name").type("Juan");
  cy.get("#country").type("Bolivia");
  cy.get("#city").type("La Paz");
  cy.get("#card").type("123456789");
  cy.get("#month").type("12");
  cy.get("#year").type("2026");
});

When("confirma la orden", () => {
  cy.contains("Purchase").click();
});

Then("debe visualizar el mensaje de compra exitosa", () => {
  cy.get(".sweet-alert").should("be.visible");
  cy.contains("Thank you").should("exist");
});

Then("debe visualizar el mensaje de producto agregado", () => {
  cy.on("window:alert", (text) => {
    expect(text).to.contain("Product added");
  });
});