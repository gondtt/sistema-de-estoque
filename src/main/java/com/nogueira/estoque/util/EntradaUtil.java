package com.nogueira.estoque.util;
import java.util.Scanner;

public class EntradaUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int lerInt(String mensagem) {
        System.out.println(mensagem);
        return Integer.parseInt(scanner.nextLine());
    }

    public static double lerDouble(String mensagem) {
        System.out.println(mensagem);
        return Double.parseDouble(scanner.nextLine());
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
