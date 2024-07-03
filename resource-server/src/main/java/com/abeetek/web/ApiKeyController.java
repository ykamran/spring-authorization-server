package com.abeetek.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ApiKeyController {
    @GetMapping("/apikey")
    public String getApiKey() {
        return UUID.randomUUID().toString();
    }
}