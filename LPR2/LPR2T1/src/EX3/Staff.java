package EX3;

public class Staff extends Person {
    private String school;
    private double pay;
    
    public Staff(String n, String a, String s, double p){
        super(n,a);
        this.school = s;
        this.pay = p;
    }
    
    public String getSchool(){ return this.school;}
    public void setSchool(String s){ this.school = s;}
    
    public double getPay(){ return this.pay;}
    public void setPay(double p){this.pay = p;}
    
    public String toString(){
        return "Staff["+super.toString()+",school="+this.getSchool()+",pay="+this.getPay()+"]";
    }

}