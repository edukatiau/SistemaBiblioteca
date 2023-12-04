![](images/Aspose.Words.069049e9-7a8b-45c4-b275-f2170fc81e1a.001.png)**





**LivroTec**








**Eduardo Rigon
João Vítor Freitas Farias



Turma 2A



Disciplina: Programação Orientada a Objetos



Sapucaia do Sul, 2023**

**RESUMO** 

O "LivroTec", criado por Eduardo Rigon e João Vítor Freitas Farias, é uma solução
inovadora que tem como objetivo simplificar a administração de bibliotecas em
diversos Campi de instituições educacionais. O software permite que os funcionários
registrem, editem, listem e removam os dados dos alunos associados ao campus e
obras da biblioteca. Isso proporciona uma experiência mais eficiente para os alunos,
que podem usufruir do acervo da biblioteca para empréstimo de obras. A equipe da
biblioteca é composta pelos funcionários que têm um papel crucial na gestão do
sistema. Para uma organização mais abrangente, as obras são classificadas por
título, autor, ano de lançamento, número da edição e gênero. Os alunos podem
acessar o sistema com seu login, podendo editar seus dados, listar todos seus
empréstimos realizados e seus empréstimos que estão atrasados. Quando o aluno
for devolver alguma obra do empréstimo, o funcionário poderá atualizar o
empréstimo, se estiver tudo Ok, para “Devolvido”. Com essa abordagem, o
"LivroTec" visa otimizar o processo de empréstimo de obras nas bibliotecas,
proporcionando uma administração simplificada e uma experiência mais eficiente
para alunos e funcionários. O projeto é desenvolvido utilizando a linguagem Java,
utiliza o padrão de projeto DAO que abstrai e encapsula os mecanismos de acesso a
dados escondendo os detalhes da execução da origem dos dados e utiliza o Banco
de Dados Relacional MySQL para armazenar os dados.

































**REQUISITOS**

RF 01: Permitir que o Usuário Funcionário faça Login;
RF 02: Permitir que o Usuário Aluno faça Login;
RF 03: Permitir que o Usuário saia do Sistema;
RF 04: Permitir que o Usuário Funcionário cadastre Funcionários;
RF 05: Verificar a existência de funcionários já cadastrados - evitar duplicidade;
RF 06: Permitir que o Usuário Funcionário cadastre Campus;
RF 07: Verificar a existência de campus já cadastrados - evitar duplicidade;
RF 08: Permitir que o Usuário Funcionário cadastre Obras;
RF 09: Cadastrar Gênero caso ainda não houver;
RF 10: Permitir que o Usuário Funcionário edite Obras;
RF 10.1: Editar título da Obra;
RF 10.2: Editar autor da Obra;
RF 10.3: Editar edição da Obra;
RF 10.4: Editar ano da Obra;
RF 10.5: Editar gênero da Obra;
RF 11: Permitir que o Usuário Funcionário liste Obras;
RF 11.1: Listar todas as Obras;
RF 11.2: Listar Obras por gênero;
RF 11.3: Listar Obras por título;
RF 11.4: Listar Obras por autor;
RF 11.5: Listar Obras por ano;
RF 12: Permitir que o Usuário Funcionário delete Obras;
RF 13: Permitir que o Usuário Funcionário cadastre Alunos;
RF 14: Verificar a existência de alunos já cadastrados - evitar duplicidade;
RF 15: Permitir que o Usuário Funcionário edite Alunos;
RF 15.1: Editar nome do Aluno;
RF 15.2: Editar matrícula do Aluno;
RF 15.3: Editar curso do Aluno;
RF 16: Permitir que o Usuário Funcionário liste Alunos;
RF 16.1: Listar todos os Alunos;
RF 16.2: Listar alunos por nome;
RF 16.3: Listar alunos por curso;
RF 17: Permitir que o Usuário Funcionário delete Alunos;
RF 18: Permitir que o Usuário Funcionário gerencie Empréstimos;
RF 18.1: Emprestar Obras;
RF 18.2: Devolução de Obras;
RF 18.3: Listar Empréstimos;
RF 18.4: Listar Empréstimos atrasados;
RF 19: Permitir que o Usuário Aluno gerencie seu perfil;
RF 19.1: Editar email do Aluno;
RF 19.2: Editar senha do Aluno;
RF 20: Permitir que o Usuário Aluno liste seus Empréstimos;
RF 20.1: Listar Empréstimos atrasados do Aluno;



















**Modelo Conceitual:**

![](images/Aspose.Words.069049e9-7a8b-45c4-b275-f2170fc81e1a.002.png)
