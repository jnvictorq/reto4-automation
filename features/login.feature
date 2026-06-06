Feature: Inicio de sesión

  Como usuario registrado
  Quiero iniciar sesión
  Para acceder a las funcionalidades de compra

  Scenario: Login exitoso
    Given el usuario se encuentra en la página principal
    When selecciona la opción Login
    And ingresa un usuario y contraseña válidos
    And presiona el botón Log in
    Then debe visualizar el mensaje de bienvenida

  Scenario: Login con credenciales inválidas
    Given el usuario se encuentra en la página principal
    When selecciona la opción Login
    And ingresa credenciales incorrectas
    And presiona el botón Log in
    Then debe visualizar un mensaje de error