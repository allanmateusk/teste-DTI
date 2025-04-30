
# 🎓 Sistema de Controle de Alunos - Full Stack (React + Spring Boot)

Sistema web completo para controle de notas e frequência de alunos, com funcionalidades de cadastro, cálculo de médias e geração de relatórios personalizados.

---

## 📚 Objetivo

Carlos é um professor que precisa organizar as notas e a frequência dos seus alunos. Este sistema foi desenvolvido para ajudá-lo a:

- Cadastrar alunos com nome, 5 notas e frequência (%);
- Calcular a média individual de cada aluno;
- Calcular a média da turma por disciplina;
- Identificar alunos que precisam de atenção:
  - Média abaixo da média da turma;
  - Frequência abaixo de 75%;
- Exibir relatórios formatados conforme solicitado.

---

## ⚙️ Tecnologias Utilizadas

### 🔹 Front-end

- React
- TypeScript
- Vite
- Axios
- CSS

### 🔸 Back-end

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (em memória)
- Maven

---

## ▶️ Como Rodar o Projeto (Passo a Passo)

### 1. Clone o repositório

```bash
git clone https://github.com/allanmateusk/teste-DTI.git
cd teste-DTI
```

### 2. Rodar o Backend (Spring Boot)

```bash
cd teste-dti
./mvnw spring-boot:run
```

Acesse a API em: [http://localhost:8080](http://localhost:8080)  
Console do banco (H2): [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> A conexão H2 usa: `jdbc:h2:mem:testdb`

### 3. Rodar o Frontend (React + Vite)

Abra outro terminal e execute:

```bash
cd front-teste-dti
npm install        # ou: yarn install
npm run dev        # ou: yarn dev
```

O sistema estará acessível em: [http://localhost:5173](http://localhost:5173)

---

## 📡 Endpoints da API

| Método | Endpoint                        | Descrição                                      |
|--------|----------------------------------|------------------------------------------------|
| POST   | `/api/estudantes`               | Cadastrar aluno                                |
| GET    | `/api/estudantes`               | Listar alunos                                  |
| GET    | `/api/estudantes/saida`         | Relatório formatado com notas e frequência     |
| GET    | `/api/estudantes/medias`        | Média por disciplina                           |
| GET    | `/api/estudantes/relatorios`    | Alunos com média alta ou frequência baixa      |
| GET    | `/api/estudantes/frequencia-baixa` | Lista de alunos com frequência < 75%         |

---

## 🧠 Funcionalidades da Interface

- Formulário para cadastro de alunos
- Lista com resultados gerais formatados
- Cards para destacar alunos com frequência ou média crítica
- Estilo com tema escuro e responsivo

---

## 📁 Estrutura

```
/teste-dti            # backend Spring Boot
/front-teste-dti      # frontend React + Vite
```

---

## 🔒 Validações

- Notas limitadas entre 0 e 10 (front e back)
- Frequência limitada entre 0 e 100%
- Regra de negócio aplicada no backend

---

## 🧑 Autor

Desenvolvido por **Allan Mateus**  
GitHub: [allanmateusk](https://github.com/allanmateusk)

---

## 🧪 Observação

Este projeto foi desenvolvido como parte de um teste técnico e não possui fins comerciais. Para ambiente de produção, recomenda-se uso de banco persistente e autenticação de usuários.
