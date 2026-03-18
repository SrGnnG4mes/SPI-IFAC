package banco;

import java.util.List;

public class Promocoes {

    public void invest102026(List<Conta> contas){

        for (Conta conta: contas) {
            if(conta instanceof ContaInvestimento){
                ContaInvestimento contaInvestimento = (ContaInvestimento)conta;
                contaInvestimento.investir(10);
            }

        }

    }

}
