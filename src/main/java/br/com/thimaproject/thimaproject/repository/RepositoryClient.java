package br.com.thimaproject.thimaproject.repository;

import br.com.thimaproject.thimaproject.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryClient extends CrudRepository<Client, Long> {
    List<Client> findAll();
}
