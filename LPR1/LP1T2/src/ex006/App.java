package ex006;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // cria uma matriz 2x3 para armazenar nomes
        String nomes[][] = new String[2][3];

        // entrada de dados
        for (int i = 0; i < 2; i++) { // percorre as linhas
            for (int j = 0; j < 3; j++) { // percorre as colunas
                System.out.print("Digite um nome para [" + i + "][" + j + "]: ");
                nomes[i][j] = sc.nextLine();
            }
        }

        // exibição dos nomes
        System.out.println("Nomes digitados:");

        for (int i = 0; i < 2; i++) { // percorre as linhas
            for (int j = 0; j < 3; j++) { // percorre as colunas
                System.out.print(nomes[i][j] + " ");
            }
            System.out.println(); // quebra de linha ao final de cada linha
        }

        sc.close();
    }
}
