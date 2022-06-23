package by.itacademy.sql_project.services.account_services;

import java.sql.*;

import static by.itacademy.sql_project.Application.connection;
import static java.lang.String.format;

public class AccountQuery {

    public static void addAccount(Account account, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Accounts (userId, accountCurrency) VALUES('%d', '%s')",
                account.getUserId(), account.getCurrency()));
        statement.close();
    }

    public static ResultSet getAccount(int usersId) throws SQLException {
        String SQL_FIND_USER_ACCOUNT = "SELECT accountId, accountCurrency FROM Accounts WHERE userId = " + usersId + " ;";
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_USER_ACCOUNT, usersId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "accountId: " + resultSet.getInt("accountId"));
            System.out.println("currency: " + resultSet.getString("accountCurrency") + '\n');
        }
        resultSet.close();
        statement.close();
        return resultSet;
    }

    public static void currencyCheck(Account account, int usersId, String currency) throws SQLException {
        String SQL_GET_CURR = "SELECT accountId, accountCurrency FROM Accounts WHERE userId = " + usersId + ";";
        PreparedStatement statement =
                connection.prepareStatement(SQL_GET_CURR);
        ResultSet resultSet = statement.executeQuery();
        boolean isCurrencyExist = true;
        while (resultSet.next()) {
            if (resultSet.getString("accountCurrency").equals(currency)) {
                isCurrencyExist = false;
            }
        }
        if (isCurrencyExist == false) {
            System.out.println("users " + usersId + " already have an account at " + currency + " currency");
        } else {
            addAccount(account, connection);
            System.out.println("Account created");
        }
        resultSet.close();
        statement.close();
    }

    public static double getBalance(int accountId) throws SQLException {
        double balance = 0;
        String SQL_GET_CURR = "SELECT accountBalance FROM Accounts WHERE accountId = " + accountId + ";";
        PreparedStatement statement =
                connection.prepareStatement(SQL_GET_CURR);
        ResultSet resultSet = statement.executeQuery();
        balance = resultSet.getDouble("accountBalance");
        return balance;
    }

    public static boolean checkBalance(int userId, double volume) throws SQLException {
        boolean checkBalance = false;
        double userBalance = getBalance(userId);
        if ((userBalance - volume) < 0 || (userBalance + volume) > 2_000_000_000) {
            System.out.println("the account volume exceeds the allowable");
        } else {
            checkBalance = true;
        }
        return checkBalance;
    }
}