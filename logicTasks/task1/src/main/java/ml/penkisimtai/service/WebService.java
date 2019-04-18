package ml.penkisimtai.service;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class WebService {

    @Autowired
    WebRepository webRepository;

    public Input save(Input inputFromPost) {
        return webRepository.save(inputFromPost);
    }

    public List<Input> findAllRecords() {
        return webRepository.findAll();
    }

    public boolean existsByID(Long id) {
        return webRepository.existsById(id);
    }

    public List findAllById(Iterable id) {
        return webRepository.findAllById(id);
    }

    public Optional<Input> findById(Long id){
        return webRepository.findById(id);
    }

    public String deleteById(Long id){
        if (existsByID(id)){
            webRepository.deleteById(id);
            return String.format("Input deleted by id %d",id);
        }else{
            return String.format("%d id does not exists",id);
        }
    }
}
