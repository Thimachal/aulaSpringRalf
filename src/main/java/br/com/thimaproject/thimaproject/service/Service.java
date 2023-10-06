package br.com.thimaproject.thimaproject.service;

import br.com.thimaproject.thimaproject.model.Client;
import br.com.thimaproject.thimaproject.model.Messenger;
import br.com.thimaproject.thimaproject.model.Person;
import br.com.thimaproject.thimaproject.repository.Repository;
import br.com.thimaproject.thimaproject.repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Messenger messenger;
    @Autowired
    private Repository action;

    @Autowired
    RepositoryClient actionClient;

    //metodo para cadastrar pessoas
    public ResponseEntity<?> register(Person obj) {
        if (obj.getName().equals("")) {
            messenger.setMessenger("Sorry, mas obrigatório preencher nome");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);

        } else if (obj.getAge() < 0 ) {
            messenger.setMessenger("Sorry, informe a idade válida");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }

    }

    //metodo para selecionar todas as pessoas
    public ResponseEntity<?> selectPersons(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    //metodo para selecionar pessoas por id
    public ResponseEntity<?> selectionById(Long id){
        if(action.countById(id) == 0l){
            messenger.setMessenger("Não foi encontrada a pessoa");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
        }
    }

    //metodo para editar pessoas
    public ResponseEntity<?> editPerson(Person obj){
        if(action.countById(obj.getId()) == 0){
            messenger.setMessenger("Sorry mas código informado não existe");
            return new ResponseEntity<>(messenger, HttpStatus.NOT_FOUND);
        }else if (obj.getName().equals("")){
            messenger.setMessenger("Necessário informar o nome");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
        } else if (obj.getAge() < 0 ) {
            messenger.setMessenger("informe a idade válida");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
        }
    }

    //metodo para remover pessoas
    public ResponseEntity<?> deletePerson(Long id) {

        if (action.countById(id) == 0l) {
            messenger.setMessenger("Codigo informado não existe");
            return new ResponseEntity<>(messenger, HttpStatus.NOT_FOUND);
        } else {
            action.deleteById(id);
            messenger.setMessenger("Removido com sucesso");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //cadastrar clientes

    public ResponseEntity<?> registerClients(Client obj) {
            return new ResponseEntity<>(actionClient.save(obj), HttpStatus.CREATED);
    }

    //listar todos os clientes
    public ResponseEntity<?> listClients(){
        return new ResponseEntity<>(actionClient.findAll(), HttpStatus.OK);
    }


}
