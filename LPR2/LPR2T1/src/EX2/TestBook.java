package EX2;

public class TestBook {

    public static void main(String[] args) {
        // Crie e aloque o array de autores.
        Author[] authors = new Author[2];
        authors[0] = new Author("Machado de Assis", "autor01@email.com.br", 'm');
        authors[1] = new Author("William Shakespeare", "autor02@email.com.br", 'm');
        // Declarar e alocar a instância de um book.
        Book testeBook = new Book("Dom Casmurro", authors, 19.99, 99);
        System.out.println(testeBook); // toString()

    }
}
