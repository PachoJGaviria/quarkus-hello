package co.com.pachojgaviria;

import co.com.pachojgaviria.infrastructure.api.GreetingResourceTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeGreetingResourceIT extends GreetingResourceTest {

  // Execute the same tests but in native mode.
}