package br.com.thimaproject.thimaproject.service;

import br.com.thimaproject.thimaproject.model.Messenger;
import br.com.thimaproject.thimaproject.model.Person;
import br.com.thimaproject.thimaproject.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Messenger messenger;
    @Autowired
    private Repository action;

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

    //metodo para selecionar pessoas
    public ResponseEntity<?> selectPersons(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> selectionById(Long id){
        if(action.countById(id) == 0l){
            messenger.setMessenger("Não foi encontrada a pessoa");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
        }
    }

}
