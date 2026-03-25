# Encurtador de URL

Projeto desenvolvido com **Java + Spring Boot + MongoDB** que permite encurtar URLs e redirecioná-las de forma simples e eficiente.

---

## 🚀 Funcionalidades

* ✅ Encurtamento de URLs
* 🔁 Redirecionamento automático
* ⏳ Expiração de links (configurável)
* 🔐 Geração de identificadores únicos

---

## 🧱 Estrutura do Projeto

```
com.victorberlinck.encurtadordeurl
│
├── controller        # Camada de controle (requisições HTTP)
├── dto               # Objetos de transferência de dados
├── entity            # Entidades do banco de dados
├── repository        # Acesso ao MongoDB
└── EncurtadordeurlApplication  # Classe principal
```

---

## 🛠️ Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data MongoDB
* MongoDB
* Apache Commons Lang

---

## ⚙️ Configuração

### 📌 application.properties

```properties
spring.application.name=encurtadordeurl

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=shortenerdb
```

---

### 🐳 Docker (MongoDB)

```yaml
services:
  mongodb:
    image: mongo
    ports:
      - "27017:27017"
```

---

## ▶️ Como rodar o projeto

### 1. Subir o MongoDB

```bash
docker-compose up -d
```

### 2. Rodar a aplicação

Via IDE ou:

```bash
./mvnw spring-boot:run
```

---

## 📡 Endpoints

### 🔹 Encurtar URL

**POST** `/shorten-url`

#### Request:

```json
{
  "url": "https://google.com"
}
```

#### Response:

```json
{
  "url": "http://localhost:8080/abc123"
}
```

---

### 🔹 Redirecionar URL

**GET** `/{id}`

Exemplo:

```
http://localhost:8080/abc123
```

➡️ Redireciona para a URL original

---

## ⚠️ Observações

* O ID gerado é aleatório (5 a 10 caracteres)
* URLs possuem tempo de expiração (atualmente configurado para 1 minuto)
* Caso o ID não exista, retorna **404 Not Found**

---


## 👨‍💻 Autor

Desenvolvido por **Victor Berlinck**
