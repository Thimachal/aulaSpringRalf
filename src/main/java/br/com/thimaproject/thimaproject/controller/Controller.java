package br.com.thimaproject.thimaproject.controller;

import br.com.thimaproject.thimaproject.model.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping
    public String mensseger(){
       int num = 1+4;
        return String.valueOf(num);
    }

    @GetMapping("/{name}")
    public String menssegerUrl(@PathVariable String name){
        String phrase = "Eu sou programador Java, meu nome é: ";
        return phrase + "Thima";
    }

    @PostMapping("/person")
    public Person person(@RequestBody Person p){
        return p;
    }
}
