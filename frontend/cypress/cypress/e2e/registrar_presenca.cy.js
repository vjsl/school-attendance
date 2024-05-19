describe('Realiza uma chamada completa', () => {
  it('passes', () => {
    cy.visit('http://localhost:3000')
    cy.get(':nth-child(2) > .flex > .flex-1').click()
    cy.get('.bg-blue-500').click()
    // Clica no botão de registrar presença 'SIM'
    cy.get('.bg-green-500').click()
    // Clica no botão de registrar presença 'NÃO'
    cy.get('.bg-red-500').click()
  })
})
