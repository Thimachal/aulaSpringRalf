package br.com.thimaproject.thimaproject.controller;

import br.com.thimaproject.thimaproject.model.Client;
import br.com.thimaproject.thimaproject.model.Person;
import br.com.thimaproject.thimaproject.repository.Repository;
import br.com.thimaproject.thimaproject.repository.RepositoryClient;
import br.com.thimaproject.thimaproject.service.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private Repository action;
    @Autowired
    RepositoryClient actionClient;

    @Autowired
    private Service service;

    //pega do banco o que é passado no corpo da requisição
    @PostMapping("/persons")
    public ResponseEntity<?> register(@RequestBody Person obj){
        return service.register(obj);
    }

    //faz a postagem de todo conteúdo requisitado no banco
    @GetMapping("/persons")
    public ResponseEntity<?> selectPersons(){
        return service.selectPersons();
    }

    //pega o que do banco é passado via link
    @GetMapping("/persons/{id}")
    public ResponseEntity<?> id(@PathVariable Long id){
        return service.selectionById(id);
    }

    //rota que atualiza pessoas
    @PutMapping("/persons")
    public ResponseEntity<?> update(@RequestBody Person obj){
        return service.editPerson(obj);
    }

    //rota para deletar pessoas

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){
        return service.deletePerson(id);

    }

    @PostMapping("/client")
    public ResponseEntity<?> registerClient(@Valid @RequestBody Client objClient){
        return service.registerClients(objClient);
    }

    @GetMapping("/client")
    public ResponseEntity<?> listClients(){
        return service.listClients();
    }








    //***rotas auxiliares***//

    //mostra total de pessoas
    @GetMapping("/persons/count")
    public  Long counter(){
        return action.count();
    }

    //listar em ordem crescente
    @GetMapping("/persons/namesasc")
    public List<Person> orderNames() {
    return action.findByOrderByName();
}

    //listar em ordem decrescente
    @GetMapping("/persons/namesdesc")
    public List<Person> orderNamesDesc() {
        return action.findByOrderByNameDesc();
    }

    //listar pessoas que contenham "t" no nome
    @GetMapping("/persons/contain")
    public List<Person> nameContain(){
        return  action.findByNameContaining("t");
    }

    //somar idades
    @GetMapping("/persons/plusages")
    public Integer plusAges() {
        return action.plusAges();
    }

    //listar idades maiores ou igual a:
    @GetMapping("/persons/agebiggerequal")
    public List<Person> ageBiggerEqual(){
        return action.ageBiggerEqual(37);
    }

}
