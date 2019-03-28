package util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoDBUtil {
    private static final String user = "vcka";
    private static final String database = "admin"; // duombazės vardas kur naudotojas sukurtas
    private static final char[] password = "l0bzikas".toCharArray();
    // ...

    public static MongoClient createMongoClient() {
        MongoCredential credential = MongoCredential.createCredential(user, database, password);
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
        ServerAddress serverAddress = new ServerAddress("localhost", 27017);

        return new MongoClient(serverAddress, credential, options);
    }
}
