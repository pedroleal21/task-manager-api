package com.pedro.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TarefaV2Request {
    @NotBlank(message = "O título é obrigatório para os clientes V2.")
    @Size(min = 3, max = 100, message = "O título deve conter entre 3 e 100 caracteres.")
    private String titulo;

    private String descricao;

    @NotBlank(message = "A prioridade (ALTA, MEDIA, BAIXA) é obrigatória na versão V2 da API.")
    private String prioridade;

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }
}