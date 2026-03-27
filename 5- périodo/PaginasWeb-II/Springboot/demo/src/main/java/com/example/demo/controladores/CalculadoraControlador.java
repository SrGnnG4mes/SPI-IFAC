package com.example.demo.controladores;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraControlador {

    @GetMapping("/oiMundo")
    public String oiMundo(){
        return "Olá Mundo!";
    }

    @GetMapping("/somar")
    public int somar(@RequestParam("num1")int num1, @RequestParam("num2")int num2){

        return num1 + num2;
    }

    @GetMapping("/somar/{num1}/{num2}")
    public int somar2(@PathVariable("num1")int num1, @PathVariable("num2")int num2){
        return num1 + num2;
    }

    @GetMapping("/subtrair/{num1}/{num2}")
    public int subtrair(@PathVariable("num1")int num1, @PathVariable("num2")int num2){
        return num1 - num2;
    }

    @GetMapping("/multiplicar/{num1}/{num2}")
    public int multiplicar(@PathVariable("num1")int num1, @PathVariable("num2")int num2){
        return num1 * num2;
    }

    @GetMapping("/dividir/{num1}/{num2}")
    public int dividir(@PathVariable("num1")int num1, @PathVariable("num2")int num2){
        return num1 / num2;
    }

}
