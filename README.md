# Registro de Presença Escolar

Este é um projeto web desenvolvido em Java para registro de presença escolar. Ele permite que os professores registrem a presença dos alunos em suas aulas de forma fácil e eficiente.

## Funcionalidades

- **Registro de Presença:** Os professores podem marcar a presença dos alunos em cada aula.
- **Visualização de Presença:** Os professores podem visualizar um histórico da presença de cada aluno ao longo do tempo.

## Requisitos

- Java JDK 21
- NodeJS LTS
- Banco de dados MySQL (ou outro suportado pelo Hibernate)

## Como Executar

1. Clone este repositório para o seu ambiente local.

   ``git clone https://github.com/vjsl/school-attendance.git``

2. Navegue até o diretório do projeto.

   ``cd backend``

3. Execute o projeto de backend.

   ``gradlew bootRun``

4. Abra uma nova aba do terminal e navegue até a pasta do frontend

5. Instale as dependências do NodeJS usando o comando:

   ``npm install``

6. Inicie o frontend:

   ``npm run dev``

7. Abra o navegador no endereço http://localhost:3000 

## Configuração do Banco de Dados
Por padrão, o projeto está configurado para usar um banco de dados MySQL. Certifique-se de configurar corretamente o arquivo *application.properties* com as credenciais do seu banco de dados.

`spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect`

Se desejar usar outro banco de dados suportado pelo Hibernate, atualize a URL do datasource e o dialeto do Hibernate conforme necessário.

## Contribuindo
Sinta-se à vontade para contribuir com este projeto. Você pode reportar problemas, sugerir novas funcionalidades ou enviar solicitações de pull requests.

Desenvolvido por: Academic Titans
