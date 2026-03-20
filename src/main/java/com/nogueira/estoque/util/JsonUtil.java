package com.nogueira.estoque.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// import com.google.gson.reflect.TypeBroken;
import com.google.gson.reflect.TypeToken;
import com.nogueira.estoque.model.produto;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class JsonUtil {
    private static final String CAMINHO_PRODUTOS = "produtos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvarProdutos(List<produto> produtos) {
        try (FileWriter writer = new FileWriter(CAMINHO_PRODUTOS)) {
            gson.toJson(produtos, writer);
        } catch(IOException e) {
            IO.println("Erro ao salvar os produtos no JSON:" + e.getMessage());
        }
    }

    public static List<produto> carregarProdutos() {
        try(FileReader reader = new FileReader(CAMINHO_PRODUTOS)) {
            Type tipoLista = new TypeToken<List<produto>>(){}.getType();
            List<produto> produtos = gson.fromJson(reader, tipoLista);

            if (produtos == null) {
                return new ArrayList<>();
            }

            return produtos;

        } catch (IOException e) {
            return new ArrayList<>();
        } 
    }
    
}
