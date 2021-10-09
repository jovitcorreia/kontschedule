# KontSchedule - Desafio Técnico

Bem vindos ao KontSchedule! O desafio para colocar tudo que vimos na Imersão Kontulari em prática.

### Introdução

A presença do contador no dia a dia das empresas é fundamental. Hoje com conceitos como **compliance** e **accountability** sendo colocados em pauta com frequência, a posição do contador vem ganhando mais relevância e tendo uma função mais estratégica indispensável dentro das organizações. Além de tratar de toda a parte de gestão contábil, o papel do contador destaca-se devido as mudanças no cenário econômico e a sofisticação do regime tributário.

Dentre as atividades exercidas pela contabilidade, algumas são:

- Acompanhar e prever a entrada e saída de recursos;
- Organizar e otimizar a gestão fiscal, tributária e orçamentária da empresa, viabilizando o seu funcionamento e o cumprimento correto de prazos e exigências;
- Comunicação ativa com os órgãos encarregados de fiscalização das atividades das empresas em todas as esferas de governo.

E claro, que com o avanço da tecnologia, a área de contabilidade também ganha recursos que facilitam muito a vida dos contadores. Nós, como desenvolvedores, assumimos esse papel de tornar a atividade contábil mais eficiente, trabalhando juntos para contornar a burocracia, agilizar os processos e com isso facilitar a gestão do ecossistema contábil das empresas.

### Descrição

Com o objetivo de melhorar os processos dentro da contabilidade, nós propomos a criação de uma Agenda de Atividades para a Contabilidade, para auxiliar o contador em todas as tarefas que precisam ser feitas para as empresas clientes dele.

No sistema, os requisitos que devem estar presentes são:

- Cadastro do contador responsável;
- Cadastro e controle de empresas clientes;
- Cadastro e controle de atividades a serem efetuadas pela contabilidade.

**Contador**: Representa o contador responsável em exercer as atividades de uma determinada empresa. Somente um contador é necessário e deve ser possível editar as suas informações.

Campos: nome, sobrenome, CPF, CRC e endereço.

**Empresa**: Representa os clientes da contabilidade. Deve ter mais de uma empresa cadastrada e também deve ser possível editar as informações da empresa, assim como cadastrar atividades variadas para cada uma das empresas.

Campos: razão social, nome fantasia, CNPJ, endereço e lista de atividades.

**Atividade**: As atividades são rotinas da contabilidade que podem ser feitas pela contabilidade (ver em atividades), cada empresa deve ter uma lista de atividades listadas para a competência (o mês em curso).

Campos: nome, descricao, setor, competência, prazo para execução, data de execução e status.

### Requisitos

Para a realização do desafio, vocês devem utilizar o Sring Boot (Java) para o desenvolvimento do back-end e o React.js (Javascript ou Typescript, se preferir) para o desenvolvimento do front-end. Para o banco de dados, podem utilizar o MySQL ou algum outro banco de dados relacional que tenham familiaridade.

### Diferenciais

**Solicitações**: Separar a lista de atividades em um catálogo fixo onde as atividades podem ser gerenciadas (criar novas, remover, editar) e adicionar um novo requisito que represente as solicitações de serviços. Cada solicitação de serviço deve ter a data da solicitação, data da execução e a atividade solicitada.

Sintam-se livres para aprimorar as regras de negócio, criar novas entidades, implementar testes, modificar a interface do aplicativo web (paleta de cor, imagens, fonte, posicionamento dos componentes), etc., mas se atentem para não sair do escopo do desafio.

### O que será avaliado

- Instruções detalhadas para execução em ambiente local do seu projeto;
- Explicação da estrutura utilizada no projeto;
- Descrição de como vocês organizaram cada etapa do desenvolvimento até a sua finalização.

### Prazo

Apresentação no domingo 10/10/2021 iniciando às 10h, no fechamento da Imersão Kontulari.

### Importante saber

**O código do projeto é seu**. Nós não utilizaremos nenhum código implementado nesse desafio técnico nos projetos da Kontulari.

**Let´s code!**
