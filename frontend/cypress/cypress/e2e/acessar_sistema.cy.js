describe('Acessar sistema', () => {
    beforeEach(() => cy.visit('/'))
    
    it('Acesso ao sistema', () => {
      //verifica se ficou visivel
      cy.get('.text-4xl').should('be.visible')
    })
  })