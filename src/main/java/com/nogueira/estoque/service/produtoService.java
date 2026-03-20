package com.nogueira.estoque.service;

import com.nogueira.estoque.model.produto;
import com.nogueira.estoque.repository.produtoRepository;
import java.util.List;

public class produtoService {

    private produtoRepository repository;
    // novo objeto (produtoRepository()) da classe produtoRepository, armazenado dentro da variavel repository.


    public produtoService(produtoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarProduto(produto produto) {
        repository.salvar(produto);
    }

    public List<produto> listarProdutos() {
        return repository.listarTodos();
    }

    public produto buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
    
    public produto buscarPorNome(String nome) {
        return repository.buscarPorNome(nome);
    }

    public void cadastrarOuSomar(produto novoProduto, boolean somarSeExistir) {

        produto produtoExistente = repository.buscarPorNome(novoProduto.getNome());
    
        if(produtoExistente != null && somarSeExistir) {
            
            int estoqueAtual = produtoExistente.getQuantidadeEstoque();
            
            produtoExistente.setQuantidadeEstoque(estoqueAtual + novoProduto.getQuantidadeEstoque());
        
        } else {
            repository.salvar(novoProduto);
        }
    }

    public void salvarAlteracoes() {
        repository.atualizarJson();
    }
}
