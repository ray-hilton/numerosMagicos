package com.gotoagile.csd.acontecimentos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.*;
import java.io.*;

public class DespertarTests {

  private Despertar despertar;

  @Before
  public void setUp(){
    despertar = new Despertar();
  }

  @Test
  public void testaModificadorDeHumor() {
    assertEquals("A primeira opção aumenta a pontuação de humor", despertar.getModificadorDeHumor(1), new Integer(2));
    assertEquals("A segunda opção diminui a pontuação de humor", despertar.getModificadorDeHumor(2), new Integer(-2));
  }

  @Test
  public void testaNumeroDeOpcoes() {
    assertEquals("O acontecimento de despertar tem apenas duas opções", despertar.getOpcoes().size(), 2);
  }
}