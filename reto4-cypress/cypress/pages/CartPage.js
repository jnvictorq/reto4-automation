class CartPage {

    openCart() {
        cy.contains('Cart').click()
    }

    placeOrder() {
        cy.contains('Place Order').click()
    }

    completePurchase(name, country, city, card, month, year) {

        cy.get('#name').type(name)

        cy.get('#country').type(country)

        cy.get('#city').type(city)

        cy.get('#card').type(card)

        cy.get('#month').type(month)

        cy.get('#year').type(year)

        cy.contains('Purchase').click()
    }

    validatePurchaseSuccess() {
        cy.contains('Thank you for your purchase')
          .should('be.visible')
    }
}

export default CartPage