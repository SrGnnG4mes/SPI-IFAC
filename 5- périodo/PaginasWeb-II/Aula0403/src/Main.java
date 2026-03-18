import banco.Conta;
import banco.ContaEmpresarial;
import banco.ContaUniversitaria;
import banco.Relatorio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Conta conta1 = new ContaUniversitaria(1,"João");
        conta1.depositar(500);
        conta1.sacar(100);
        System.out.println(conta1.verSaldo());

        Conta conta2 = new ContaEmpresarial(2,"Ana");
        conta2.depositar(600);
        conta2.sacar(50);
        System.out.println(conta2.verSaldo());

        Conta conta3 = new ContaUniversitaria(3,"Carlos");
        conta3.depositar(100);
        conta3.sacar(50);
        System.out.println(conta3.verSaldo());

        Conta conta4 = new ContaEmpresarial(4,"Roberto");
        conta4.depositar(6000);
        conta4.sacar(50);
        System.out.println(conta4.verSaldo());

        List<Conta> contas = new ArrayList<Conta>();
        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);

        Relatorio relatorio = new Relatorio();
        relatorio.imprimirValoresDasContas(contas);

    }


}