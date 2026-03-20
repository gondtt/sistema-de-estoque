package com.nogueira.estoque.service;
import com.nogueira.estoque.model.venda;
import com.nogueira.estoque.repository.vendaRepository;


public class vendaService {
    private vendaRepository vendaRepository;

    public vendaService(vendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

}
