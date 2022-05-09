package Banco_Itau;

import java.util.ArrayList;

class BancoDeDados {
  private ArrayList<Pessoa> pessoas;
  private ArrayList<ContaBancaria> contas;

  public BancoDeDados() {
    pessoas = new ArrayList<Pessoa>();
    contas = new ArrayList<ContaBancaria>();
  }

  public void addPessoa (Pessoa pessoa){
    pessoas.add(pessoa);
  }
  public void addConta (ContaBancaria conta){
    contas.add(conta);
  }

  public Pessoa getPessoa(String cpf) {
    for (Pessoa pessoa : pessoas) {  
      if (pessoa.getCPF().equals(cpf)){
        return pessoa;
      }
    }

    return null;
  }

  public ContaBancaria getConta(String agencia, String numConta) throws Exception {
    for (ContaBancaria conta : contas) {      
      if (conta.getAgencia().equals(agencia) && conta.getNumConta().equals(numConta)){
        return conta;
      }
    }

    return null;
  }

  public void transferirDinheiro(
    String agencia_emissor,
    String conta_emissor, 
    String agencia_receptor,
    String conta_receptor, 
    double valor,
    String tipo) throws Exception {
    
      ContaBancaria cEmissor = getConta(agencia_emissor, conta_emissor);
      ContaBancaria cReceptor = getConta(agencia_receptor, conta_receptor);

      if (agencia_emissor == agencia_receptor && conta_emissor == conta_receptor) {
        throw new Exception("Contas iguais!");
      }
    
      switch(tipo) {
        case "PIX":
          try {
            Transferencia.pix(cEmissor, cReceptor, valor);
          } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
          }
          break;
        case "TED":
          try {
            Transferencia.ted(cEmissor, cReceptor, valor);
          } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
          }
          break;
        case "DOC":
          try {
            Transferencia.doc(cEmissor, cReceptor, valor);
          } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
          }
          break;
      }

      System.out.println("Sucesso ao realizar transferência.");
      System.out.println("Saldo emissor: R$ " + cEmissor.getSaldo());
      System.out.println("Saldo receptor: R$ " + cReceptor.getSaldo());
  }
}