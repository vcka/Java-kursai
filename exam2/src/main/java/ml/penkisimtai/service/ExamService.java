package ml.penkisimtai.service;

import ml.penkisimtai.repository.ExamRepository;
import ml.penkisimtai.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public Page<Exam> findAllPublished(Pageable pageable) {
        return examRepository.findAllByIsPublishedTrue(pageable);
    }

    public Page<Exam> findAll(Pageable pageable) {
        return examRepository.findAll(pageable);
    }

    public Exam save(Exam exam) {

        return (Exam) examRepository.save(exam);
    }
}
