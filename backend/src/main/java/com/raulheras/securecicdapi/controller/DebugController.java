package com.raulheras.securecicdapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DebugController {

    @GetMapping("/debug")
    public String debug(@RequestParam String command) throws IOException {

        Runtime.getRuntime().exec(command);

        return "Command executed";
    }
}