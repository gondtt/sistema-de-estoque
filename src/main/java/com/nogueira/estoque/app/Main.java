package com.nogueira.estoque.app;

import com.nogueira.estoque.model.produto;
import com.nogueira.estoque.repository.produtoRepository;
import com.nogueira.estoque.service.produtoService;
import com.nogueira.estoque.util.EntradaUtil;
import com.nogueira.estoque.model.cliente;
import com.nogueira.estoque.service.clienteService;
import com.nogueira.estoque.repository.clienteRepository;


public class Main {
    public static void main(String[] args) {
        
        produtoRepository repository = new produtoRepository();
        produtoService service = new produtoService(repository);

        clienteRepository clienteRepository = new clienteRepository();
        clienteService clienteService = new clienteService(clienteRepository);

        int opcao;

        do {

            IO.println("\n *SISTEMA DE ESTOQUE E VENDA* ");
            IO.println("1 - Cadastrar Produto");
            IO.println("2 - Listar Produtos");
            IO.println("3 - Buscar Produto por ID");
            IO.println("4 - Cadastrar Cliente");
            IO.println("5 - Realizar Venda");
            IO.println("6 - Listar Vendas");
            IO.println("0 - Sair");

            opcao = EntradaUtil.lerInt("Escolha uma opção: ");


            switch(opcao) {

                case 1 -> cadastrarProduto(service);
                case 2 -> listarProdutos(service);
                case 3 -> buscarPorId(service);
                case 4 -> cadastrarCliente(clienteService);
                case 5 -> listarClientes(clienteService);
                case 6 -> realizarVenda(vendaService);
                case 7 -> listarVendas(vendaService);
                case 0 -> IO.println("Saindo do sistema...");
                default -> IO.println("Opção inválida. Tente novamente.");
            }
            


        } while (opcao != 0);
    
    }


    private static void cadastrarProduto(produtoService service){

        int id = EntradaUtil.lerInt("ID: ");
        int quantidadeEstoque = EntradaUtil.lerInt("Quantidade em Estoque: ");
        String nome = EntradaUtil.lerString("Nome: ");
        String tipo = EntradaUtil.lerString("Tipo: ");
        double preco = EntradaUtil.lerDouble("Preço: ");
        
        produto produtoExistente = service.buscarPorNome(nome);

        if (produtoExistente != null) {
            IO.println("Produto já existe. Deseja somar a quantidade? (S/N)");
            String resposta = EntradaUtil.lerString("").trim().toUpperCase();

            if (resposta.equals("S")) {

                produto novoProduto = new produto(0, quantidadeEstoque, nome, tipo, preco);
                service.cadastrarOuSomar(novoProduto, true);
                
                IO.println("Quantidade somada ao produto existente.");
                service.salvarAlteracoes();
                return;

            } else {
                IO.println("Cadastro cancelado.");
                return;
            }
        } else {
            produto novoProduto = new produto(id, quantidadeEstoque, nome, tipo, preco);
            service.cadastrarProduto(novoProduto);
            System.out.println("Produto cadastrado.");
        }

        
    }

    private static void listarProdutos(produtoService service) {
        IO.println("\n *LISTA DE PRODUTOS* ");
        for (produto p : service.listarProdutos()) {
            IO.println(p);
        }
    }

    private static void buscarPorId(produtoService service) {
        int id = EntradaUtil.lerInt("ID do produto: ");
        produto produto = service.buscarPorId(id);
        if (produto != null) {
            IO.println("\n *PRODUTO ENCONTRADO* ");
            IO.println(produto);
        } else {
            IO.println("Produto não encontrado.");
        }
    }

    private static void cadastrarCliente(clienteService clienteService) {
        int id = EntradaUtil.lerInt("ID: ");
        String nome = EntradaUtil.lerString("Nome: ");
        String email = EntradaUtil.lerString("Email: ");
        cliente cliente = new cliente(id, nome, email);
        clienteService.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado.");
        // cliente clienteExistente = clienteService.buscarPorId(id);

        // if (clienteExistente != null) {
        //     IO.println("Cliente já existe. Cadastro cancelado.");
        //     return;
        // } else {
        //     cliente novoCliente = new cliente(id, nome, email);
        //     clienteService.cadastrarCliente(novoCliente);
        //     System.out.println("Cliente cadastrado.");
        // }
    }

    private static void listarClientes(clienteService clienteService) {
        IO.println("\n *LISTA DE CLIENTES* ");
        for (cliente c : clienteService.listarClientes()) {
            IO.println(c);
        }
    }
}