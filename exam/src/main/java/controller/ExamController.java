package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Exams;

import java.util.List;

@RequiredArgsConstructor
public class ExamController {
    @NonNull
    private List<Exams> examsModel;
    private DatabaseService databaseService = new DatabaseService();

    public List<Exams> loadExams(){
        databaseService.beginSessionAndTransaction();
        examsModel = databaseService.loadExams();
        databaseService.closeConnection();
        return examsModel;
    }

    public void addExam(Exams exam){
        databaseService.beginSessionAndTransaction();
        databaseService.saveExam(exam);
        databaseService.commit();
        databaseService.closeConnection();
    }
}
