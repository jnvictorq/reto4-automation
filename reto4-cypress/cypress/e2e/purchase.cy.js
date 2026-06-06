import HomePage from '../pages/HomePage'
import ProductPage from '../pages/ProductPage'
import CartPage from '../pages/CartPage'

describe('Proceso de Compra', () => {

    const home = new HomePage()
    const product = new ProductPage()
    const cart = new CartPage()

    it('Compra exitosa de un producto', () => {

        home.visit()

        product.selectProduct('Samsung galaxy s6')

        product.validateProductAdded()

        product.addToCart()

        cart.openCart()

        cart.placeOrder()

        cart.completePurchase(
            'Juan',
            'Bolivia',
            'La Paz',
            '123456789',
            '06',
            '2026'
        )

        cart.validatePurchaseSuccess()

    })

})