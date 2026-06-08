package com.pedro.task_manager.controller;

import com.pedro.task_manager.model.Tarefa;
import com.pedro.task_manager.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    // Injeção de dependência: o Spring entrega o Service pronto para usarmos
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    // O @Valid avisa o Spring para checar as regras do modelo antes de entrar no método
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa novaTarefa) {
        Tarefa tarefaSalva = tarefaService.salvar(novaTarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable String id, @Valid @RequestBody Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaOp = tarefaService.atualizar(id, tarefaAtualizada);
        
        // Se a tarefa existir, retorna ela. Se não, retorna 404 de forma bem limpa.
        return tarefaOp.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable String id) {
        boolean foiRemovido = tarefaService.deletar(id);
        
        if (foiRemovido) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}