package ml.penkisimtai.restJersey.controller;

import ml.penkisimtai.restJersey.model.Person;
import ml.penkisimtai.restJersey.repository.PersonsRepository;
import ml.penkisimtai.restJersey.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonsRepository personsRepository;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response hello() {
        return Response.ok(personService.sayHello()).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPersons() {
        return Response.ok().entity(personService.getAllPersons()).build();
    }

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response userById(@PathParam("id") final long id) {
        return Response.ok().entity(personService.getPersonById(id)).build();
    }

    @Path("/name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response userByName(@PathParam("name") final String firstName) {
        return Response.ok().entity(personService.getPersonByFistName(firstName)).build();
    }

    @Path("/delete/id/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserById(@PathParam("id") final long id) {
        return Response.ok().entity(personService.removePerson(id)).build();
    }

    @Path("/delete/name/{name}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserByName(@PathParam("name") final String name) {
        return Response.ok().entity(personsRepository.deleteByFirstName(name)).build();
    }
}
