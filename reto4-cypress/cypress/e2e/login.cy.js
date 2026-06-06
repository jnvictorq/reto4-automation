import HomePage from '../pages/HomePage'
import LoginPage from '../pages/LoginPage'

describe('Login Demoblaze', () => {

    const home = new HomePage()
    const login = new LoginPage()

    it('Login exitoso', () => {

        home.visit()

        home.clickLogin()

        cy.get('#logInModal')
          .should('be.visible')

        login.login(
            'juanvictor01',
            '123456'
        )

        cy.get('#nameofuser', { timeout: 15000 })
          .should('contain.text', 'Welcome')
          .and('contain.text', 'juanvictor01')

    })

})