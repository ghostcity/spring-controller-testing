package de.informaticum;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = MOCK, properties = "spring.main.web-application-type=reactive")
@AutoConfigureWebTestClient
public class HelloWorldControllerAutoConfigureWebTestClientWithMockedServerTest {

    @Test
    public final void testPing(@Autowired final WebTestClient client)
    throws Exception {
        client.get().uri("/hello/world").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("Hello World!");
    }

}
