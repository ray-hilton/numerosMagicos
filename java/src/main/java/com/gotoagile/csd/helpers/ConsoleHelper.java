package com.gotoagile.csd.helpers;

public class ConsoleHelper {
  private static final String NORMAL = "\033[0;0m";
  private static final String BOLD = "\033[0;1m";
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_BLACK = "\u001B[30m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_BLUE = "\u001B[34m";
  private static final String ANSI_PURPLE = "\u001B[35m";
  private static final String ANSI_CYAN = "\u001B[36m";
  private static final String ANSI_WHITE = "\u001B[37m";

  public String bold(String string){
    return BOLD + string + ANSI_RESET;
  }

  public String blue(String string){
    return ANSI_BLUE + string + ANSI_RESET;
  }

  public String black(String string){
    return ANSI_BLACK + string + ANSI_RESET;
  }

  public String red(String string){
    return ANSI_RED + string + ANSI_RESET;
  }

  public String green(String string){
    return ANSI_GREEN + string + ANSI_RESET;
  }

  public String yellow(String string){
    return ANSI_YELLOW + string + ANSI_RESET;
  }

  public String purple(String string){
    return ANSI_PURPLE + string + ANSI_RESET;
  }

  public String cyan(String string){
    return ANSI_CYAN + string + ANSI_RESET;
  }

  public String white(String string){
    return ANSI_WHITE + string + ANSI_RESET;
  }
}