package de.informaticum;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HelloWorldControllerWithManualMockMvcTest {

    private MockMvc mvc;

    @BeforeEach
    public final void initClient() {
        this.mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public final void testPing()
    throws Exception {
        this.mvc.perform(get("/hello/world")).andExpect(status().isOk()).andExpect(content().string("Hello World!"));
    }

}
