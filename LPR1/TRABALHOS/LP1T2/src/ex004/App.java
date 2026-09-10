package ex004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // cria uma matriz 2x3 
        int matriz[][] = new int[2][3];

        // entrada de dados
        for (int i = 0; i < 2; i++) { // percorre as linhas
            for (int j = 0; j < 3; j++) { // percorre as colunas
                System.out.print("Digite um valor para [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // exibição da matriz
        System.out.println("\nValores da matriz:");

        for (int i = 0; i < 2; i++) { // percorre as linhas
            for (int j = 0; j < 3; j++) { // percorre as colunas
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // pula linha após cada linha da matriz
        }

        sc.close();
    }
}
