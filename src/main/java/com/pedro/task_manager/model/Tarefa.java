package com.pedro.task_manager.model;

import java.util.UUID;

public class Tarefa {
    private String id;
    private String titulo;
    private String descricao;
    private boolean concluida;

    // Construtor
    public Tarefa() {
        this.id = UUID.randomUUID().toString(); // Gera um ID único automaticamente
        this.concluida = false;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }
}