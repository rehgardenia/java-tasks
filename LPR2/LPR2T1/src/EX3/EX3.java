
package EX3;

public class EX3 {

    public static void main(String[] args) {
        Student s = new Student("Alex", "Rua X, 99", "ADS1", 2026, 8.5);
        System.out.println(s.toString());

        s.setAdress("RUA XV de novembro 99");
        s.setFee(1500);
        s.setProgram("ATM");
        s.setYear(2020);

        System.out.println("Nome: " + s.getName());
        System.out.println("Endereço: " + s.getAddress());
        System.out.println("Programa: " + s.getProgram());
        System.out.println("Taxa: " + s.getFee());
        System.out.println("Ano: " + s.getYear());
        
        Staff st = new Staff("Maria", "Rua Y, 88", "IFSP", 3000.00);
        System.out.println(st.toString());

        st.setAdress("RUA XV de novembro 99");
        st.setPay(1500);
        st.setSchool("FATEC");

        System.out.println("Nome: " + st.getName());
        System.out.println("Endereço: " + st.getAddress());
        System.out.println("Escola: " + st.getSchool());
        System.out.println("Pagamento: " + st.getPay());
    }
}
