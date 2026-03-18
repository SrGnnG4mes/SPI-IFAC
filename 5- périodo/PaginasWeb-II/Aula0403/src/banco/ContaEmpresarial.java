package banco;

public class ContaEmpresarial extends Conta{

    public ContaEmpresarial(int numero,String dono){
        super(numero,dono);
        this.limite = 1200;
    }


}
