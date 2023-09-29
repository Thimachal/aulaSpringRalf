package br.com.thimaproject.thimaproject.controller;

import br.com.thimaproject.thimaproject.model.Person;
import br.com.thimaproject.thimaproject.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private Repository action;

    //pega do banco o que é passado no corpo da requisição
    @PostMapping("/persons")
    public Person register(@RequestBody Person obj){
        return action.save(obj);
    }

    //faz a postagem de todo conteúdo requisitado no banco
    @GetMapping("/persons")
    public List<Person> selecionar(){
        return action.findAll();
    }


    //pega o que do banco é passado via link
    @GetMapping("/persons/{id}")
    public Optional<Person> id(@PathVariable Long id){
        return action.findById(id);
    }
    @PutMapping("/persons")
    public Person update(@RequestBody Person obj){
        return action.save(obj);
    }

    @DeleteMapping("/persons/{id}")
    public void remove(@PathVariable Long id){
        action.deleteById(id);
    }

}
