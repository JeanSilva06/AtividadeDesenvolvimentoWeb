package com.br.api.categorias.repository;

import com.br.api.categorias.model.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();
    private Long nextId = 1L;

    public List<Categoria> findAll(){
        return categorias;
    }

    public Optional<Categoria> findById(Long id){
        return categorias.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    //POST da categoria
    public Categoria save(Categoria categoria){
        categoria.setId(nextId++);
        categorias.add(categoria);
        return categoria;
    }

    //PUT da categoria
    public Categoria update(Categoria categoria){
        return categorias.stream()
                .filter(p -> p.getId().equals(categoria.getId()))
                .findFirst().map(p -> {
                    p.setNome(categoria.getNome());
                    p.setDescricao(categoria.getDescricao());
                    return p;
                })
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada para atualização"));
    }

    //REMOVE da categoria
    public void deleteById(Long id){
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }
}
