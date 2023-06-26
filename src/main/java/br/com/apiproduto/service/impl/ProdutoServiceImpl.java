package br.com.apiproduto.service.impl;


import br.com.apiproduto.entity.Produto;
import br.com.apiproduto.repository.IProdutoRepository;
import br.com.apiproduto.service.IProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements IProdutoService {

    private final IProdutoRepository iProdutoRepository;

    public ProdutoServiceImpl(IProdutoRepository iProdutoRepository) {
        this.iProdutoRepository = iProdutoRepository;
    }

    @Override
    public List<Produto> findAll() {
        return iProdutoRepository.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return iProdutoRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
        try {
            iProdutoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deleter o produto.");
        }
    }
}
