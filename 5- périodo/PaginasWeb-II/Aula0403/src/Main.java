import banco.Conta;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        /*Funcionario funcionario = new Funcionario();
        funcionario.primeiroNome = "João";
        funcionario.ultimoNome = "Tamborini";
        funcionario.idade = 25;
        System.out.println(funcionario.mostrarNome());*/

        Conta conta = new Conta();
        conta.depositar(10000);
        try{
            conta.sacar(50000);
        }catch (RuntimeException erro){
            System.out.println("Valor de saldo insulficiente");
        }

        System.out.println(conta.verSaldo());

    }
}