package ml.penkisimtai.service;

import ml.penkisimtai.module.Input;
import ml.penkisimtai.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Input> findById(Long id) {

        return webRepository.findById(id);
    }

    public void deleteById(Long id) {

        webRepository.deleteById(id);
    }

    public boolean existsByInput(String input) {

        return webRepository.existsByInput(input);
    }
}
