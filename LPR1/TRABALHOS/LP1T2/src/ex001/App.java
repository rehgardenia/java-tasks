package ex001;

import java.util.Scanner;

public class App {
 public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // Entrada do primeiro valor
        System.out.print("Digite o primeiro valor: ");
        double v1 = teclado.nextDouble();
        
        double v2;
        
        // Laço de repetição para validar o segundo valor
        do {
            System.out.print("Digite o segundo valor (deve ser maior que " + v1 + "): ");
            v2 = teclado.nextDouble();
            
            if (v2 <= v1) {
                System.out.println("Erro! O segundo valor precisa ser maior que o primeiro.");
            }
            
        } while (v2 <= v1);
        
        System.out.println("\nSucesso!");
        System.out.println("Valores aceitos: Primeiro = " + v1 + " | Segundo = " + v2);
        
        teclado.close();
    }
}