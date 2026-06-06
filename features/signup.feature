Feature: Registro de usuarios

  Como visitante
  Quiero registrarme en la plataforma
  Para poder iniciar sesión posteriormente

  Scenario: Registro exitoso
    Given el usuario se encuentra en la página principal
    When selecciona la opción Sign up
    And ingresa un nuevo usuario
    And ingresa una contraseña válida
    And presiona el botón Sign up
    Then debe visualizar el mensaje "Sign up successful"

  Scenario: Registro de usuario existente
    Given el usuario se encuentra en la página principal
    When selecciona la opción Sign up
    And ingresa un usuario ya registrado
    And presiona el botón Sign up
    Then debe visualizar el mensaje "This user already exist"