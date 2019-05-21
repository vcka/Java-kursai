package ml.penkisimtai.controller;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.exceptions.InputNotFoundException;
import ml.penkisimtai.service.WebService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class WebController {


    private final WebService webService;

    WebController(WebService webService) {
        this.webService = webService;
    }

    @PostMapping("input/add")
    public ResponseEntity<String> addInput(@RequestBody Input input) {

        if (webService.existsByInput(input.getInput())) {
            return ResponseEntity.status(409).body("Already exists");
        } else {
            webService.save(input);
            return ResponseEntity.ok("Saved");
        }
    }

    @GetMapping("inputs")
    ResponseEntity<List<Input>> getAllInputs() {

        return ResponseEntity.ok(webService.findAllRecords());
    }

    @GetMapping("input/{id}")
    ResponseEntity<Input> getInputById(@PathVariable Long id) {

        return ResponseEntity.ok(webService.findById(id)
                .orElseThrow(() -> new InputNotFoundException(id)));
    }

    @DeleteMapping("input/remove/{id}")
    public ResponseEntity<String> deleteInput(@PathVariable Long id) {
        if (webService.existsByID(id)) {
            webService.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.badRequest().body("Does not exists");
        }
    }
}
