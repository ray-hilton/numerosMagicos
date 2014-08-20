package com.gotoagile.csd;

import com.gotoagile.csd.helpers.*;
import com.gotoagile.csd.acontecimentos.*;
import java.util.*;

public class RotinaDeProgramador{

  private ConsoleHelper cor = new ConsoleHelper();

  public static void main(String[] args){
    new RotinaDeProgramador().start();
  }

  public void start(){
    ArrayList<AcontecimentoBase> acontecimentos = getAcontecimentos();
    System.out.println("Iniciando CSD de testes...");
    Integer humorAtual = 10;
    System.out.print(cor.bold(cor.blue("Humor Inicial: ")));
    System.out.println(cor.bold(cor.white(humorAtual + " pontos.")));

    for(AcontecimentoBase acontecimento: getAcontecimentos())
      humorAtual = acontecimento.exibeEscolha(humorAtual);

    Extenso extenso = new Extenso(new Double(humorAtual));
    System.out.print(cor.bold(cor.blue("Você terminou o dia com " + extenso.toString() + " de humor")));
  }

  private ArrayList<AcontecimentoBase> getAcontecimentos(){
    ArrayList<AcontecimentoBase> acontecimentos = new ArrayList<AcontecimentoBase>();
    acontecimentos.add(new Despertar());
    return acontecimentos;
  }
}