package com.pedro.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TarefaV1Request {
    @NotBlank(message = "O título é obrigatório para os clientes V1.")
    @Size(min = 3, max = 100, message = "O título deve conter entre 3 e 100 caracteres.")
    private String titulo;

    @Size(max = 500, message = "A descrição não pode passar de 500 caracteres.")
    private String descricao;

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}