package by.itacademy.sql_project.database.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBStructure {

    public static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL =
            "jdbc:sqlite:F:/javaCoding/itacademy/src/main/java/by/itacademy/sql_project/database/UserDB.db";
    public static Connection connection;
    public static Statement statement;

    public static void main(String[] args) throws SQLException {
        if (isDriverExists()) {
            connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();
        }

        int actionCode;
        do {
            printMenu();
            actionCode = new Scanner(System.in).nextInt();
            switch (actionCode) {
                case 1:
                    try {
                        String sql = "CREATE TABLE Users" +
                                "(userId INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "userName VARCHAR(50)," +
                                "userAddress VARCHAR(255))";
                        statement.executeUpdate(sql);
                        System.out.println("Created table Users in database UserDB.db");
                        sql = "CREATE TABLE Accounts" +
                                "(accountId INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "userId INTEGER (10) REFERENCES Users (userId)," +
                                "accountBalance  DOUBLE (15)," +
                                "accountCurrency VARCHAR (3) UNIQUE)";
                        statement.executeUpdate(sql);
                        System.out.println("Created table Accounts in database UserDB.db");
                        sql = "CREATE TABLE Transactions" +
                                "(transactionId INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "accountId INTEGER (10) REFERENCES Accounts (accountId)," +
                                "transactionAmount DOUBLE (15))";
                        statement.executeUpdate(sql);
                        System.out.println("Created table Transactions in database UserDB.db");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        statement.close();
                        connection.close();
                    }
                    break;
                case 2:
                    try {
                        String sql = "DROP TABLE Users";
                        statement.executeUpdate(sql);
                        System.out.println("Drop table Users in database UserDB.db");
                        sql = "DROP TABLE Accounts";
                        statement.executeUpdate(sql);
                        System.out.println("Drop table Accounts in database UserDB.db");
                        sql = "DROP TABLE Transactions";
                        statement.executeUpdate(sql);
                        System.out.println("Drop table Transactions in database UserDB.db");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        statement.close();
                        connection.close();
                    }
                    break;
                default:
                    System.out.println("Unknown option. Please enter again");
            }
        } while (!"5".equals(actionCode));
        connection.close();
    }

    private static boolean isDriverExists() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC Driver not found");
            return false;
        }
    }

    public static void printMenu() {
        System.out.println("\nPlease select an action");
        System.out.println("1 - DataBase tables create");
        System.out.println("2 - DataBase tables drop");
        System.out.println("5 - quit\n");
    }
}