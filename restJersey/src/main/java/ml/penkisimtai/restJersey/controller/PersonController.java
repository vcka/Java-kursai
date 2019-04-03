package ml.penkisimtai.restJersey.controller;

import ml.penkisimtai.restJersey.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response hello(){
        return Response.ok(personService.sayHello()).build();
    }

    @Path("/users")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPersons(){
        return Response.ok(personService.getAllPersons()).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response userById(@PathParam("id") final long id){
        return Response.ok(personService.getPersonById(id)).build();
    }
}
