class LoginPage {

    login(user, pass) {

        cy.get('#loginusername').clear().type(user)

        cy.get('#loginpassword').clear().type(pass)

        cy.get('#logInModal')
          .contains('button', 'Log in')
          .click()
    }
}

export default LoginPage