# Task Manager API (Arquitetura de Produção)

API RESTful avançada para gerenciamento de tarefas pessoais. Este ecossistema foi estruturado seguindo as melhores práticas arquiteturais de isolamento de dados, tratamento robusto de erros globais, versionamento estruturado de rotas e documentação viva.

## 🛠️ Tecnologias e Padrões Aplicados
- **Spring Boot 3.x & Java 17/21**
- **Camadas Arquiteturais:** Model, Service, Controller, DTO, Exception Handler.
- **Isolamento por DTO (Data Transfer Objects):** Entrada de dados filtrada independentemente da camada de persistência.
- **Versionamento de Rota (URI):** Manutenção integrada e isolada para evolução estável do ecossistema de software.
- **Documentação Automatizada:** OpenAPI 3 / Swagger UI.

---

## 📖 Documentação dos Endpoints

### 📌 Geração Atual (API V1)

#### 1. Listar Tarefas
- **URL:** `/api/v1/tarefas`
- **Método:** `GET`
- **Resposta de Sucesso:** `200 OK`

#### 2. Criar Tarefa (V1)
- **URL:** `/api/v1/tarefas`
- **Método:** `POST`
- **Corpo da Requisição (JSON):**
    {
      "titulo": "String (Mín 3, Máx 100 - Obrigatório)",
      "descricao": "String (Máx 500)"
    }
- **Resposta de Sucesso:** `201 Created`

---

### 🚀 Geração Evoluída (API V2)

#### 1. Criar Tarefa com Prioridade (V2)
- **URL:** `/api/v2/tarefas`
- **Método:** `POST`
- **Corpo da Requisição (JSON):**
    {
      "titulo": "String (Mín 3, Máx 100 - Obrigatório)",
      "descricao": "String",
      "prioridade": "String (ALTA, MEDIA, BAIXA - Obrigatório)"
    }
- **Resposta de Sucesso:** `201 Created`

---

## 🛡️ Estrutura Global de Tratamento de Erros

Se o ecossistema interceptar qualquer inconsistência de entrada ou falha interna, a API interromperá o fluxo padrão do servidor e responderá com um payload estruturado unificado:

### Exemplo de Resposta de Erro (400 Bad Request - Erro de Validação):
    {
      "timestamp": "2026-06-08T15:30:00",
      "status": 400,
      "erro": "Erro de Validação de Dados",
      "mensagem": "Um ou mais campos contêm dados inválidos.",
      "caminho": "/api/v2/tarefas",
      "validacoes": {
        "prioridade": "A prioridade (ALTA, MEDIA, BAIXA) é obrigatória na versão V2 da API."
      }
    }

### Exemplo de Resposta de Erro (404 Not Found):
    {
      "timestamp": "2026-06-08T15:32:00",
      "status": 404,
      "erro": "Recurso Não Encontrado",
      "mensagem": "Nenhuma tarefa localizada com o ID fornecido: [id]",
      "caminho": "/api/v1/tarefas/[id]"
    }

---

## 🔌 Documentação Interativa Intermediária (Swagger)

A documentação visual e os contratos de dados podem ser acessados e testados em tempo de execução através da interface do Swagger UI na rota:
👉 `http://localhost:8080/swagger-ui/index.html`