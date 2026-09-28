import java.util.UUID;

public class Aluno {

    private UUID id;
    private String nome;

    public Aluno(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome;
    }
}