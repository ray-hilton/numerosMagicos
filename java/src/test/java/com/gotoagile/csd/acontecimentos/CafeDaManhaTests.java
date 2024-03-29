package com.gotoagile.csd.acontecimentos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;

import org.junit.*;
import java.io.*;

public class CafeDaManhaTests {

  private CafeDaManha cafe;

  @Before
  public void setUp(){
    cafe = spy(new CafeDaManha());
  }

  @Test
  public void testaModificadorDeHumor() {
    
  }

  @Test
  public void testaNumeroDeOpcoes() {
    
  }

  @Test
  public void testaStubDoHumorAtual() {
    when(cafe.getHumorAtual()).thenReturn(new Integer(5));
    assertEquals("Teste de stubs utilizando o Mockito", new Integer(5), cafe.getHumorAtual());
  }

}