package br.com.thimaproject.thimaproject.repository;

import br.com.thimaproject.thimaproject.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Person, Long> {
}
