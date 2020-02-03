package de.informaticum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public final class HelloWorldController {

    @GetMapping(path = "/world")
    public final String greeting() {
        return "Hello World!";
    }

}
