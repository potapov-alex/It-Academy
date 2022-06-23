package by.itacademy.sql_project.services.transaction_services;

import java.sql.*;

import static by.itacademy.sql_project.Application.connection;
import static by.itacademy.sql_project.services.account_services.AccountQuery.getBalance;
import static java.lang.String.format;

public class TransactionQuery {

    public static void addTransaction(Transaction transaction, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format("INSERT INTO Transactions (accountId, transactionAmount) VALUES('%d', '%f')",
                transaction.getAccountId(), transaction.getTransactionAmount()));
        statement.close();
    }

    public static void accountReplenishment(Transaction transaction, int accountId, double amount) throws SQLException {
        double userBalance = getBalance(accountId);
        double exchangedBalance = userBalance + amount;
        String SQL_ACC_REPL = "UPDATE Accounts SET accountBalance = " + exchangedBalance + "  WHERE accountId = " + accountId + ";";
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_ACC_REPL);
        addTransaction(transaction, connection);
    }

    public static void accountWithdrawal(Transaction transaction, int accountId, double amount) throws SQLException {
        double userBalance = getBalance(accountId);
        double exchangedBalance = userBalance - amount;
        String SQL_ACC_REPL = "UPDATE Accounts SET accountBalance = " + exchangedBalance + "  WHERE accountId = " + accountId + ";";
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_ACC_REPL);
        addTransaction(transaction, connection);
    }

    public static boolean checkTransaction(double volume) {
        boolean checkTransaction = false;
        if (volume >= 100_000_000) {
            System.out.println("the transaction volume exceeds the allowable");
        } else {
            checkTransaction = true;
        }
        return checkTransaction;
    }


}