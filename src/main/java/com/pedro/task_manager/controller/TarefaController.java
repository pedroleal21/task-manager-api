package com.pedro.task_manager.controller;

import com.pedro.task_manager.model.Tarefa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    // Lista em memória atuando como nosso "banco de dados" temporário
    private List<Tarefa> tarefas = new ArrayList<>();

    // 1. GET: Recupera a lista de todas as tarefas
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        return ResponseEntity.ok(tarefas);
    }

    // 2. POST: Adiciona uma nova tarefa
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa novaTarefa) {
        tarefas.add(novaTarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    // 3. PUT: Atualiza uma tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable String id, @RequestBody Tarefa tarefaAtualizada) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefa.setTitulo(tarefaAtualizada.getTitulo());
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setConcluida(tarefaAtualizada.isConcluida());
                return ResponseEntity.ok(tarefa);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se não achar o ID
    }

    // 4. DELETE: Exclui uma tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable String id) {
        boolean removido = tarefas.removeIf(tarefa -> tarefa.getId().equals(id));
        if (removido) {
            return ResponseEntity.noContent().build(); // Retorna 204 (Sucesso sem conteúdo)
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se não achar o ID
    }
}