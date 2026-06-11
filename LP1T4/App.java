/******************************************************************************
TRABALHO PRATICO 04 - LPR1

@AUTHOR: RENATA GARDENIA 
*******************************************************************************/
//Exercicio 01

import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

class Data {
    
    private int dia;
    private int mes;
    private int ano;
    
    // com tratamento de exceção
    public Data(){
        entraDia();
        entraMes();
        entraAno();
    }
    public Data(int d, int m, int a){
        entraDia(d);
        entraMes(m);
        entraAno(a);
    
    }
    public void entraDia(int d){
        this.dia =d;
    }
    public void entraMes(int m){
       this.mes = m;
    }
    public void entraAno(int a){
        this.ano =a;
    }
    public void entraDia(){
        // usuario digita e atribui - validação e redigitar
      Scanner scan = new Scanner(System.in);
        int d;
        while (true) {
            try {
                System.out.print("Dia: ");
                d = scan.nextInt();
                if (d >= 1 && d <= 31) {
                    this.dia = d;
                    break;
                } else {
                    System.out.println("Dia inválido! Informe um valor entre 1 e 31.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scan.nextLine(); // limpa o buffer
            }
        }
    }
    public void entraMes(){
        // usuario digita e atribui - validação e redigitar
        Scanner scan = new Scanner(System.in);
        int m;
        while (true) {
            try {
                System.out.print("Mês: ");
                m = scan.nextInt();
                if (m >= 1 && m <= 12) {
                    this.mes = m;
                    break;
                } else {
                    System.out.println("Mês inválido! Informe um valor entre 1 e 12.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scan.nextLine();
            }
        }
    }
    public void entraAno(){
      Scanner scan = new Scanner(System.in);
        int a;
        while (true) {
            try {
                System.out.print("Ano: ");
                a = scan.nextInt();
                if (a >= 1) {
                    this.ano = a;
                    break;
                } else {
                    System.out.println("Ano inválido! Informe um valor maior que 0.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scan.nextLine();
            }
        }
    }
    public int retDia(){
        return this.dia;
    }
    public int retMes(){
        return this.mes;
    }
    public int retAno(){
        return this.ano;
    }
    public String mostra1(){
        return String.format("%02d/%02d/%04d", retDia(), retMes(), retAno());
    }
    public String mostra2(){
        String nomeMes;
        switch (retMes()) {
            case 1:  nomeMes = "Janeiro";   break;
            case 2:  nomeMes = "Fevereiro"; break;
            case 3:  nomeMes = "Março";     break;
            case 4:  nomeMes = "Abril";     break;
            case 5:  nomeMes = "Maio";      break;
            case 6:  nomeMes = "Junho";     break;
            case 7:  nomeMes = "Julho";     break;
            case 8:  nomeMes = "Agosto";    break;
            case 9:  nomeMes = "Setembro";  break;
            case 10: nomeMes = "Outubro";   break;
            case 11: nomeMes = "Novembro";  break;
            case 12: nomeMes = "Dezembro";  break;
            default: nomeMes = "Inválido";  break;
        }
        return String.format("%02d/%s/%04d", retDia(), nomeMes, retAno());
    
    }
    public boolean bissexto(){
         int a = retAno();
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }
    public int diasTranscorridos(){
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 
        // Ajusta fevereiro para anos bissextos
        if (bissexto()) {
            diasPorMes[1] = 29;
        }
 
        int total = 0;
        for (int i = 0; i < retMes() - 1; i++) {
            total += diasPorMes[i];
        }
        total += retDia();
 
        return total;
    }
    public void apresentaDataAtual(){
        Date dataAtual = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data atual: " + formato.format(dataAtual));
    }
        
    
}
// Exercicio 2
public class Main
{
	public static void main(String[] args) {
	    
	    System.out.println("=== Teste com construtor parametrizado ===");
        Data d1 = new Data(25, 6, 2025);
        System.out.println("mostra1: " + d1.mostra1());
        System.out.println("mostra2: " + d1.mostra2());
        System.out.println("Bissexto: " + d1.bissexto());
        System.out.println("Dias transcorridos: " + d1.diasTranscorridos());
        d1.apresentaDataAtual();
 
        System.out.println();
        System.out.println("=== Teste com construtor padrão (entrada do usuário) ===");
        Data d2 = new Data();
        System.out.println("mostra1: " + d2.mostra1());
        System.out.println("mostra2: " + d2.mostra2());
        System.out.println("Bissexto: " + d2.bissexto());
        System.out.println("Dias transcorridos: " + d2.diasTranscorridos());
        d2.apresentaDataAtual();
	}
}