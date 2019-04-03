package ml.penkisimtai.restJersey.config;

import ml.penkisimtai.restJersey.controller.PersonController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(PersonController.class);
    }
}
