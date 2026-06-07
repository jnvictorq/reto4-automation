const { defineConfig } = require("cypress");
const allureWriter = require("@shelex/cypress-allure-plugin/writer");
const createBundler = require("@bahmutov/cypress-esbuild-preprocessor");
const { addCucumberPreprocessorPlugin } = require("@badeball/cypress-cucumber-preprocessor");
const { createEsbuildPlugin } = require("@badeball/cypress-cucumber-preprocessor/esbuild");

module.exports = defineConfig({
  reporter: "mochawesome",
  reporterOptions: {
    reportDir: "cypress/reports",
    overwrite: false,
    html: true,
    json: true,
  },
  video: true,
  screenshotOnRunFailure: true,

  allowCypressEnv: true,

  e2e: {
    async setupNodeEvents(on, config) {
      
      allureWriter(on, config);

      await addCucumberPreprocessorPlugin(on, config);

      on("file:preprocessor", createBundler({
        plugins: [createEsbuildPlugin(config)],
      }));

      config.specPattern = "cypress/e2e/features/**/*.feature";
      config.excludeSpecPattern = ["**/*.cy.js"];

      return config;
    },
    specPattern: "cypress/e2e/features/**/*.feature",
    baseUrl: "https://www.demoblaze.com",
  },
});
