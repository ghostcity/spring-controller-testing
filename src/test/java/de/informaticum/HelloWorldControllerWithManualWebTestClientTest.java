package de.informaticum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

public class HelloWorldControllerWithManualWebTestClientTest {

    private WebTestClient client;

    @BeforeEach
    public final void initClient() {
        this.client = WebTestClient.bindToController(new HelloWorldController()).build();
    }

    @Test
    public final void testPing()
    throws Exception {
        this.client.get().uri("/hello/world").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("Hello World!");
    }

}
