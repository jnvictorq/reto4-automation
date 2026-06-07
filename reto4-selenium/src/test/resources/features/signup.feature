Feature: Registro de usuarios
  Scenario: Registro exitoso
  Given el usuario se encuentra en la página principal
  When selecciona la opción Sign up
  And ingresa un nuevo usuario
  Then debe visualizar el mensaje "Sign up successful"

  Scenario: Registro de usuario existente
  Given el usuario se encuentra en la página principal
  When selecciona la opción Sign up
  And ingresa un usuario ya registrado
  Then debe visualizar el mensaje "This user already exist"