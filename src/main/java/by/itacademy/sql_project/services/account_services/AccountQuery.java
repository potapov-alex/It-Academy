package by.itacademy.sql_project.services.account_services;

import java.sql.*;

import static by.itacademy.sql_project.Application.connection;
import static java.lang.String.format;

public class AccountQuery {
    private static final String SQL_FIND_ALL_ACCOUNTS = "SELECT * FROM Accounts;";
    private static final String SQL_FIND_USER_ACCOUNT = "SELECT * FROM Accounts WHERE userId = 2 ;";

    public static void addAccount(Account account, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Accounts (userId, accountCurrency) VALUES('%d', '%s')",
                account.getUserId(), account.getCurrency()));
        statement.close();
    }

    public static void getAccount() throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_USER_ACCOUNT);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "accountId: " + resultSet.getInt("accountId"));
            System.out.println("userId: " + resultSet.getString("userId"));
            System.out.println("balance: " + resultSet.getString("accountBalance"));
            System.out.println("currency: " + resultSet.getString("accountCurrency") + '\n');
        }
        resultSet.close();
        statement.close();
    }

    public static void getAccounts() throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_ALL_ACCOUNTS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "accountId: " + resultSet.getInt("accountId"));
            System.out.println("userId: " + resultSet.getString("userId"));
            System.out.println("balance: " + resultSet.getString("accountBalance"));
            System.out.println("currency: " + resultSet.getString("accountCurrency") + '\n');
        }
        resultSet.close();
        statement.close();
    }

}
