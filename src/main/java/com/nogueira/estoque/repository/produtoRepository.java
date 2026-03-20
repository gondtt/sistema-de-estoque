package com.nogueira.estoque.repository;

import com.nogueira.estoque.util.JsonUtil;
import com.nogueira.estoque.model.produto;
import java.util.ArrayList;
import java.util.List;


public class produtoRepository {

    private List<produto> produtos = new ArrayList<>();

    public void salvar(produto produto) {
        produtos.add(produto);
        JsonUtil.salvarProdutos(produtos);
    }

    public produtoRepository() {
        this.produtos = JsonUtil.carregarProdutos();
    }

    public List<produto> listarTodos() {
        return produtos;
    }

    public produto buscarPorId(int id) { // método da classe produto para buscar o id inserido

        for(produto p : produtos) { // todo produto vai ser chamado de p dentro da busca, e para cada p, realize essa checagem
            if(p.getId() == id) { // se o getId desse produto for igual ao inserido . . .
                return p; // traz as características do prouto.
            }
        }
        return null;
    }

    public produto buscarPorNome(String nome) { // método da classe produto para buscar o nome inserido

        for(produto p : produtos) { // todo produto vai ser chamado de p dentro da busca, e para cada p, realize essa checagem
            if(p.getNome().equalsIgnoreCase(nome)) { // se o getNome desse produto for igual ao inserido . . .
                return p; // traz as características do prouto.
            }
        }
        return null;
    }

    public void atualizarJson() {
        JsonUtil.salvarProdutos(produtos);
    }

}


