package banco;

abstract public class Conta {
    static public double juros;

    public int numero;
    public String dono;
    private double saldo;
    public double limite;

    public String tipo;
    public Conta(int numero, String dono){
        System.out.println("Criando a uma nova conta");
        this.numero = numero;
        this.dono = dono;
        this.saldo = 0;
    }



    public void sacar(double valor){
        if(valor < 0){
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }

        if(valor <= this.saldo) {
            this.saldo = this.saldo - valor;
        }else{
            IllegalStateException erro = new IllegalStateException();
            throw erro;
        }

    }

    public void depositar(double valor){
        if(valor < 0){
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }
        this.saldo  = this.saldo + valor;
    }

    public double verSaldo(){
        return this.saldo;
    }


}
