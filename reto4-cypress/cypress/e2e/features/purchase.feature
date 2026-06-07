Feature: Compra de productos

  Como cliente
  Quiero comprar productos
  Para completar una compra satisfactoria

  Scenario: Agregar producto al carrito
    Given el usuario se encuentra en la página principal
    When selecciona un producto
    And agrega el producto al carrito
    Then debe visualizar el mensaje de producto agregado

  Scenario: Compra exitosa
    Given el usuario se encuentra en la página principal
    When selecciona un producto
    And agrega el producto al carrito
    And accede al carrito
    And completa el formulario de compra
    And confirma la orden
    Then debe visualizar el mensaje de compra exitosa
