package ml.penkisimtai.controller;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.exceptions.InputNotFoundException;
import ml.penkisimtai.service.WebService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/")
public class WebController {


    private final WebService webService;

    WebController(WebService webService) {
        this.webService = webService;
    }

    @RequestMapping("input/add")
    public Input addInput(@RequestBody Input input) {
        return webService.save(input);
    }

    @RequestMapping("inputs")
    Collection<Input> getAllInputs() {
        return webService.findAllRecords();
    }

    @RequestMapping("input/{id}")
    Input getInputById(@PathVariable Long id) {
        return webService.findById(id)
                .orElseThrow(() -> new InputNotFoundException(id));
    }

    @RequestMapping("input/remove/{id}")
    public String deleteInput(@PathVariable Long id) {
        return webService.deleteById(id);
    }
}
