
package Pessoa;

public class Pessoa {
    protected static int kp;
    protected int numero;
    protected String nome;
    protected char sexo;
    protected int idade;

    public Pessoa() {
        this.nome = "";
        this.sexo = ' ';
        this.idade = 0;
        kp++;
        this.numero = kp;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
        this.numero = kp;
    }

    public int getKp() {
        return kp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
}
