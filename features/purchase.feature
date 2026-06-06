Feature: Compra de productos

  Como cliente
  Quiero comprar productos
  Para completar una compra satisfactoria

  Scenario: Compra exitosa
    Given el usuario se encuentra en la página principal
    When selecciona un producto
    And agrega el producto al carrito
    And accede al carrito
    And completa el formulario de compra
    Then debe visualizar el mensaje "Thank you for your purchase"

  Scenario: Agregar producto al carrito
    Given el usuario se encuentra en la página principal
    When selecciona un producto
    And hace clic en Add to cart
    Then debe visualizar el mensaje "Product added"