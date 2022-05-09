package Banco_Itau;

import java.io.File;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Leitura {
  private int QUANTIDADE_VARIAVEIS = 11;
  private BancoDeDados banco;
  
  public Leitura(String caminho) 
  {
    banco = new BancoDeDados();
    
    try {
      File file = new File(caminho);
  
      Scanner input = new Scanner(file);
  
      int linhas = 0;

      String templateVariaveis[] = new String[QUANTIDADE_VARIAVEIS];
      
      while (input.hasNextLine()) {
        String linha = input.nextLine();

        // Tratar variaveis de entrada
        if (linhas++ == 0) {
          templateVariaveis = linha.split("\\|");
          continue;
        }
        
        if (linha.length() == 0) 
        {
          continue;
        }

        Map<String, String> varTransf = new HashMap<String, String>();
        String tokensEntrada[] = linha.split("\\|"); 
        for (int index = 0; index < tokensEntrada.length; index++) 
        {
          String template = templateVariaveis[index];
          varTransf.put(template, tokensEntrada[index]);
        }

        Pessoa emissor = new Pessoa(
          varTransf.get("nome_emissor"), 
          varTransf.get("cpf_emissor"), 
          varTransf.get("agencia_emissor")
        );

        Pessoa receptor = new Pessoa(
          varTransf.get("nome_receptor"), 
          varTransf.get("cpf_receptor"), 
          varTransf.get("agencia_recptor")
        );
        
        if (banco.getPessoa(varTransf.get("cpf_emissor")) == null) {
          banco.addPessoa(emissor);
        }

        if (banco.getPessoa(varTransf.get("cpf_receptor")) == null) {
          banco.addPessoa(receptor);
        }
  
        if (banco.getConta(varTransf.get("agencia_emissor"), varTransf.get("conta_emissor")) == null) {
          ContaBancaria p = new ContaBancaria(emissor, varTransf.get("agencia_emissor"), varTransf.get("conta_emissor"));
          banco.addConta(p);
        }

        if (banco.getConta(varTransf.get("agencia_receptor"), varTransf.get("conta_receptor")) == null) {
          ContaBancaria p = new ContaBancaria(receptor, varTransf.get("agencia_receptor"), varTransf.get("conta_receptor"));
          banco.addConta(p);
        }

        banco.transferirDinheiro(
          varTransf.get("agencia_emissor"),
          varTransf.get("conta_emissor"),
          varTransf.get("agencia_receptor"),
          varTransf.get("conta_receptor"),
          Double.parseDouble(varTransf.get("valor_transferencia")),
          varTransf.get("tipo_transferencia"));
      }
      input.close();
    }
    catch (Exception e) 
    {
      e.printStackTrace();
    }
  }
}