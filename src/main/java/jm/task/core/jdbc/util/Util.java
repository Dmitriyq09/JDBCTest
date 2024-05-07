package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String URL =  "jdbc:mysql://localhost:3306/test_baza";
    private static final String NAME =  "Takumi";
    private static final String PASSWORD =  "Dimakovalevq09";
    private static Connection connection = null;
    private static Util instance = null;

    private Util() {
        try {
            if (null == connection || connection.isClosed()) {
                connection = DriverManager
                        .getConnection(URL,NAME,PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
