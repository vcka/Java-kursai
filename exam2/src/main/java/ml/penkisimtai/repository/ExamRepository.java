package ml.penkisimtai.repository;

import ml.penkisimtai.model.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam save(Exam Exam);

    Page<Exam> findAll(Pageable pageable);

//    @Modifying
//    @Transactional
    Page<Exam> findAllByIsPublishedTrue(Pageable pageable);

//    Page<Exam> findExamsByUser(User user, Pageable pageable);

//    Exam findById(Long id);// throws ResourceUnavailableException;

//    Exam update(Exam exam);// throws ResourceUnavailableException, UnauthorizedActionException;

    void delete(Exam exam);// throws ResourceUnavailableException, UnauthorizedActionException;

//    Page<Exam> search(String query, Pageable pageable);

//    Result checkAnswers(Quiz quiz, List<Response> answersBundle);

//    void publishExam(Exam exam);
}
