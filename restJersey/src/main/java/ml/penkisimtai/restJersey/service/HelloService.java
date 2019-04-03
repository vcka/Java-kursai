package ml.penkisimtai.restJersey.service;

import ml.penkisimtai.restJersey.model.Person;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Service
@Path("/hello")
public class HelloService {

    @GET
    @Produces("text/plain")
    public String hello(){
        return "Hello from Spring BOOT";
    }
}
