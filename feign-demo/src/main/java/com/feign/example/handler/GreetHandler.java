package com.feign.example.handler;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="GREET-SERVICE")
public interface GreetHandler {

    @GetMapping("/greet")
    public String greet();
}
