Feature: Gestión del carrito
  Scenario: Eliminar producto del carrito
    Given el usuario tiene un producto agregado al carrito
    When accede al carrito
    And elimina el producto
    Then el carrito debe quedar vacío
