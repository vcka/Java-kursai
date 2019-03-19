package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.UserAnswers;

import java.util.List;

@RequiredArgsConstructor
public class UserAnswerController {
    @NonNull
    private List<UserAnswers> usersAnswersModel;
    private DatabaseService databaseService = new DatabaseService();

    private List<UserAnswers> loadUsersAnswers() {
        databaseService.beginSessionAndTransaction();
        usersAnswersModel = databaseService.loadUsersAnswers();
        databaseService.closeConnection();
        return usersAnswersModel;
    }

    public void addUserAnswer(UserAnswers usersAnswers){
        databaseService.beginSessionAndTransaction();
        databaseService.saveUsersAnswers(usersAnswers);
        databaseService.commit();
        databaseService.closeConnection();
    }
}
