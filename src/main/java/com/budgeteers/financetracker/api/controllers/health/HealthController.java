package com.budgeteers.financetracker.api.controllers.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    private static int counter = 0;

    @GetMapping("/hello")
    public String hello() {
        counter++;
        return "hello";
    }

}
