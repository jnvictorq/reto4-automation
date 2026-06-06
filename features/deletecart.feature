Feature: Gestión del carrito

  Como usuario
  Quiero administrar los productos de mi carrito
  Para mantener actualizada mi compra

  Scenario: Eliminar producto del carrito
    Given el usuario tiene un producto agregado al carrito
    When accede al carrito
    And elimina el producto
    Then el carrito debe quedar vacío

  Scenario: Visualizar productos en el carrito
    Given el usuario tiene productos agregados al carrito
    When accede al carrito
    Then debe visualizar el listado de productos agregados