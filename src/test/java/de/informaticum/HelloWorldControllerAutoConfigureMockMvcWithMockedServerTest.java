package de.informaticum;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc
public class HelloWorldControllerAutoConfigureMockMvcWithMockedServerTest {

    @Test
    public final void testPing(@Autowired final MockMvc mvc)
    throws Exception {
        mvc.perform(get("/hello/world")).andExpect(status().isOk()).andExpect(content().string("Hello World!"));
    }

}
