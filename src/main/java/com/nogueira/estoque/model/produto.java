package com.nogueira.estoque.model;

public class produto {
    private int id;
    private int quantidadeEstoque;
    private String nome;
    private String tipo;
    private double preco;
    

    public produto(int id, int quantidadeEstoque, String nome, String tipo, double preco) {
        this.id = id;
        this.quantidadeEstoque = quantidadeEstoque;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Preço: " + preco +
                " | Estoque: " + quantidadeEstoque;
    }
    
    
}
