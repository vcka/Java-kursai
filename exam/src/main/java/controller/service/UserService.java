package controller.service;

import org.hibernate.Session;

public class UserService {
    DatabaseService databaseService;
    Session get(){
        return databaseService.getSession();
    }


}
