package co.com.pachojgaviria.infrastructure.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.pachojgaviria.application.GetGreeting;
import co.com.pachojgaviria.domain.Greeting;

@Path("/hello")
public class GreetingResource {

  @Inject
  GetGreeting getGreeting;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/{name}")
  public String hello(@PathParam("name") final String name) {
    return getGreeting.getGreeting(name).greeting();
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return getGreeting.getGreeting("world").greeting();
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/async/{name}")
  public CompletionStage<String> helloAsync(@PathParam("name") final String name) {
    return getGreeting.getGreetingAsync(name).thenApply((final Greeting greeting) -> greeting.greeting());
  }
}