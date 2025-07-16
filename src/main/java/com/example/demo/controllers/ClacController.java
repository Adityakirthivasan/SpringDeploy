package com.example.demo.controllers;

import com.example.demo.models.Calc;
import com.example.demo.service.ClacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class ClacController {

    @Autowired
    private ClacService clacService;

    @PostMapping("/add")
    public int add(@RequestBody Calc calc) {
        return clacService.add(calc.getA(), calc.getB());
    }

    @PostMapping("/sub")
    public int sub(@RequestBody Calc calc) {
        return clacService.sub(calc.getA(), calc.getB());
    }

    @PostMapping("/mul")
    public int mul(@RequestBody Calc calc) {
        return clacService.mul(calc.getA(), calc.getB());
    }

    @PostMapping("/div")
    public int div(@RequestBody Calc calc) {
        return clacService.div(calc.getA(), calc.getB());
    }
}
