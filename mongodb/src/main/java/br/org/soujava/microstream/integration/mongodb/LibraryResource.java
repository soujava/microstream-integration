package br.org.soujava.microstream.integration.mongodb;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Path("/library")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryResource {

    private final Library library;


    @Inject
    public LibraryResource(Library library) {
        this.library = library;
    }

    @GET
    public List<Book> allBooks() {
        return this.library.findAll().collect(Collectors.toUnmodifiableList());
    }

    @GET
    @Path("{id}")
    public Book findById(@PathParam("id") String id) {
        return this.library.findById(id)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @PUT
    public Book save(Book book) {
        return this.library.save(book);
    }

    @Path("{id}")
    public void deleteBy(@PathParam("id") String id) {
        this.library.deleteById(id);
    }
}