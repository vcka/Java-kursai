package ml.penkisimtai.service;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WebService {

    @Autowired
    WebRepository webRepository;

    public Input save(String inputFromPost){
        Input input = new Input(inputFromPost);
        return webRepository.save(input);
    }
}
