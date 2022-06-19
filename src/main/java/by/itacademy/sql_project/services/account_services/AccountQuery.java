package by.itacademy.sql_project.services.account_services;

import by.itacademy.sql_project.services.user_services.User;

import java.sql.*;

import static by.itacademy.sql_project.Application.connection;
import static java.lang.String.format;

public class AccountQuery {
    private static final String SQL_FIND_ALL_ACCOUNTS = "SELECT * FROM Accounts;";

    public static void addAccount(Account account, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Accounts (userId, accountCurrency) VALUES('%i', '%s')",
                account.getUserId(), account.getCurrency()));
        statement.close();
    }

    public static void getAccount() throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_ALL_ACCOUNTS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "accountId: " + resultSet.getInt("accountId"));
            System.out.println("userId: " + resultSet.getString("userId"));
            System.out.println("balance: " + resultSet.getString("accountBalance"));
            System.out.println("currensy: " + resultSet.getString("accountCurrency") + '\n');
        }
        resultSet.close();
        statement.close();
    }

}
