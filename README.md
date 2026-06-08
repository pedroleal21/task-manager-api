# Task Manager API (Versão Aprimorada)

API RESTful para gerenciamento de tarefas pessoais, estruturada com boas práticas de desenvolvimento em Spring Boot (Camadas Controller e Service, Validações de Dados e Tratamento de Exceções).

## Endpoints

### 1. Listar Tarefas
- **URL:** `/api/tarefas`
- **Método:** `GET`
- **Resposta de Sucesso:** `200 OK`
  
### 2. Criar Tarefa
- **URL:** `/api/tarefas`
- **Método:** `POST`
- **Corpo da Requisição (JSON):**
    {
      "titulo": "String (Mín 3, Máx 100 caracteres - Obrigatório)",
      "descricao": "String (Máx 500 caracteres)"
    }
- **Resposta de Sucesso:** `201 Created`
- **Resposta de Falha (Validação):** `400 Bad Request` (Retorna JSON com detalhes do erro no formato `{ "campo": "mensagem de erro" }`)

### 3. Atualizar Tarefa
- **URL:** `/api/tarefas/{id}`
- **Método:** `PUT`
- **Parâmetro:** `id` (String) na URL
- **Corpo da Requisição:** Mesmo formato da Criação.
- **Resposta de Sucesso:** `200 OK`
- **Resposta de Falha:** - `400 Bad Request` (Erro de validação)
  - `404 Not Found` (ID inexistente)

### 4. Deletar Tarefa
- **URL:** `/api/tarefas/{id}`
- **Método:** `DELETE`
- **Parâmetro:** `id` (String) na URL
- **Resposta de Sucesso:** `204 No Content`
- **Resposta de Falha:** `404 Not Found` (ID inexistente)