# Various Approaches of Spring Controller Testing

This small repository provides some example Spring Boot Tests verifying the correct implementation of [a very simple `RestController`](./src/main/java/de/informaticum/HelloWorldController.java).
(If you are new to this topic, you can start with this ["Building a RESTful Web Service" tutorial](https://spring.io/guides/gs/rest-service/).)

The tests can be done [with a manually wired `MockMvc` client](./src/test/java/de/informaticum/HelloWorldControllerWithManualMockMvcTest.java) or with a [with a manually wired `WebTestClient` client](./src/test/java/de/informaticum/HelloWorldControllerWithManualWebTestClientTest.java).

[If the class creation is under the control of Spring](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications), the `MockMvc` client will by automatically wired and then [can be run against a mocked servlet](./src/test/java/de/informaticum/HelloWorldControllerAutoConfigureMockMvcWithMockedServerTest.java) or [an embedded server](./src/test/java/de/informaticum/HelloWorldControllerAutoConfigureMockMvcWithEmbeddedServerTest.java).
Similar, `WebTestClient` client will by automatically wired and then [can be run against a mocked servlet](./src/test/java/de/informaticum/HelloWorldControllerAutoConfigureWebTestClientWithMockedServerTest.java) or [an embedded server](./src/test/java/de/informaticum/HelloWorldControllerAutoConfigureWebTestClientWithEmbeddedServerTest.java). (Both approaches are described [here (mock environment)](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-with-mock-environment) and [here (running server)](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-with-running-server).)

However, the straight-forward solution to test by `MockMvc` is to [run a `WebMvcTest`](./src/test/java/de/informaticum/HelloWorldControllerWebMvcTest.java).
Correspondingly, the straight-forward solution to test by `WebTestClient` is to [run a `WebFluxTest`](./src/test/java/de/informaticum/HelloWorldControllerWebFluxTest.java).

In order to see all the tests succeeding, just check out and run `mvn test`.

- Note #1: Thanks to [JUnit5's Extension Model](https://junit.org/junit5/docs/current/user-guide/#extensions), the `RunWith` annotation is not required anymore.
- Note #2: Since JUnit5 supports n-ary test methods, the `Autowired` clients might be provided as a test method parameter or (not shown in the code) might be declared as test class fields. (Also annotated with `Autowired`.)
- Note #3: This simple Maven project specifies a MVC controller but additionally uses WebFlux for testing.
[Spring explicitly allows both modules to be used simultaneously](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-webflux ) – but one is preferred over the other.
Thus, if the WebTestClient requires a WebFlux Context, [the `spring.main.web-application-type` must be specified accordingly](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-detecting-web-app-type).
