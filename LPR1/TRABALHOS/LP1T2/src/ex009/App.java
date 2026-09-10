package ex009;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int m, n;

        // 1. Definição da ordem com validação (máximo 10x10)
        do {
            System.out.print("Digite a quantidade de linhas (M) - Máx 10: ");
            m = teclado.nextInt();
            System.out.print("Digite a quantidade de colunas (N) - Máx 10: ");
            n = teclado.nextInt();

            if (m <= 0 || m > 10 || n <= 0 || n > 10) {
                System.out.println("Erro! A ordem deve estar entre 1 e 10.");
            }
        } while (m <= 0 || m > 10 || n <= 0 || n > 10);

        double[][] matriz = new double[m][n];

        // 2. Entrada de dados
        System.out.println("\n--- Digite os elementos da matriz ---");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matriz[i][j] = teclado.nextDouble();
            }
        }

        // 3. Exibição da Matriz Original
        System.out.println("\n--- Matriz Original (" + m + "x" + n + ") ---");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // 4. Cálculo e Exibição da Matriz Transposta
        // Note que os limites dos laços são invertidos: n para linhas e m para colunas
        System.out.println("\n--- Matriz Transposta (" + n + "x" + m + ") ---");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                // Ao imprimir matriz[i][j] dentro deste laço invertido,
                // estamos lendo a coluna da original como se fosse linha
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        teclado.close();
    }
}
