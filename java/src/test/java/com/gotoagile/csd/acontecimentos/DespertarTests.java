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
    assertEquals("Conseguimos iniciar o dia de testes do CSD!", despertar.getModificadorDeHumor(1), new Integer(2));
    assertEquals("Conseguimos iniciar o dia de testes do CSD!", despertar.getModificadorDeHumor(2), new Integer(-2));
  }


}