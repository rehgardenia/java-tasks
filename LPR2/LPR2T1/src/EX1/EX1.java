
package EX1;

public class EX1 {
   public static void main(String[] args){
    
    Author a = new Author("Clarice Lispector", "lispector@email.com", 'F');
    System.out.println(a);
    System.out.println("Name: " + a.getName());
    System.out.println("Email: "+ a.getEmail());
    System.out.println("Gender: " + a.getGender());
    
    }
}
