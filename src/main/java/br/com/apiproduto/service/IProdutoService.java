package br.com.apiproduto.service;

import br.com.apiproduto.entity.Produto;

import java.util.List;

public interface IProdutoService {

    List<Produto> findAll();

    Produto save(Produto produto);

    void delete(Long id);
}
