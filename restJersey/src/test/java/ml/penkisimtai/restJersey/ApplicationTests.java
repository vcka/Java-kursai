package ml.penkisimtai.restJersey;

import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void hello(){
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity("/hello", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).isEqualTo("Hello from Spring");
	}

}
