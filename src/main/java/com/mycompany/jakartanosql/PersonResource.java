package com.mycompany.jakartanosql;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
@Path("person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);

    @Inject
    private PersonRepository repository;

    @GET
    public List<Person> findAll() {
        return repository.findAll()
                .collect(toList());
    }

    @GET
    @Path("/{id}")
    public Person findById(@PathParam("id") String id) {
        return repository.findById(id).orElseThrow(NOT_FOUND);
    }

    @GET
    @Path("seniors/{age}")
    public List<Person> findByOlder(@PathParam("age") Integer age) {
        return repository.findByAgeGreaterThan(age)
                .collect(toList());
    }

    @GET
    @Path("youngs/{age}")
    public List<Person> findByYounger(@PathParam("age") Integer age) {
        return repository.findByAgeLessThan(age)
                .collect(toList());
    }

    @POST
    public void save(Person hero) {
        repository.save(hero);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Person hero) {
        repository.save(hero);
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") String name) {
        repository.deleteById(name);
    }
}
