package banco;

public class ContaUniversitaria extends Conta {

    public ContaUniversitaria(int numero, String dono) {
        super(numero, dono);
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
