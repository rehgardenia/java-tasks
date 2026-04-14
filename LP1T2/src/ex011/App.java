package ex011;

import java.util.Scanner;

public class App {
public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int m;

        // 1. Definição da ordem (Quadrática e Máximo 10)
        do {
            System.out.print("Digite a ordem da matriz quadrada (M) - Máx 10: ");
            m = teclado.nextInt();
            if (m <= 0 || m > 10) {
                System.out.println("Erro! A ordem deve estar entre 1 e 10.");
            }
        } while (m <= 0 || m > 10);

        double[][] matriz = new double[m][m];

        // 2. Entrada de dados
        System.out.println("\n--- Digite os elementos da matriz " + m + "x" + m + " ---");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matriz[i][j] = teclado.nextDouble();
            }
        }

        // 3. Cálculo e exibição
        double det = calcularDeterminante(matriz);
        System.out.println("\n----------------------------");
        System.out.println("O determinante da matriz é: " + det);
        System.out.println("----------------------------");

        teclado.close();
    }

    // Método recursivo para calcular o determinante (Teorema de Laplace)
    public static double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;

        // Caso base: Matriz 1x1
        if (n == 1) {
            return matriz[0][0];
        }

        // Caso base: Matriz 2x2 (otimização)
        if (n == 2) {
            return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
        }

        double determinante = 0;

        // Aplicação do Teorema de Laplace usando a primeira linha
        for (int j = 0; j < n; j++) {
            // Calcula o cofator: (-1)^(i+j) * det(submatriz)
            // Como i=0 (fixo na primeira linha), o sinal é (-1)^j
            double sinal = (j % 2 == 0) ? 1 : -1;
            double[][] submatriz = obterSubmatriz(matriz, 0, j);
            determinante += sinal * matriz[0][j] * calcularDeterminante(submatriz);
        }

        return determinante;
    }

    // Função auxiliar para gerar a submatriz eliminando uma linha e uma coluna
    public static double[][] obterSubmatriz(double[][] matriz, int linhaRemover, int colunaRemover) {
        int n = matriz.length;
        double[][] submatriz = new double[n - 1][n - 1];
        int iSub = 0;

        for (int i = 0; i < n; i++) {
            if (i == linhaRemover) continue;
            
            int jSub = 0;
            for (int j = 0; j < n; j++) {
                if (j == colunaRemover) continue;
                
                submatriz[iSub][jSub] = matriz[i][j];
                jSub++;
            }
            iSub++;
        }
        return submatriz;
    }
}