package com.br.api.categorias.dto.response;

public class CategoriaResponseDTO {
    Long id;
    String nome;
    String descricao;

    public CategoriaResponseDTO(){}

    public CategoriaResponseDTO(Long id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
