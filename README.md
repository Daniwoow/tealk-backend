# Tealk — Backend API 🚀

> Rede social acolhedora onde as conexões são baseadas em interesses reais, sem pressão social.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

---

## 💡 Sobre o projeto

O **Tealk** é uma rede social pensada para pessoas que querem se conectar de verdade — sem algoritmos de engajamento, sem pressão por likes e sem aquela ansiedade de ter que responder tudo na hora.

A ideia é simples: você escolhe seus interesses, o sistema sugere pessoas com gostos parecidos, e você se conecta no seu próprio ritmo.

Este repositório contém o **back-end** da aplicação, desenvolvido com Java e Spring Boot.

---

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 3.5**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Lombok**
- **Maven**

---

## ⚙️ Como rodar localmente

### Pré-requisitos

- Java 21+
- MySQL rodando na porta 3306
- Maven

### Passo a passo

**1. Clone o repositório**
```bash
git clone https://github.com/Daniwoow/tealk-backend.git
cd tealk-backend
```

**2. Crie o banco de dados**
```sql
CREATE DATABASE tealk;
```

**3. Configure o `application.yml`**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/tealk
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

**4. Rode o projeto**
```bash
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 📡 Endpoints da API

### Usuários
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/usuarios` | Cadastrar usuário |
| GET | `/usuarios` | Listar todos os usuários |
| GET | `/usuarios/buscar-email?email=` | Buscar por email |
| PUT | `/usuarios/{id}` | Atualizar usuário |
| DELETE | `/usuarios/{id}` | Deletar usuário |

### Interesses
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/interesses` | Cadastrar interesse |
| GET | `/interesses` | Listar todos os interesses |
| DELETE | `/interesses/{id}` | Deletar interesse |

### Conexões
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/conexoes` | Enviar pedido de conexão |
| GET | `/conexoes` | Listar todas as conexões |
| DELETE | `/conexoes/{id}` | Deletar conexão |

### Mensagens
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/mensagens` | Enviar mensagem |
| GET | `/mensagens` | Listar todas as mensagens |
| DELETE | `/mensagens/{id}` | Deletar mensagem |

---

## 🗂️ Estrutura do projeto

```
src/
└── main/
    └── java/br/com/tealk/
        ├── controller/   → endpoints da API
        ├── service/      → regras de negócio
        ├── repository/   → acesso ao banco de dados
        ├── model/        → entidades JPA
        └── dto/          → objetos de transferência de dados
```

---

## 🔜 Próximos passos

- [ ] Autenticação com Spring Security e JWT
- [ ] Validações com Bean Validation
- [ ] Entidade de Postagens com feed
- [ ] Curtidas e comentários
- [ ] Documentação com Swagger
- [ ] Deploy na nuvem

---

## 👨‍💻 Autor

Feito com muito carinho e vontade de aprender por **Daniel Cruz**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/danielcruz13)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Daniwoow)
