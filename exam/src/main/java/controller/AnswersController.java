package controller;


import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Answers;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AnswersController {
    @NonNull
    private List<Answers> answersModel;
    private DatabaseService databaseService = new DatabaseService();

    private List<Answers> loadAnswers() {
        databaseService.beginSessionAndTransaction();
        answersModel = databaseService.loadQuestionsAnswers();
        databaseService.closeConnection();
        return answersModel;
    }

    public List<Answers> findAnswersByExamId(int id) {
        loadAnswers();
        return answersModel.stream()
                .filter(exams -> id == exams.getExam_id().getId())
                .collect(Collectors.toList());
    }
}
