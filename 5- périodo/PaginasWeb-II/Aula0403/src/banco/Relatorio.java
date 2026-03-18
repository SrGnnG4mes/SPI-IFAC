package banco;

import java.util.List;

public class Relatorio {

    public void imprimirValoresDasContas(List<Conta> contas){

        for (Conta conta:  contas) {

            System.out.println("O cliente " + conta.dono +
                    " tem R$" + conta.verSaldo() );
        }
    }

}
