package Ex1;
import java.util.Scanner;

public class Ex1 {
  /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: 1. Entrar via teclado com a base e a altura de um retângulo, calcular e exibir sua área.
  */

    public static void main(String[] args) {
      //Entrar via teclado com a base e a altura de um retângulo, calcular e exibir sua área.
      Scanner sc = new Scanner(System.in);
      
      System.out.println("--- Exercicio 1 ---");
      //pedir base e altura
      System.out.print("Base: ");
      float base = sc.nextFloat();
      
      System.out.print("Altura: ");
      float altura = sc.nextFloat();
      
     //calcular area
      float area = base * altura;
      
      System.out.println("Area do retangulo: " + area);
      sc.close();
        
    }
    
}
