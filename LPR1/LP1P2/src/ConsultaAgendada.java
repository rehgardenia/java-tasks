import java.util.Scanner;

public class ConsultaAgendada {
    private Data data;
    private Hora hora ;
    private String nomePaciente;
    private static int quantidade;
    private String nomeMedico;

    // Construtores
    public ConsultaAgendada() {
        data = new Data();
        hora = new Hora();
        Scanner scan = new Scanner(System.in);
        scan.nextLine(); // descarta o \n residual do último nextInt() de Hora
        System.out.print("Nome do Paciente: ");
        nomePaciente = scan.nextLine();
        System.out.print("Nome do Médico: ");
        nomeMedico = scan.nextLine();
        quantidade++;
    }
    public ConsultaAgendada(int hor, int min, int seg, int dd, int mm , int aa, String p, String m){       
        hora = new Hora(hor, min, seg);
        data = new Data(dd, mm, aa);
        nomePaciente = p;
        nomeMedico = m;
        quantidade++;
    }
    public ConsultaAgendada(Data d, Hora h, String p, String m){
        data = d;
        hora = h;
        nomePaciente = p;
        nomeMedico = m;
        quantidade++;
    }
    // Setters
    public void setData(){
        this.data = new Data();
    }
    public void setData(int d, int m, int a){
        this.data = new Data(d, m, a);
    }   
    public void setHora(){
        this.hora = new Hora();
    }
    public void setHora(int h, int m, int s){
        this.hora = new Hora(h, m, s);
    }
    public void setNomeMedico(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nome do Médico: ");
        this.nomeMedico = scan.nextLine();
        System.out.println();

    }
    public void setNomeMedico(String m){
        this.nomeMedico = m;
    }
    public void setNomePaciente(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nome do Paciente: ");
        this.nomePaciente = scan.nextLine();
        System.out.println();
    }
    public void setNomePaciente(String p){
        this.nomePaciente = p;
    }
    // Getters
    public int getAmostra(){
        return quantidade;
    }
    public String getData(){
        return data.mostra1();
    }
    public String getHora(){
        return hora.getHora1();
    }
    public String getNomeMedico(){
        return nomeMedico;
    }
    public String getNomePaciente(){
        return nomePaciente;
    }

}
