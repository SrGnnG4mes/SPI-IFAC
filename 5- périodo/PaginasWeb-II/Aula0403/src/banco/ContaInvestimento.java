package banco;

public abstract class ContaInvestimento extends  Conta{

    private double investimento;

    public ContaInvestimento(int numero,String dono){
        super(numero,dono);
    }

    public void investir(double valor){
        if(valor < 0){
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }
        this.investimento  = this.investimento + valor;
    }

    public void resgatar(double valor){
        if(valor < 0){
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }

        if(valor <= this.investimento) {
            this.investimento = this.investimento - valor;
        }else{
            IllegalStateException erro = new IllegalStateException();
            throw erro;
        }
    }
}
