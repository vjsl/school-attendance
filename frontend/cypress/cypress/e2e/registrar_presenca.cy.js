describe('Registrar presença', () => {
  beforeEach(() => cy.visit('/'))

  it('Registrar presença do aluno presente', () => {
    //clica no menu chamada
    cy.get(':nth-child(2) > .flex > .flex-1').click()
    // clica no periodo 
    cy.get('.bg-blue-500').click()
    // Clica no botão de registrar presença 'SIM'
    cy.get('.bg-green-500').click()
  })

  it('Registrar presença do aluno ausente', () => {
    //clica no menu chamada
    cy.get(':nth-child(2) > .flex > .flex-1').click()
    // clica no periodo 
    cy.get('.bg-blue-500').click()
    // Clica no botão de registrar presença 'NÃO'
    cy.get('.bg-red-500').click()
  })

})
