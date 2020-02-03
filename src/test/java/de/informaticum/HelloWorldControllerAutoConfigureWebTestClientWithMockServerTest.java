package de.informaticum;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @see https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications
 * @see https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-with-mock-environment
 */
@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureWebTestClient
public class HelloWorldControllerAutoConfigureWebTestClientWithMockServerTest {

    @Test
    public final void testPing(@Autowired final WebTestClient client)
    throws Exception {
        client.get().uri("/hello/world").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("Hello World!");
    }

}
