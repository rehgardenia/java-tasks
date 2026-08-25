
package EX2;

import EX1.*;


public class Author {
    private String name;
    private String email;
    private char gender; // 'm' or 'f'
    
    public Author( String n, String e, char g){
      this.name = n;
      this.email = e;
      this.gender = g;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String e){
        this.email = e;
    }
    public char getGender(){
        return this.gender;
    }
    public String toString(){
        return "Author[name="+ this.getName() +",email="+this.getEmail()+",gender="+this.getGender()+"]";
    }
    
}
