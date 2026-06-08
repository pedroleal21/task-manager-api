package com.pedro.task_manager.service;

import com.pedro.task_manager.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    // Nosso "banco de dados" temporário foi movido para cá
    private final List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> listarTodas() {
        return tarefas;
    }

    public Tarefa salvar(Tarefa tarefa) {
        tarefas.add(tarefa);
        return tarefa;
    }

    public Optional<Tarefa> buscarPorId(String id) {
        return tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Optional<Tarefa> atualizar(String id, Tarefa tarefaAtualizada) {
        return buscarPorId(id).map(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            tarefaExistente.setConcluida(tarefaAtualizada.isConcluida());
            return tarefaExistente;
        });
    }

    public boolean deletar(String id) {
        return tarefas.removeIf(tarefa -> tarefa.getId().equals(id));
    }
}