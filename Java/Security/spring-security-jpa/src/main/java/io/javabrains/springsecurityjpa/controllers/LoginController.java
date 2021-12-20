package io.javabrains.springsecurityjpa.controllers;

import io.javabrains.springsecurityjpa.models.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LoginController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
//
//    @PostMapping("/login")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @PostMapping("/login")
    public String sayHello() {
        return "Hello React!";
    }
}
