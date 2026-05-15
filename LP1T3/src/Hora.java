
package lp1t3;

import java.util.Scanner;


public class Hora {
    private int hora;
    private int min;
    private int seg;
    
    public Hora(){
       setHor();
       setMin();
       setSeg();
    }
    
    public Hora(int h, int m, int s){
      setHor(h);
      setMin(m);
      setSeg(s);
    }
    public void setHor(int h){
        this.hora = h;
    }
    public void setMin(int m){
        this.min = m;
    }
    public void setSeg(int s){
        this.seg = s;
    }
    public void setHor(){
      int hora;
      Scanner scan = new Scanner(System.in);
      while(true){
          System.out.print("Hora: ");
          hora = scan.nextInt();
          if(hora >=0 && hora <24){
              setHor(hora);
              break;
          }
          else{
            System.out.println("Hora Inválida!");
         }
      }
    }
    public void setMin(){
      int minuto;
      Scanner scan = new Scanner(System.in);
      while(true){
          System.out.print("Minuto: ");
          minuto = scan.nextInt();
          if(minuto >=0 && minuto <60){
              setMin(minuto);
              break;
          }
          else{
            System.out.println("Minuto Inválida!");
         }
      }
    }
    public void setSeg(){
      int segundo;
      Scanner scan = new Scanner(System.in);
      while(true){
          System.out.print("Segundo: ");
          segundo = scan.nextInt();
          if(segundo >=0 && segundo <60){
              setSeg(segundo);
              break;
          }
          else{
            System.out.println("Segundo Inválida!");
         }
      }
    }
    
    public int getHor(){
        return hora;
    }
    public int getMin(){
        return min;
    }
    public int getSeg(){
        return seg;
    }
    
    public String getHora1(){
        //hh:mm:ss;
         return String.format("%02d:%02d:%02d", hora, min, seg);
    }
    public String getHora2(){
        //hh:mm:ss (AM/PM);
        int h = this.getHor();
        String periodo = (h >= 12) ? "PM" : "AM";

        if (h == 0) {
            h = 12; 
        } else if (h > 12) {
            h = h - 12;
        }

        return String.format("%02d:%02d:%02d %s", h, getMin(), getSeg(), periodo);
       
    }
    public int getSegundos(){
         return (hora * 3600) + (min * 60) + seg;
    }
}
