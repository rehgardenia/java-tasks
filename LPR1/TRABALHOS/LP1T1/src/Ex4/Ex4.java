package Ex4;
import java.util.Scanner;

public class Ex4 {
     /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: A partir dos valores da base e altura de um triângulo, calcular e exibir sua área.
  */

    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercicio 4 ---");

         Scanner sc = new Scanner(System.in);
        // Entrada
         System.out.println("informe a Base: ");
         float base =  sc.nextFloat();

          System.out.println("informe a Altura: ");
         float altura =  sc.nextFloat();
         
         //Calcular area
         float area = (base * altura) / 2;
        // Saida
         System.out.println("Area: " + area);
         sc.close();
    }
}