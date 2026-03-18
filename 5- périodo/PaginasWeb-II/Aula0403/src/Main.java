import banco.Conta;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1, "João");

        try{
            conta1.depositar(10000);
        } catch (IllegalArgumentException erro){
            System.out.println("O valor para depósito deve ser maior que 0");
        }

        try{
            conta1.sacar(500);
        }catch (RuntimeException erro) {
            System.out.println("Valor de saldo insulficiente");
        }

        System.out.println(conta1.verSaldo());

        Conta conta2 = new Conta(2, "Ana");

    }
}