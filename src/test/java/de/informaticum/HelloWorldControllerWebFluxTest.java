package de.informaticum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(HelloWorldController.class)
public class HelloWorldControllerWebFluxTest {

    @Test
    public final void testPing(@Autowired final WebTestClient client)
    throws Exception {
        client.get().uri("/hello/world").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("Hello World!");
    }

}
