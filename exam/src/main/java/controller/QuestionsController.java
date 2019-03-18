package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Questions;
import model.Users;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class QuestionsController {
    @NonNull
    private List<Questions> questionsModel;
    private DatabaseService databaseService = new DatabaseService();

    public List<Questions> loadQuestions(){
        databaseService.beginSessionAndTransaction();
        questionsModel = databaseService.loadExamsQuestions();
        databaseService.closeConnection();
        return questionsModel;
    }

    public List<Questions> findQuestionsByExamId(int id) {
        loadQuestions();
        return questionsModel.stream()
                .filter(exams -> id == exams.getExam_id())
                .collect(Collectors.toList());
    }
}
