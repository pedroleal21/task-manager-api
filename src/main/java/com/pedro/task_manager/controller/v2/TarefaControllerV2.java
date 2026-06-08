package com.pedro.task_manager.controller.v2;

import com.pedro.task_manager.dto.TarefaV2Request;
import com.pedro.task_manager.model.Tarefa;
import com.pedro.task_manager.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/tarefas")
@Tag(name = "Gerenciador de Tarefas - V2", description = "Endpoints modernos com controle de prioridades")
public class TarefaControllerV2 {

    private final TarefaService service;

    public TarefaControllerV2(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Adiciona uma nova tarefa exigindo a definição de prioridade")
    public ResponseEntity<Tarefa> criarV2(@Valid @RequestBody TarefaV2Request request) {
        Tarefa modelo = new Tarefa();
        modelo.setTitulo(request.getTitulo());
        modelo.setDescricao(request.getDescricao());
        modelo.setPrioridade(request.getPrioridade().toUpperCase());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(modelo));
    }
}