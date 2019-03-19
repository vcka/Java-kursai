package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.WrightAnswers;

import java.util.List;

@RequiredArgsConstructor
public class WrightAnswerController {
    @NonNull
    private List<WrightAnswers> wrightAnswersModel;
    private DatabaseService databaseService = new DatabaseService();

    private List<WrightAnswers> loadWrightAnswers() {
        databaseService.beginSessionAndTransaction();
        wrightAnswersModel = databaseService.loadWrightAnswers();
        databaseService.closeConnection();
        return wrightAnswersModel;
    }

    public void addWrightAnswer(WrightAnswers wrightAnswers){
        databaseService.beginSessionAndTransaction();
        databaseService.saveWrightAnswers(wrightAnswers);
        databaseService.commit();
        databaseService.closeConnection();
    }
}
