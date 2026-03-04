package banco;

public class Conta {
    public int numero;
    public String dono;
    private double saldo;
    public double limite;

    public void sacar(double valor){
        if (valor <= this.saldo){
            this.saldo = this.saldo - valor;
        }else{
            RuntimeException erro = new RuntimeException();
            throw erro;
        }
    }
    public void depositar(double valor){
        this.saldo = this.saldo + valor;
    }
    public double verSaldo(){
     return this.saldo;
    }
}
