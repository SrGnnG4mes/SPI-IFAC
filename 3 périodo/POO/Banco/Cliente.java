package Banco;

public class Cliente {
    String nome;
    String cpf;
    String endereco;
    String dataNascimento;

    @Override
    public String toString() {
        String relatorio = "Nome: " + this.nome;
        relatorio += "\nCPF: " + this.cpf;
        relatorio += "\nEndereço: " + this.endereco;
        relatorio += "\nData de Nascimento: " + this.dataNascimento;
        return relatorio;
    }

}
