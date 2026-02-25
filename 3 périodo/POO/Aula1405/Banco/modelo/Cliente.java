package modelo;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String dataNascimento;

    @Override
    public String toString() {
        String relatorio = "Nome: " + this.nome;
        relatorio += "\nCPF: " + this.cpf;
        relatorio += "\nEndereço: " + this.endereco;
        relatorio += "\nData de Nascimento: " + this.dataNascimento;
        return relatorio;
    }

}
