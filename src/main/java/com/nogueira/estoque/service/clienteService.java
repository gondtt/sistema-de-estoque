package com.nogueira.estoque.service;

import com.nogueira.estoque.model.cliente;
import com.nogueira.estoque.repository.clienteRepository;
import java.util.List;

public class clienteService {
    private clienteRepository repository;

    public clienteService(clienteRepository repository) {
        this.repository = repository;
    }

    public void cadastrarCliente(cliente cliente) {
        repository.salvarClientes(cliente);
    }

    public List<cliente> listarClientes() {
        return repository.listarTodos();
    }

    public cliente buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
}
