package banco;

public class ContaEmpresarial extends ContaInvestimento{

    public ContaEmpresarial(int numero,String dono){
        super(numero,dono);
        this.limite = 1200;
    }


}
