# GCS-2022-Trab1
Repositório para o primeiro trabalho da disciplina de Gerenciamento de Config. de Software 2022-2

COMANDOS: PARA CLONAR REPOSITÓRIO:

copiar o link do repositorio

git clone (link do repositorio)

PARA MUDAR DE BRANCH: git checkout -b (nome da branch)

PARA ENVIAR O QUE PRECISA PARA A SUA BRANCH: git add . git commit -m "(oq fez): (mensagem)" (oq fez) = feat | fix git push origin (nome da branch)

PARA PUXAR AS MUDANÇAS QUE FORAM ADICIONADAS:

git pull origin main

NOMES: LUCCA TISSER PARADEDA -- correção de bugs e ajustes JOÃO VITOR SCHWINGEL -- 8 LUCCA MAZZOCCATO -- 5 CONRADO CRESTANI -- 3 LEONARDO SABINO -- 1 LEONARDO CARVALHOH -- 7 NICHOLAS SPOLTI -- 6 GUSTAVO PASQUALI -- 4 JOÃO VITOR MORANDI -- 2 RAFAEL FERNANDO -- 9

1-O sistema deverá permitir escolher o usuário atual a qualquer momento. Cada usuário tem um identificador, um nome e o seu tipo: médico, paciente ou administrador.
2-O sistema deverá permitir a um médico incluir uma nova autorização de exame (não é necessário implementar edição ou exclusão). Cada autorização de exame tem um código numérico sequencial, uma data de cadastro, o médico solicitante, o paciente e o exame solicitado (ex. RaioX, Tomografia etc). Cada autorização permite apenas 1 exame. a) Todos os campos devem ser preenchidos via seleção (textual ou visual) e não via digitação de texto puro (ou seja, tecnicamente devem se referir aos objetos em memória e não ser apenas texto puro). b) A lista de exames é fixa e deve conter pelo menos 10 tipos diferentes.
3-O sistema deverá permitir a um médico listar todas as autorizações de exame filtrando por paciente ou por tipo de exame. Listar sempre ordenado pela data.
4-O sistema deverá permitir a um paciente marcar um exame como realizado, adicionando a data em que foi realizado. a) O sistema não deve permitir essa operação se a data informada for anterior à da solicitação ou for posterior a 30 dias da solicitação.
5-O sistema deverá permitir a um paciente listar as suas autorizações de exame, ordenadas pela data.
6-O sistema deverá permitir a um administrador incluir um novo usuário (médico, paciente ou outro administrador).
7-O sistema deverá permitir ao administrador buscar um médico ou paciente por parte de seu nome e listar as autorizações daquele usuário.
8-O sistema deverá permitir ao administrador ver estatísticas gerais contendo: a) Número de médicos ### b) Número de pacientes ### c) Número de autorizações emitidas d) Percentual de autorizações com exames já realizados
9-Duas funcionalidades a mais, à escolha do grupo.
