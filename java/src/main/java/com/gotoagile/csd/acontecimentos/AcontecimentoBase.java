package com.gotoagile.csd.acontecimentos;

import com.gotoagile.csd.helpers.ConsoleHelper;
import java.util.*;
import java.io.*;

public abstract class AcontecimentoBase{
  private Map<Integer, String> opcoes;
  private ConsoleHelper cor;
  private Integer humorAtual;

  public AcontecimentoBase(){
    private final int casa1;
    cor = new ConsoleHelper();
  }

  public Integer exibeEscolha(Integer pHumorAtual){
    humorAtual = pHumorAtual;
    System.out.println(cor.bold(cor.green("********************************************************************")));
    System.out.println(cor.bold(cor.green("********************************************************************")));
    System.out.println(cor.white(getDescricaoInicial()));

    for(Map.Entry<Integer, String> opcao : getOpcoes().entrySet()){
      System.out.println("");
      System.out.print(cor.bold(cor.yellow(opcao.getKey().toString()) + " - "));
      System.out.println(opcao.getValue());
      System.out.println("");
    }

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    Integer escolha = -1;

    while(escolha < 0){
      try{
        escolha = Integer.parseInt(input.readLine());
      }catch(Exception ex){

      }
    }

    return realizaEscolha(escolha, humorAtual);
  }

  public Integer realizaEscolha(Integer opcao, Integer humorAtual){
    Integer modificador = getModificadorDeHumor(opcao);

    if(modificador < 0){
      System.out.println(cor.red(getResultadoNegativo()));
      System.out.println(cor.bold(cor.red("Seu humor foi alterado em " + modificador + " pontos.")));
    }
    else{
      System.out.println(cor.green(getResultadoPositivo()));
      System.out.println(cor.bold(cor.green("Seu humor foi alterado em " + modificador + " pontos.")));
    }

    return modificador + humorAtual;
  }

  protected Integer getHumorAtual(){
    return humorAtual;
  }

  public abstract Integer getModificadorDeHumor(Integer opcao);
  public abstract Map<Integer, String> getOpcoes();
  public abstract String getDescricaoInicial();
  public abstract String getResultadoPositivo();
  public abstract String getResultadoNegativo();
}