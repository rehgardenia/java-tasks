
package EX3;

public class EX3 {

    public static void main(String[] args) {
        Student s = new Student("Alex", "Rua X, 99", "ADS1", 2026, 8.5);
        System.out.println(s.toString());
        Staff st = new Staff("Maria", "Rua Y, 88", "IFSP", 3000.00);
        System.out.println(st.toString());
    }
}
