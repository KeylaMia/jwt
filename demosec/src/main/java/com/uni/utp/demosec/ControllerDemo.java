package com.uni.utp.demosec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ControllerDemo {

    @GetMapping("/hola")
    public String ejecutarHola() {
        return "hola";
    }
}