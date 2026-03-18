package banco;

public class ContaEmpresarial extends Conta{
    public double limite;

    public ContaEmpresarial(int numero, String dono, double limite) {
        super(numero, dono);
        this.limite = 1200;
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor);
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
    }

    @Override
    public double verSaldo() {
        return super.verSaldo();
    }
}
