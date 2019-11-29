package co.com.pachojgaviria.domain;

public class Greeting {

  private final String name;

  public Greeting(String name) {
    this.name = name;
  }

  public String greeting() {
    return String.format("Hello %s", name);
  }

}