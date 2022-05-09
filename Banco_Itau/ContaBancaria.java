package Banco_Itau;

class ContaBancaria {
	  private Pessoa dono;
	  private double saldo;
	  private double chequeEspecial;
	  private String agencia;
	  private String numConta;

	  public ContaBancaria (Pessoa dono, String agencia, String numConta) {
	    this.dono = dono;
	    this.saldo = 0;
	    this.chequeEspecial = 0;
	    this.agencia = agencia;
	    this.numConta = numConta;
	  }

	  public String getAgencia (){
	    return agencia;
	  }

	  public String getNumConta (){
	    return numConta;
	  }
	  
	  public double getSaldo (){
	    return saldo;
	  }

	  public void addSaldo (double valor){
	    saldo += valor;

	    if (saldo < 0) {
	      addChequeEspecial(saldo * -1);
	      saldo = 0;
	    }
	  }

	  public void addChequeEspecial (double valor){
	    chequeEspecial += valor;
	  }
	}