package com.br.api.categorias.controller;

import com.br.api.categorias.dto.request.CategoriaRequestDTO;
import com.br.api.categorias.dto.response.CategoriaResponseDTO;
import com.br.api.categorias.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> criarCategoria(@RequestBody CategoriaRequestDTO requestDTO) {
        return ResponseEntity.ok(categoriaService.criarCategoria(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO requestDTO) {
        return ResponseEntity.ok(categoriaService.atualizarCategoria(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable Long id) {
        categoriaService.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
