package ml.penkisimtai.controller;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.repository.WebRepository;
import ml.penkisimtai.exceptions.InputNotFoundException;
import ml.penkisimtai.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/")
public class WebController {

    private final WebRepository repository;

    WebController(WebRepository repository) {
        this.repository = repository;
    }

    @Autowired
    WebService webService;

    @RequestMapping("input/add")
    public Input addInput(@RequestBody Input input){
        return repository.save(input);
//        webService.save(input);
    }

    @RequestMapping("inputs")
    Collection<Input> getAllInputs(){
        return webService.findAllRecords();
    }

    @RequestMapping("input/{id}")
    Input getInputById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new InputNotFoundException(id));
    }

}
