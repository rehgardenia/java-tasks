package Ex3;
import java.util.Scanner;

public class Ex3 {
     /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: Calcular e exibir a área de um quadrado a partir do valor de sua diagonal que será digitado.
  */
    public static void main(String[] args) throws Exception {
      System.out.println("--- Exercicio 3 ---");
     Scanner sc = new Scanner(System.in);

     //Entrada do valor da diagonal
     System.out.println("Valor da diagonal: ");
     float diagonal =  sc.nextFloat();

     //calcular diagonal
     float area = (diagonal * diagonal) / 2;
     System.out.println("Area do quadrado: " + area );
    sc.close();
    
    }
}