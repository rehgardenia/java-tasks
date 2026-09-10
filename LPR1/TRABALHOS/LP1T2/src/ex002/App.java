package ex002;
import java.util.Scanner;

public class Main {
    public class static void main (String[] args)
    { Scanner sc = new Scanner(System.in);

     int contador = 0;
     double valor;
     double soma = 0;
     double maior = 0;
     
    // loop até digitar 10 valores
     while (contador < 10) {
         System.out.print("Digite um valor positivo: ");
         valor = sc.nextDouble();

         // valida se é positivo
         if (valor <= 0) {
             System.out.println("Erro. Digite apenas valores positivos.");
         }
         else {
             //soma os valores
             soma += valor;
             
             // verifica o maior valor
             if (contador == 0 || valor > maior) {
                 maior = valor;
             }

             contador++; 
         }
     }

     // média
     double media = soma / 10;

     //exibição
     System.out.println("Maior valor: " + maior);
     System.out.println("Soma: " + soma);
     System.out.println("Média: " + media);

     sc.close();
    }
}
     

   

