package com.nogueira.estoque.repository;

import com.nogueira.estoque.model.venda;
import java.util.ArrayList;
import java.util.List;
public class vendaRepository {

    private List<venda> vendas = new ArrayList<>();

    public void salvarVenda(venda venda) {
        this.vendas.add(venda);
    }

    public List<venda> listarVendas() {
        return vendas;
    }

    public venda buscarPorId(int id) {
        for (venda v : vendas) {
            if(v.getId() == id) {
                return v;
            }
        }
        return null;
    } 
}
