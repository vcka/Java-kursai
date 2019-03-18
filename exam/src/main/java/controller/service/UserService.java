package controller.service;

public class UserService {
    DatabaseService databaseService = new DatabaseService();

    public void re(){
        databaseService.beginSessionAndTransaction();
    }
}
