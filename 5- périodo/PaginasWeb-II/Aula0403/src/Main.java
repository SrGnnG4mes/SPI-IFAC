import banco.*;

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

        Conta conta5 = new ContaBlack(5,"Pedro Antônio");
        conta5.depositar(100);
        //conta5.investir(100);


        List<Conta> contas = new ArrayList<Conta>();
        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);
        contas.add(conta5);

        Relatorio relatorio = new Relatorio();
        relatorio.imprimirValoresDasContas(contas);

        Promocoes promocoes = new Promocoes();
        promocoes.invest102026(contas);

    }


}