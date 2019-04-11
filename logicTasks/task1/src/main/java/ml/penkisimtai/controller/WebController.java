package ml.penkisimtai.controller;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/get")
public class WebController {

    @Autowired
    WebService webService;

    @PostMapping("/api/read/")
    Input newInput(@RequestBody String newInput) {
        return webService.save(newInput);
    }

    @RequestMapping
    String test() {
        return "Labas";
    }

}
