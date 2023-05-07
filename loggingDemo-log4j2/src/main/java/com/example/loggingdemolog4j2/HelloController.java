package com.example.loggingdemolog4j2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/")
    public String main() {
        log.debug("Hello from Log4j 2 - num : {}");

        return "welcome";
    }
}
