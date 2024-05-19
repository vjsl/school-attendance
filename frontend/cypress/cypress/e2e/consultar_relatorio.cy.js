describe('Consultar Relatório de Faltas', () => {
    beforeEach(() => cy.visit('/'))
    
    it('Consulta Relatório', () => {
      //verifica se contém o botão alunos no menu
      cy.contains('Alunos').click()
      //verifica se o relatório de faltas ficou visivel
      cy.get('.w-full').should('be.visible')
    })
  })