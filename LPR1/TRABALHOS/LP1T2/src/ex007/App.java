package ex007;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double[][] matriz = new double[3][4];

        // 1. Entrada dos 12 valores (3 linhas x 4 colunas)
        System.out.println("Digite os 12 valores para a matriz 3x4:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("Posição [%d][%d]: ", i, j);
                matriz[i][j] = teclado.nextDouble();
            }
        }

        // 2. Solicitação da constante
        System.out.print("\nDigite a constante multiplicativa: ");
        double constante = teclado.nextDouble();

        // 3. Multiplicação e armazenamento na própria matriz
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] *= constante; // Abreviação de: matriz[i][j] = matriz[i][j] * constante
            }
        }

        // 4. Exibição da matriz resultante
        System.out.println("\n--- MATRIZ RESULTANTE (APÓS MULTIPLICAÇÃO) ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        teclado.close();
    }
}