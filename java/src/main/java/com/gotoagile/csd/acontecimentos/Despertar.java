package com.gotoagile.csd.acontecimentos;

import java.util.*;

public class Despertar extends AcontecimentoBase{
  
  public Integer getModificadorDeHumor(Integer opcao){
    Integer modificadorDeHumor = 0;
    switch(opcao){
      case 1:
        modificadorDeHumor = 2;
        break;
      case 2:
        modificadorDeHumor = -2;
        break;
    }

    return modificadorDeHumor;
  }

  public Map<Integer, String> getOpcoes(){
    HashMap<Integer, String> opcoes = new HashMap<Integer, String>();
    opcoes.put(1, "Levanta Imediatamente sem nem mesmo se espreguiçar");
    opcoes.put(2, "Liga a função soneca e volta a dormir por só mais 9 minutos");
    return opcoes;
  }

  public String getDescricaoInicial(){
    return "São 6:15 da manhã de uma segunda-feira. Enquanto os primeiros raios de sol começam a trespassar a persiana metálica na janela seu despertador dá início à sinfonia do desespero em um crescendo insuportável. Nesse momento, você:";
  }

  public String getResultadoPositivo(){
    return "135 milissegundos. O despertador não toca mais. 2,3 segundos e você está de pé após um rápido movimento de kung-fu. O horário não é aquele que você está acostumado a acordar, mas você se adapta imediatamente, como água.";
  }

  public String getResultadoNegativo(){
    return "Sua trépida mão esquerda tenta em vão calar o smartphone, mas a insônia consumiu o melhor de suas habilidades motoras. As memórias da noite chuvosa de domingo são turvas, mas o sabor amargo de bile e azia constante antecipam como será essa longa segunda-feira.";
  }
}