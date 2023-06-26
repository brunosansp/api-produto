package br.com.apiproduto.controller;

import br.com.apiproduto.entity.Produto;
import br.com.apiproduto.service.IProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final IProdutoService iProdutoService;

    public ProdutoController(IProdutoService iProdutoService) {
        this.iProdutoService = iProdutoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> all() {
        return ResponseEntity.ok(iProdutoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        Produto novoProduto = iProdutoService.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
