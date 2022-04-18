# :clipboard: **Projeto da Disciplina:**

### :one: Descrição
Implementar e documentar uma aplicação desktop para gerenciar as notas e historico de alunos e as disciplinas de professores. A aplicação deverá armazenar os dados em um SGBD, local ou remoto. Deve possuir três tipos de perfil: Aluno, Professor e Administrador, cada um com suas funcionalidades específicas.

### :two: Instruções

• A aplicação deve dispor de interface gráfica;

• Os dados da aplicação devem ser armazenados em um banco de dados relacional;

• A base de código deve estar disponível em um repositório Git;

• Além da aplicação, a seguinte documentação dever ́a ser entregue:

>  Documento de requisitos, contendo a análise dos requisitos, as regras de negócio extraídas, modelo de armazenamento (entidades e relacionamento), diagramas de classe e sequência, mockups;

>  Documento de casos de uso, especificando cada caso de uso com seus atores, objetivos, requisitos, criticalidade, pré condições, pós condições, entradas, saídas, fluxos principais, fluxos alternativos;

>  Plano de riscos, identificando possíveis riscos positivos e negativos, seus impactos, probabilidade de ocorrência e estratégia de resposta;

>  Documentação da aplicação, em formato de manual para usuário leigo;

>  Documentação da aplicação em formato API (Referência: Javadoc, Doxygen);

>  Plano de teste, identificando estratégias de verificação e validação para os casos de uso, objetivos, tipos de teste e critérios de aceitação;

>  Plano de implantação, especificando instruções para instalação, recursos e que artefatos e suporte estarão disponíveis para os usuários.

### :three: Requisitos

• O usuário deve ser identificado unicamente ao iniciar a aplicação

• Funcionalidades indisponíveis ao usuário devem ser ocultas

• Funcionalidades disponíveis ao aluno:

>  Se matricular em disciplinas quando a matrícula estiver liberada;

>  Ver seu horário composto pelas disciplinas;

>  Ver suas notas nas disciplinas matriculadas;

>  Ver suas notas em disciplinas cursadas anteriormente;

>  Ver sua situação em cada disciplina (Aprovado ou Reprovado).

• Funcionalidades disponíveis ao professor:

>  Escolher as disciplinas a serem ministradas;

>  Inserir ou alterar notas de alunos enquanto a disciplina não for fechada;

>  Encerrar uma disciplina;

>  Ver seu horário composto pelas disciplinas.

• Funcionalidades disponíveis ao administrador:

>  Cadastrar novos professores;

>  Cadastrar novos alunos;

>  Abrir período de matrícula;

>  Encerrar semestre;

>  E todas as outras funcionalidades de professor.

### :four: Restrições

• O banco de dados utilizado deve ser relacional;

• Não deve ser utilizado nenhuma ferramenta ou biblioteca de ORM.


## :key: **Informações necessárias para testes atuais:**

:closed_lock_with_key: Login/Senha Coordenador: 10000/1234

## :eyes: **Pré Visualização:**

![login](https://user-images.githubusercontent.com/60760405/163730757-4c601dbb-8edf-4633-8a13-ae8503f47732.png)
![load](https://user-images.githubusercontent.com/60760405/163730756-8d43cf1e-dd6a-4d47-8ec1-c983b0f501a1.png)
![admin](https://user-images.githubusercontent.com/60760405/163749569-2700bf9b-7d55-4ddd-b1b6-17170b91294c.png)



