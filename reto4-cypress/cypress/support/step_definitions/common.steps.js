import { Given } from "@badeball/cypress-cucumber-preprocessor";

Given("el usuario se encuentra en la página principal", () => {
  cy.visit("https://www.demoblaze.com/index.html");
});