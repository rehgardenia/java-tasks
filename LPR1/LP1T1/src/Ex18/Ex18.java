package Ex18;
import java.util.Scanner;

public class Ex18 {
  /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question:  Entrar via teclado com o valor de cinco produtos. Após as entradas, digitar um valor referente ao pagamento 
                da somatória destes valores. Calcular e exibir o troco que deverá ser devolvido.
  */

    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercicio 18 ---");
        // Variaveis
        double prod1, prod2, prod3, prod4, prod5, valorPago;
        // Inicializar Scanner
        Scanner scan = new Scanner(System.in);
        // Entrada 
        System.out.print("Produto 1: ");
        prod1 = scan.nextDouble();    
        System.out.print("Produto 2: ");
        prod2 = scan.nextDouble();    
        System.out.print("Produto 3: ");
        prod3 = scan.nextDouble();    
        System.out.print("Produto 4: ");
        prod4 = scan.nextDouble();    
        System.out.print("Produto 5: ");
        prod5 = scan.nextDouble();    
        System.out.print("Valor Pago:  R$ ");
        valorPago = scan.nextDouble(); 
        // Calculo do Troco
        double troco = valorPago - (prod1 + prod2 + prod3 + prod4 + prod5);
        // Saida
        System.out.printf("Troco: R$ %.2f \n", troco);
        scan.close();
    }
}
