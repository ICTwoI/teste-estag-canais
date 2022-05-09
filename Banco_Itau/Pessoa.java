package Banco_Itau;

import java.util.ArrayList;

class Pessoa {
  private String Nome;
  public String CPF;
  private String Agencia;
  private ArrayList<ContaBancaria> Contas;
  
  public Pessoa(String Nome, String CPF, String Agencia)
  {
    this.Nome = Nome;
    this.CPF = CPF;
    this.Agencia = Agencia;
  }

  public String getNome() {
    return Nome;
  }

  public String getCPF() {
    return CPF;
  }

  public String getAgencia() {
    return Agencia;
  }

  public void setNome(String Nome) {
    this.Nome = Nome;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public void setAgencia(String Agencia) {
    this.Agencia = Agencia;
  }

  public void addConta(ContaBancaria conta) {
    Contas.add(conta);
  }
}