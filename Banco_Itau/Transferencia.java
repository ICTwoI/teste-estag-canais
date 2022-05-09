package Banco_Itau;

class Transferencia {  
	  public static void pix (ContaBancaria conta_emissor, ContaBancaria conta_receptor, double valor) throws Exception {
	    if (valor <= 0 || valor >= 5000) {
	      throw new Exception("Sua transferência não foi completada, pois o valor é considerado inválido para transferência PIX");
	    }

	    conta_emissor.addSaldo(valor * -1);
	    conta_receptor.addSaldo(valor);
	  }

	  public static void ted (ContaBancaria conta_emissor, ContaBancaria conta_receptor, double valor) throws Exception {
	    if (valor <= 5000 || valor >= 10000) {
	      throw new Exception("Sua transferência não foi completada, pois o valor é considerado inválido para transferência TED");
	    }

	    conta_emissor.addSaldo(valor * -1);
	    conta_receptor.addSaldo(valor);
	  }

	  public static void doc (ContaBancaria conta_emissor, ContaBancaria conta_receptor, double valor) throws Exception {
	    if (valor <= 10000) {
	      throw new Exception("Sua transferência não foi completada, pois o valor é considerado inválido para transferência DOC");
	    }

	    conta_emissor.addSaldo(valor * -1);
	    conta_receptor.addSaldo(valor);
	  }
}
