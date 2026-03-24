package Ex6;

import java.util.Scanner;

public class Ex6 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: Calcular e exibir a média aritmética de quatro valores quaisquer que serão
digitados.
  */
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Exercicio 6 ---");
        double v1, v2, v3, v4;

        System.out.print("Digite o primeiro valor: ");
        v1 = sc.nextDouble();

        System.out.print("Digite o segundo valor: ");
        v2 = sc.nextDouble();

        System.out.print("Digite o terceiro valor: ");
        v3 = sc.nextDouble();

        System.out.print("Digite o quarto valor: ");
        v4 = sc.nextDouble();

        double media = (v1 + v2 + v3 + v4) / 4;

        System.out.println("Media aritmetica: " + media);

        sc.close();
}
}