package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Exams;
import model.Questions;
import model.Users;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class QuestionsController {
    @NonNull
    private List<Questions> questionsModel;
    private DatabaseService databaseService = new DatabaseService();
    EntityManager em;

    private List<Questions> loadQuestions() {
        databaseService.beginSessionAndTransaction();
        questionsModel = databaseService.loadExamsQuestions();
        databaseService.closeConnection();
        return questionsModel;
    }

    public List<Questions> findQuestionsByExamId(int id) {
        loadQuestions();
        return questionsModel.stream()
                .filter(exams -> id == exams.getExam_id().getId())
                .collect(Collectors.toList());
    }
}
