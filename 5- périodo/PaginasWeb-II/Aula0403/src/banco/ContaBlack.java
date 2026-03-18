package banco;

public class ContaBlack extends ContaInvestimento{

    public boolean cartaoCredito;

    public ContaBlack(int numero,String dono){
        super(numero,dono);
        this.limite = 10000;

    }
}
