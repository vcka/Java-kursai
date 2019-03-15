import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DataBaseService {
    public static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/vcka_java1?useSSL=false";
    public static final String DATABASE_USER = "vcka_java1";
    public static final String DATABASE_PASS = "l0bzikas";

    ConnectionSource connectionSource;
    Dao<User,String> userDao;

    public DataBaseService() throws SQLException {

    }

    public void dbConnection() {
        {
            try {
                connectionSource = new JdbcConnectionSource(DATABASE_URL);
                ((JdbcConnectionSource) connectionSource).setUsername(DATABASE_USER);
                ((JdbcConnectionSource) connectionSource).setPassword(DATABASE_PASS);
                userDao = DaoManager.createDao(connectionSource, User.class);
                TableUtils.createTableIfNotExists(connectionSource, User.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
