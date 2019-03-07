import controller.PersonController;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        PersonController personController = new PersonController(new ArrayList<>());
        personController.processPerson("users.csv", "phonenr.csv");
    }
}
