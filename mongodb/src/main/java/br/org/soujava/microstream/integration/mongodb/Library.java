package br.org.soujava.microstream.integration.mongodb;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface Library extends CrudRepository<Book, String> {
    List<Book> findByTitle(String title);
}