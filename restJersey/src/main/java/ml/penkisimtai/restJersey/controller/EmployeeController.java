package ml.penkisimtai.restJersey.controller;

import ml.penkisimtai.restJersey.model.Employee;
import ml.penkisimtai.restJersey.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import java.net.MalformedURLException;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getAllCustomers() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/hello")
    public String helloForTesting() {
        return "Hello from Spring";
    }

    @GetMapping("/video")
        public ResponseEntity<UrlResource> getFullVideo() throws MalformedURLException {
//        Optional<Video> optionalVideo = videoRepository.findById(id);

//        if (optionalVideo.isPresent()) {
//        final String videoPath = optionalVideo.get().getAbsolutePath();
        final UrlResource video = new UrlResource(
                "http://distribution.bbb3d.renderfarming.net/video/mp4/bbb_sunflower_1080p_30fps_normal.mp4"
        );
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaTypeFactory.getMediaType(video)
                        .orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(video);
//        }

//        return ResponseEntity.noContent().build();
    }
}