package ex003;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char continuar;

        do {
            int n;
            // Validação da quantidade N
            do {
                System.out.print("Digite a quantidade de números (0 < N < 20): ");
                n = teclado.nextInt();
                if (n <= 0 || n >= 20) {
                    System.out.println("Erro! A quantidade deve ser positiva e menor que 20.");
                }
            } while (n <= 0 || n >= 20);

            double maior = Double.NEGATIVE_INFINITY;
            double menor = Double.POSITIVE_INFINITY;
            double soma = 0;
            int positivos = 0;
            int negativos = 0;

            // Entrada dos N valores
            for (int i = 1; i <= n; i++) {
                System.out.print("Digite o " + i + "º valor: ");
                double valor = teclado.nextDouble();

                // Cálculos
                if (valor > maior) maior = valor;
                if (valor < menor) menor = valor;
                
                soma += valor;
                
                if (valor > 0) positivos++;
                else if (valor < 0) negativos++;
            }

            // Processamento dos resultados
            double media = soma / n;
            double percPositivos = (double) positivos / n * 100;
            double percNegativos = (double) negativos / n * 100;

            // Exibição dos resultados
            System.out.println("\n--- RESULTADOS ---");
            System.out.println("a. Maior valor: " + maior);
            System.out.println("b. Menor valor: " + menor);
            System.out.println("c. Soma dos valores: " + soma);
            System.out.println("d. Média aritmética: " + media);
            System.out.println("e. Porcentagem de positivos: " + percPositivos + "%");
            System.out.println("f. Porcentagem de negativos: " + percNegativos + "%");

            // Validação da continuidade
            do {
                System.out.print("\nDeseja uma nova execução? (S/N): ");
                continuar = teclado.next().toUpperCase().charAt(0);
                if (continuar != 'S' && continuar != 'N') {
                    System.out.println("Resposta inválida! Digite apenas 'S' ou 'N'.");
                }
            } while (continuar != 'S' && continuar != 'N');

        } while (continuar == 'S');

        System.out.println("Programa encerrado.");
        teclado.close();
    }
}
