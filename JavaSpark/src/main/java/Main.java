import java.sql.SQLException;

import static spark.Spark.get;


public class Main {
    public static void main(String[] args) throws SQLException {
            DataBaseService dataBaseService = new DataBaseService();
            dataBaseService.dbConnection();

            get("/user/:id", (req, res) -> "Hello World");

    }
}
