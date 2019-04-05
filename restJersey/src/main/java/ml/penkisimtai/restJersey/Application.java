package ml.penkisimtai.restJersey;

import ml.penkisimtai.restJersey.controller.PersonController;
import ml.penkisimtai.restJersey.service.PersonService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

//	@Bean
//	ResourceConfig resourceConfig() {
//		return new ResourceConfig().register(PersonController.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
