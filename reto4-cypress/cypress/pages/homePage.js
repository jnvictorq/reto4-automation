class HomePage {

    visit() {
        cy.visit('https://www.demoblaze.com')
    }

    clickLogin() {
        cy.get('#login2').click()
    }

    selectProduct() {
        cy.contains('Samsung galaxy s6').click()
    }
}

export default HomePage