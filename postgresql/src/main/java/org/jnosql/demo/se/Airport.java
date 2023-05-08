package org.jnosql.demo.se;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface Airport extends CrudRepository<Airplane, String> {
    List<Airplane> findByModel(String model);
}