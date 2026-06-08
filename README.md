# Task Manager API

API RESTful simples para gerenciamento de tarefas pessoais, desenvolvida em Spring Boot.

## Endpoints

### 1. Listar Tarefas
- **URL:** `/api/tarefas`
- **Método:** `GET`
- **Resposta de Sucesso:** `200 OK`
  
### 2. Criar Tarefa
- **URL:** `/api/tarefas`
- **Método:** `POST`
- **Corpo da Requisição (JSON):**
  ```json
  {
    "titulo": "String",
    "descricao": "String"
  }
  ```
- **Resposta de Sucesso:** `201 Created`

### 3. Atualizar Tarefa
- **URL:** `/api/tarefas/{id}`
- **Método:** `PUT`
- **Parâmetro:** `id` (String) na URL
- **Corpo da Requisição (JSON):**
  ```json
  {
    "titulo": "String",
    "descricao": "String",
    "concluida": boolean
  }
  ```
- **Resposta de Sucesso:** `200 OK`
- **Resposta de Falha:** `404 Not Found` (se o ID não existir)

### 4. Deletar Tarefa
- **URL:** `/api/tarefas/{id}`
- **Método:** `DELETE`
- **Parâmetro:** `id` (String) na URL
- **Resposta de Sucesso:** `204 No Content`
- **Resposta de Falha:** `404 Not Found` (se o ID não existir)