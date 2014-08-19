package com.gotoagile.csd.acontecimentos;

import java.util.*;

public class CafeDaManha extends AcontecimentoBase{
  
  public Integer getModificadorDeHumor(Integer opcao){
    Integer modificadorDeHumor = 0;
    /**
    Você pode utilizar o método getHumorAtual() da classe AcontecimentoBase nesse trecho.
    **/
    return modificadorDeHumor;
  }

  public Map<Integer, String> getOpcoes(){
    HashMap<Integer, String> opcoes = new HashMap<Integer, String>();
    return opcoes;
  }

  public String getDescricaoInicial(){
    return "O trânsito caótico de uma cidade decadente já faz parte do cotidiano, mas segue um inimigo implacável e comum algoz do seu bom humor. A energia necessária para enfrentar esse velho rival vem de seu desjejum, e hoje você opta por comer: ";
  }

  public String getResultadoPositivo(){
    return "";
  }

  public String getResultadoNegativo(){
    return "";
  }
}