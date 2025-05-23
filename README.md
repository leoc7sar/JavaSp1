# 🚀 Projeto Mottu - API de Gerenciamento de Motos e Galpões

---

## 👥 Integrantes do Projeto

- **Leonardo Cesar** – RM558373  
- **Rodrigo Mantovanello** – RM555451  
- **Gustavo Camargo** – RM555562

---

# 📦 Projeto Mottu - Sistema de Gerenciamento de Motos e Galpões

## 💡 Sobre a Solução

Este projeto propõe uma **solução inovadora para a organização e controle da frota de motos**, com foco em melhorar a eficiência e evitar gargalos logísticos.

A aplicação oferece:

- 📋 **Cadastro completo das motos**: permite o controle detalhado da frota, com informações sobre status e disponibilidade.
- 🏢 **Gerenciamento de galpões**: evita **superlotação** ao distribuir as motos de forma inteligente entre os espaços disponíveis.

Com isso, o sistema garante uma **logística mais eficiente**, melhor **tomada de decisões operacionais** e **redução de erros** no gerenciamento diário de veículos.

Desenvolvido com **Java** e **Spring Boot**, o sistema expõe uma API REST pronta para ser consumida por plataformas externas ou ferramentas como Postman e navegadores.

Este projeto é uma API REST desenvolvida com **Java**, **Spring Boot** e **H2 Database**, com funcionalidades de CRUD para motos e galpões. A aplicação permite realizar testes diretamente pelo navegador, Postman ou H2 Console.

A ideia inovadora se baseia no controle da entrada de motos nos galpoes, para melhor organizaçao, evitando superlotação e desorganizaçãp.

---

## ✅ Pré-requisitos

- Java 17+ instalado
- IDE: Eclipse 
- Maven configurado
- Postman para testes de Endpoint
- H2 para testes do Banco de Dados

---

## ▶️ Como rodar o projeto

1. **Abra o projeto no ECLIPSE.**
2. Clique com o botão direito sobre o projeto e selecione:  
   **`Maven` > `Update Project`**
3. Vá até a classe `MottuApplication.java`, clique com o botão direito e selecione:  
   **`Run As` > `Java Application`**

---

## 🌐 Testando os endpoints

Com o projeto em execução, você pode testar os endpoints pelo navegador ou Postman:

1. Acesse o H2 para testar a funcionalidade dastabelas motos e galpoes (abaixo colocarei codigos prontos completos para testar a aplicaçao):
 Preencha apenas o campo **JDBC URL** com:  jdbc:h2:mem:testdb
   [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

   ****

// De SELECT para ver as tabelas de forma atualizada
SELECT * FROM GALPOES
SELECT * FROM MOTOS
 
// Caso existam itens dentro da tabela delete-as para evitar erros, se ja estiver vazia nao precisa
DELETE FROM MOTOS;
DELETE FROM GALPOES;
//comece inserindo uma moto sem galpao para evitar erros
INSERT INTO MOTOS (id, disponibilidade, modelo, placa) VALUES (1, TRUE, 'Yamaha MT-07', 'ABC1234');
// ADICIONE MOTOS NA TABELA GALPAO PARA EVITAR ERROS
ALTER TABLE GALPOES ADD COLUMN motos INT;

 
// INSERTS para inserir os galpoes MOTTU
INSERT INTO GALPOES (id, nome, endereco, motos) VALUES (1, 'Galpão Norte', 'Avenida Brasil, 456 - Rio de Janeiro, RJ', 278);
INSERT INTO GALPOES (id, nome, endereco, motos) VALUES (2, 'Galpão Sul', 'Rua do Comércio, 789 - Porto Alegre, RS', 349);
INSERT INTO GALPOES (id, nome, endereco, motos) VALUES (3, 'Galpão Leste', 'Praça da Liberdade, 101 - Belo Horizonte, MG', 112);
INSERT INTO GALPOES (id, nome, endereco, motos) VALUES (4, 'Galpão Oeste', 'Rua XV de Novembro, 202 - Curitiba, PR', 463);
INSERT INTO GALPOES (id, nome, endereco, motos) VALUES (5, 'Galpão Expansão', 'Avenida Amazonas, 303 - Manaus, AM', 191);
// INSERTS para inserir as novas motos e escolher qual galpao adiciona-la
INSERT INTO MOTOS (id, disponibilidade, modelo, placa, galpao_id) VALUES (2, TRUE, 'Suzuki GSX-S750', 'XYZ5678', 4);
INSERT INTO MOTOS (id, disponibilidade, modelo, placa, galpao_id) VALUES (3, TRUE, 'Kawasaki Z900', 'DEF9101', 3);
INSERT INTO MOTOS (id, disponibilidade, modelo, placa, galpao_id) VALUES (4, TRUE, 'Ducati Monster 797', 'GHI1121', 5);
INSERT INTO MOTOS (id, disponibilidade, modelo, placa, galpao_id) VALUES (5, TRUE, 'BMW S 1000 RR', 'JKL3344', 3);
 
// para mudar a disponibilidade da moto
UPDATE motos
SET disponibilidade = false // escolha se ela esta disponivel ou nao
WHERE id = 2; // escolha a moto que sera editada
// Editar o numero de motos dentro do galpao escolhido usando UPDATE
UPDATE GALPOES  
SET MOTOS = '10'  //aqui escolha a quantidade de motos que deseja
WHERE ID = 2; //escolha qual galpao deseja editar a quantidade de motos
 
// insira a moto id 1 á algum galpao para que tudo funcione perfeitamente
UPDATE MOTOS
SET GALPAO_ID = 2
WHERE ID = 1;

****

- 🔍 Listar motos:  
  [http://localhost:8080/motos](http://localhost:8080/motos)

- 🔍 Listar galpões:  
  [http://localhost:8080/galpoes](http://localhost:8080/galpoes)

---




