# KontSchedule

CRUD de Contabilidade com Spring Boot e React para o Desafio Técnico da Kontulari.

## Instalação

Clone o projeto rodando:

```bash
git clone https://github.com/castanhocorreia/KontSchedule.git
```

Acesse o diretório `server` e rode o comando:

```bash
mvn install
```

A fim de instalar as dependências do Spring Boot e garantir que o processo de build está funcionando devidamente.

Em seguida, acesse o diretório `client`e rode o comando:

```bash
yarn install
```

Para instalar as dependências do Node.js.

E então você poderá subir o servidor backend, dentro do diretório `server`, rodando o seguinte comando no terminal:

```bash
mvn spring-boot:run
```

Isso fará com o servidor Tomcat embarcado na aplicação do Spring Boot rode na porta 8080 em seu localhost.

Com o backend de pé, será necessário popular o banco de dados H2 com inforamações iniciais. Se tiver o Imnsomnia instalado você poderá importar o arquivo `Insomnia.json` localizado à raiz deste projeto para facilitar este processo.

A recomendação é rodar primeiramente a requisição `Cadastra Contador`, depois as duas requisições de cadastrar empresas e, por fim, as de cadastrar atividades, para garantir que os relacionamentos entre as tabelas ocorra sem problemas.

Por fim, usando outro terminal, no diretório `client` suba o frontend com o comando:

```bash
yarn start
```

## Licença

[MIT](https://choosealicense.com/licenses/mit/)
