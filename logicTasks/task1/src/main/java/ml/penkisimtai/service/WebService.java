package ml.penkisimtai.service;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class WebService {

    @Autowired
    WebRepository webRepository;

    public Input save(Input inputFromPost){
        return webRepository.save(inputFromPost);
    }

    public Collection<Input> findAllRecords(){
        return webRepository.findAll();
    }
}
