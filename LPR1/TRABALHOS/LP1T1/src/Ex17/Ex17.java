package Ex17;

import java.util.Scanner;

public class Ex17 {
   /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question:  Entrar via teclado com dois valores quaisquer “X” e “Y”. 
                Calcular e exibir o cálculo XY (“X” elevado a “Y”). Pesquisar as funções Exp e Ln.
  */
    public static void main(String[] args) throws Exception {
       System.out.println("--- Exercicio 17 ---");
        //Inicialização da Classe Scanner    
        Scanner scan = new Scanner(System.in);
        // Entrada
        System.out.print("Informe x: ");
        double x = scan.nextDouble();    
        System.out.print("Informe y: ");
        double y = scan.nextDouble(); 
        // Calculo
        double resultado = Math.exp(y * Math.log(x));
        // Saida
        System.out.printf("Resultado: %.2f \n", resultado);
        scan.close();   
    }
}
