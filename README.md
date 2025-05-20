# 🚀 Projeto Mottu - API de Gerenciamento de Motos e Galpões

Este projeto é uma API REST desenvolvida com **Java**, **Spring Boot** e **H2 Database**, com funcionalidades de CRUD para motos e galpões. A aplicação permite realizar testes diretamente pelo navegador, Postman ou H2 Console.

---

## ✅ Pré-requisitos

- Java 17+ instalado
- IDE: Eclipse 
- Maven configurado
- Postman para testes de Endpoint
- H2 para testes do Banco de Dados

---

## ▶️ Como rodar o projeto

1. **Abra o projeto na IDE.**
2. Clique com o botão direito sobre o projeto e selecione:  
   **`Maven` > `Update Project`**
3. Vá até a classe `MottuApplication.java`, clique com o botão direito e selecione:  
   **`Run As` > `Java Application`**

---

## 🌐 Testando os endpoints

Com o projeto em execução, você pode testar os endpoints pelo navegador ou Postman:

- 🔍 Listar motos:  
  [http://localhost:8080/motos](http://localhost:8080/motos)

- 🔍 Listar galpões:  
  [http://localhost:8080/galpoes](http://localhost:8080/galpoes)

---

## 🧪 Testando pelo H2 Console

Você também pode visualizar os dados diretamente no banco em memória (H2):

1. Acesse:  
   [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

2. Preencha apenas o campo **JDBC URL** com:  
