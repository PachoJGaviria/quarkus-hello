package co.com.pachojgaviria.infrastructure.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

@QuarkusTest
public class GreetingResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
    .when().get("/hello")
    .then().statusCode(200).body(is("Hello world"));
  }

  @Test
  public void testHelloEndpointWithParam() {
    String name = UUID.randomUUID().toString();
    given()
    .when().get("/hello/{name}", name)
    .then().statusCode(200).body(is(String.format("Hello %s", name)));
  }

  @Test
  public void testHelloAsyncEndpointWithParam() {
    String name = UUID.randomUUID().toString();
    given()
    .when().get("/hello/async/{name}", name)
    .then().statusCode(200).body(is(String.format("Hello %s", name)));
  }
}