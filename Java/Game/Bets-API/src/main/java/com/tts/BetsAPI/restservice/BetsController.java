package com.tts.BetsAPI.restservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class BetsController {

    // 📝 Counter for id
    private final AtomicLong counter = new AtomicLong();
}

