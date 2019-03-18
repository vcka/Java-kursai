package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Users;

import java.util.List;

@RequiredArgsConstructor
public class UserController {
    @NonNull
    private List<Users> usersModel;
    private DatabaseService databaseService = new DatabaseService();

    public List<Users> loadUsers(){
        databaseService.beginSessionAndTransaction();
        usersModel = databaseService.loadUsers();
        databaseService.closeConnection();
        return usersModel;
    }

    public void removeUser(String email){
        databaseService.beginSessionAndTransaction();
        databaseService.deleteUser(findUserByEmail(email));
        databaseService.commit();
        databaseService.closeConnection();
    }

    public void addUser(Users user){
        databaseService.beginSessionAndTransaction();
        databaseService.registerUser(user);
        databaseService.commit();
        databaseService.closeConnection();
    }

    public boolean authorizeUser(String email, String password){
        return usersModel.stream()
                .filter(e -> e.getEmail().equals(email))
                .anyMatch(p -> p.getPassword().equals(password));
    }

    public Users findUserByEmail(String email) {
        return usersModel.stream()
                .filter(user -> email.equals(user.getEmail()))
                .findAny()
                .orElse(null);
    }
}
