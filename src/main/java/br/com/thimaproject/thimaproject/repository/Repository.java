package br.com.thimaproject.thimaproject.repository;

import br.com.thimaproject.thimaproject.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends CrudRepository<Person, Long> {

    List<Person> findAll();
    //Modo antigo
    //Person findById(Long id);

    Optional<Person> findById(Long id);

    //se for retornar muitos registros por por id por exemplo, usa o abaixo:
    //List<Pessoa> findById(Long id)

    List<Person> findByOrderByName();
}
