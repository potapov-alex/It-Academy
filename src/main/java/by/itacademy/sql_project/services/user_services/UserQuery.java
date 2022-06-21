package by.itacademy.sql_project.services.user_services;

import java.sql.*;

import static by.itacademy.sql_project.Application.connection;
import static java.lang.String.format;

public class UserQuery {

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM Users;";

    public static void addUser(User user, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Users (userName, userAddress) VALUES('%s', '%s')",
                user.getName(), user.getAddress()));
        statement.close();
    }

    public static void getUser() throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "id: " + resultSet.getInt("userId"));
            System.out.println("name: " + resultSet.getString("userName"));
            System.out.println("address: " + resultSet.getString("userAddress") + '\n');
        }
        resultSet.close();
        statement.close();
    }

    public static String getUserName(int userId) throws SQLException {
        String SQL_FIND_USER_NAME = "SELECT userName FROM Users WHERE userId = " + userId + ";";
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_USER_NAME);
        ResultSet resultSet = statement.executeQuery();
        String name = resultSet.getString("userName");
        System.out.println(name);
        return name;
    }
}
