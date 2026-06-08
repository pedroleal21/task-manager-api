package com.pedro.task_manager.controller.v1;

import com.pedro.task_manager.dto.TarefaV1Request;
import com.pedro.task_manager.model.Tarefa;
import com.pedro.task_manager.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tarefas")
@Tag(name = "Gerenciador de Tarefas - V1", description = "Endpoints da primeira geração da API")
public class TarefaControllerV1 {

    private final TarefaService service;

    public TarefaControllerV1(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Recupera todas as tarefas cadastradas")
    public ResponseEntity<List<Tarefa>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    @Operation(summary = "Adiciona uma nova tarefa seguindo as regras da V1")
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody TarefaV1Request request) {
        Tarefa modelo = new Tarefa();
        modelo.setTitulo(request.getTitulo());
        modelo.setDescricao(request.getDescricao());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(modelo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma tarefa existente")
    public ResponseEntity<Optional<Tarefa>> atualizar(@PathVariable("id") String id, @Valid @RequestBody TarefaV1Request request) {
        Tarefa modelo = new Tarefa();
        modelo.setTitulo(request.getTitulo());
        modelo.setDescricao(request.getDescricao());
        return ResponseEntity.ok(service.atualizar(id, modelo));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui permanentemente uma tarefa do sistema")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}