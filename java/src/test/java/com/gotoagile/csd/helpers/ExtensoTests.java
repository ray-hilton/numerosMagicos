package com.gotoagile.csd.helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.*;
import java.io.*;

public class ExtensoTests {

  @Test
  public void testaNumeroExtensoUnidade() {
    Extenso extenso = new Extenso(new Double("5"));
    assertEquals("Teste no extenso", "cinco pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoDezena() {
    Extenso extenso = new Extenso(new Double("69"));
    assertEquals("Teste no extenso", "sessenta e nove pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoCentena() {
    Extenso extenso = new Extenso(new Double("133"));
    assertEquals("Teste no extenso", "cento e trinta e três pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoMilhar() {
    Extenso extenso = new Extenso(new Double("1674"));
    assertEquals("Teste no extenso", "hum mil e seiscentos e setenta e quatro pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoDezenaMilhar() {
    Extenso extenso = new Extenso(new Double("12345"));
    assertEquals("Teste no extenso", "doze mil e trezentos e quarenta e cinco pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoCentenaMilhar() {
    Extenso extenso = new Extenso(new Double("987654"));
    assertEquals("Teste no extenso", "novecentos e oitenta e sete mil e seiscentos e cinquenta e quatro pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoMilhao() {
    Extenso extenso = new Extenso(new Double("1000000"));
    assertEquals("Teste no extenso", "hum milhão de pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoDezenaMilhao() {
    Extenso extenso = new Extenso(new Double("20000000"));
    assertEquals("Teste no extenso", "vinte milhões de pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoCentenaMilhao() {
    Extenso extenso = new Extenso(new Double("310651009"));
    assertEquals("Teste no extenso", "trezentos e dez milhões e seiscentos e cinquenta e um mil e nove pontos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoDezenaCentavos() {
    Extenso extenso = new Extenso(new Double("88.41"));
    assertEquals("Teste no extenso", "oitenta e oito pontos e quarenta e um centavos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoCentenaCentavos() {
    Extenso extenso = new Extenso(new Double("720.01"));
    assertEquals("Teste no extenso", "setecentos e vinte pontos e um centavo", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoMilharCentavos() {
    Extenso extenso = new Extenso(new Double("1072.21"));
    assertEquals("Teste no extenso", "hum mil e setenta e dois pontos e vinte e um centavos", extenso.toString());
  }

  @Test
  public void testaNumeroExtensoZero() {
    Extenso extenso = new Extenso(new Double("0"));
    assertFalse("zero pontos".equals(extenso.toString()));
  }


}