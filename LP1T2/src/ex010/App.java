package ex010;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        // lê a ordem da matriz (máx 10)
        do {
            System.out.print("Digite a ordem da matriz (até 10): ");
            n = sc.nextInt();
        } while (n <= 0 || n > 10);

        double[][] matriz = new double[n][n];
        double[][] identidade = new double[n][n];

        // leitura da matriz
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        // cria matriz identidade
        for (int i = 0; i < n; i++) {
            identidade[i][i] = 1;
        }

        // método de Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double pivo = matriz[i][i];

            // verifica se o pivô é zero (não tem inversa)
            if (pivo == 0) {
                System.out.println("A matriz não possui inversa.");
                return;
            }

            // divide a linha inteira pelo pivô
            for (int j = 0; j < n; j++) {
                matriz[i][j] /= pivo;
                identidade[i][j] /= pivo;
            }

            // zera os outros elementos da coluna
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double fator = matriz[k][i];

                    for (int j = 0; j < n; j++) {
                        matriz[k][j] -= fator * matriz[i][j];
                        identidade[k][j] -= fator * identidade[i][j];
                    }
                }
            }
        }

        // exibe matriz original 
        System.out.println("Matriz transformada:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // exibe matriz inversa
        System.out.println("Matriz inversa:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(identidade[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
