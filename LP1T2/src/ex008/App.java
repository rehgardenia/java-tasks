package ex008;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // matriz original 3x4
        int matriz[][] = new int[3][4];

        // matriz resultado 3x4
        int resultado[][] = new int[3][4];

        // entrada de dados da matriz
        System.out.println("Digite os valores da matriz 3x4: ");
        for (int i = 0; i < 3; i++) { // linhas
            for (int j = 0; j < 4; j++) { // colunas
                System.out.print("[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // solicita a constante multiplicativa
        System.out.print("Digite a constante multiplicativa: ");
        int constante = sc.nextInt();

        // multiplica os valores e armazena na matriz resultado
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                resultado[i][j] = matriz[i][j] * constante;
            }
        }

        // exibe a matriz original
        System.out.println("Matriz original:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // exibe a matriz resultado
        System.out.println("Matriz multiplicada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(resultado[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
