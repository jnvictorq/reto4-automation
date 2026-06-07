📌 Reto 4 – Automatización E2E (Selenium + Cypress + Jenkins)
📍 Proyecto de Automatización

Automatización de pruebas End-to-End sobre la aplicación:

👉 https://www.demoblaze.com/index.html

🧪 Ejecución de pruebas
▶ Selenium

mvn clean test

▶ Cypress

npx cypress run

🎯 Tecnologías utilizadas
Selenium WebDriver
Java 17+
TestNG
Maven
Cypress
Node.js
Jenkins (CI/CD)
Page Object Model (POM)
Extent Reports
Mochawesome Reports

⚙️ Requisitos del entorno
🧩 Instalaciones obligatorias
✔ Java
Java 17 o superior
Verificación:

java -version

✔ Maven
Verificación:

mvn -version

✔ Node.js
Versión recomendada: LTS (18+)
Verificación:

node -v
npm -v

✔ Cypress instalación global/local

npm install cypress --save-dev

⚙️ Dependencias Cypress
📦 Inicializar proyecto

npm init -y
npm install cypress --save-dev

📊 Mochawesome Reporter

npm install mochawesome mochawesome-merge mochawesome-report-generator --save-dev

📊 Evidencias generadas
📌 Selenium
Extent Report HTML
Screenshots en fallos
reports/ExtentReport.html
screenshots/*.png

📌 Cypress
Videos automáticos
Screenshots automáticos
Reporte Mochawesome HTML
cypress/videos/
cypress/screenshots/
cypress/reports/