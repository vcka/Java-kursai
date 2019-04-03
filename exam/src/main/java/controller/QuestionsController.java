package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Exams;
import model.Questions;
import model.Users;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class QuestionsController {
    @NonNull
    private List<Questions> questionsModel;
    private DatabaseService databaseService = new DatabaseService();

    private List<Questions> loadQuestions() {
        databaseService.beginSessionAndTransaction();
        questionsModel = databaseService.loadExamsQuestions();
        databaseService.closeConnection();
        return questionsModel;
    }

    public List<Questions> findQuestionsByExamId(int id) {
        loadQuestions();
        Collections.shuffle(questionsModel);
        return questionsModel.stream()
                .filter(exams -> id == exams.getExam_id())
                .collect(Collectors.toList());
    }

    public void saveQuestion(Questions questions){
        databaseService.beginSessionAndTransaction();
        databaseService.saveQuestion(questions);
        databaseService.commit();
        databaseService.closeConnection();
    }
}
