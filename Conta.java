package Banco;

public class Conta extends Pessoa {
    // atributos

    private double saldo;
    private int conta, Agencia;
    
    // construtor
    public Conta(double saldo, int conta, int Agencia, String Titular, String CPF){
        super(Titular, CPF);
        this.saldo = saldo;
        this.conta = conta;
        this.Agencia = Agencia;
    }

    // getters
    public double getSaldo(){
        return this.saldo;
    }
    public int getConta(){
        return this.conta;
    }

    public int getAgencia(){
        return this.Agencia;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setConta(int conta){
        this.conta = conta;
    }

    public void setAgencia(int Agencia){
        this.Agencia = Agencia;
    }


    // metodos
    public void Depositar(double valor){
        if (valor < 0){
            throw new RuntimeException("Favor, digite um valor positivo");
        }
         saldo = saldo + valor;   
    }
    
}
