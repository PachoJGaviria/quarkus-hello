package co.com.pachojgaviria.application;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import co.com.pachojgaviria.domain.*;
import io.netty.util.concurrent.CompleteFuture;

@ApplicationScoped
public class GetGreeting {

  public Greeting getGreeting(String name) {
    return new Greeting(name);
  }

  public CompletionStage<Greeting> getGreetingAsync(String name) {
    return CompletableFuture.supplyAsync(() -> new Greeting(name));
  }

}