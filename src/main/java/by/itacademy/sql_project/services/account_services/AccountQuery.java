package by.itacademy.sql_project.services.account_services;

import java.sql.*;
import java.util.Objects;

import static by.itacademy.sql_project.Application.connection;
import static by.itacademy.sql_project.services.user_services.UserQuery.getUserName;
import static java.lang.String.format;

public class AccountQuery {
    private static final String SQL_FIND_ALL_ACCOUNTS = "SELECT * FROM Accounts;";

    public static void addAccount(Account account, Connection connection, int userId, String currency) throws SQLException {
        if (currencyCheck(), userId, currency) == true){
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Accounts (userId, accountCurrency) VALUES('%d', '%s')",
                account.getUserId(), account.getCurrency()));
        statement.close();}
    }

    public static ResultSet getAccount(int userId) throws SQLException {
        String SQL_FIND_USER_ACCOUNT = "SELECT * FROM Accounts WHERE userId = " + userId + " ;";
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_USER_ACCOUNT, userId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println('\n' + "accountId: " + resultSet.getInt("accountId"));
            System.out.println("userId: " + resultSet.getString("userId"));
            System.out.println("balance: " + resultSet.getString("accountBalance"));
            System.out.println("currency: " + resultSet.getString("accountCurrency") + '\n');
        }
        resultSet.close();
        statement.close();
        return resultSet;
    }

    public static boolean currencyCheck(ResultSet resultSet, int userId, String currency) throws SQLException {
        int rsId = resultSet.getInt("userId");
        String rsCurrency = resultSet.getString("accountCurrency");
        if (Objects.equals(rsId, userId) && Objects.equals(rsCurrency, currency)) {
            System.out.println("User " + getUserName(userId) + " already have account in "
                    + getAccountCurrency(userId) + " currency");
            return false;
        } else
            return true;
    }

    public static String getAccountCurrency(int userId) throws SQLException {
        String SQL_FIND_USER_NAME = "SELECT accountCurrency FROM Accounts WHERE userId = " + userId + ";";
        PreparedStatement statement =
                connection.prepareStatement(SQL_FIND_USER_NAME);
        ResultSet resultSet = statement.executeQuery();
        String accountCurrency = resultSet.getString("accountCurrency");
        System.out.println(accountCurrency);
        return accountCurrency;
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
