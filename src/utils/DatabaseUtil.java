package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("db.url");
                connection = DriverManager.getConnection(url, props);
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
        return connection;
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
