package com.gotoagile.csd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.*;
import java.io.*;

public class RotinaDeProgramadorTests {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
  }

  @After
  public void cleanUpStreams() {
      System.setOut(null);
      System.setErr(null);
  }

  @Test
  public void testaSaidaInicialDoConsole() {
    //new RotinaDeProgramador().start();
    //assertThat("Conseguimos iniciar o dia de testes do CSD!", outContent.toString(), containsString("Iniciando CSD de testes..."));
  }


}