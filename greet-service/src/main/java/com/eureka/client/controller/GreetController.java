package com.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GreetController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/greet")
    public  String greet(){
        return "greetings from greet service!!!";
    }

    @GetMapping("/hello-worlds/{name}")
    public String getHelloWorld(@PathVariable String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances("GREET-SERVICE");
        String url=instances.get(0).getHost()+instances.get(0).getPort();
        instances.get(0).getUri().toString();
        List<String> collect = discoveryClient.getServices().stream().collect(Collectors.toList());
        return "Hello World " + instances.get(0).getUri().toString();
    }
}