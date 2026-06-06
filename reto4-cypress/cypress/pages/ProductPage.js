class ProductPage {

    selectProduct(productName) {
        cy.contains(productName).click()
    }

    addToCart() {
        cy.contains('Add to cart').click()
    }

    validateProductAdded() {
        cy.on('window:alert', (text) => {
            expect(text).to.contains('Product added')
        })
    }
}

export default ProductPage