package com.feign.example.service;

import com.feign.example.handler.GreetHandler;
import org.springframework.stereotype.Service;

@Service
public class GreetService {

    private GreetHandler handler;

    public GreetService(GreetHandler handler) {
        this.handler = handler;
    }

    public String greet() {
        return handler.greet();
    }
}
