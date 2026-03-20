package com.nogueira.estoque.repository;
import com.nogueira.estoque.model.cliente;

import java.util.ArrayList;
import java.util.List;

public class clienteRepository {
    
    private List<cliente> clientes = new ArrayList<>();

    public void salvarClientes(cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<cliente> listarTodos() {
        return clientes;
    }

    public cliente buscarPorId(int id) {
        for (cliente c : clientes) {
            if(c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
