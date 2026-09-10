package ex005;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // Declaração da matriz: 3 linhas e 2 colunas
        double[][] matriz = new double[3][2];

        // Entrada de dados
        System.out.println("Digite os 6 valores para a matriz (3x2):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextDouble();
            }
        }

        // Exibição dos dados
        System.out.println("\n--- MATRIZ RESULTANTE ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                // Exibe o valor seguido de um espaço/tabulação
                System.out.print(matriz[i][j] + "\t");
            }
            // Pula linha ao final de cada linha da matriz
            System.out.println();
        }

        teclado.close();
    }
}
