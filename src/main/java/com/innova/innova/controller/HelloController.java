package com.innova.innova.controller;

import com.innova.innova.dto.HelloDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {


    @GetMapping("{nombre}")
    public HelloDto hello(@PathVariable("nombre") String nombre) {
        return new HelloDto(nombre);
    }





}
