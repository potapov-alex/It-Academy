package by.itacademy.sql_project;

import by.itacademy.sql_project.services.account_services.Account;
import by.itacademy.sql_project.services.user_services.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static by.itacademy.sql_project.services.account_services.AccountInput.enterAccount;
import static by.itacademy.sql_project.services.account_services.AccountQuery.addAccount;
import static by.itacademy.sql_project.services.account_services.AccountQuery.getAccount;
import static by.itacademy.sql_project.services.user_services.UserInput.enterUser;
import static by.itacademy.sql_project.services.user_services.UserQuery.*;

public class Application {

    public static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL =
            "jdbc:sqlite:F:/javaCoding/itacademy/src/main/java/by/itacademy/sql_project/database/UserDB.db";
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        if (isDriverExists()) {
            connection = DriverManager.getConnection(DATABASE_URL);
            int actionCode;
            do {
                printMenu();
                actionCode = new Scanner(System.in).nextInt();
                switch (actionCode) {
                    case 1:
                        User user = enterUser();
                        addUser(user, connection);
                        break;
                    case 2:
                        System.out.println("Users list is: ");
                        getUser();
                        System.out.println("Select an user ID to create account");
                        int userId = new Scanner(System.in).nextInt();
                        System.out.println("Enter accounts currency");
                        String currency = new Scanner(System.in).nextLine();
                        getAccount(userId);
                        Account account = enterAccount(userId, currency);
                        addAccount(account, connection, userId, currency);
                        break;
                   /* case 3:
                        System.out.println("Enter the Developer's ID: ");
                        int idForDelete = new Scanner(System.in).nextInt();
                        deleteDeveloper(idForDelete, connection);
                        break;
                    case 4:
                        System.out.println("Enter the Developer's ID: ");
                        int idForUpdate = new Scanner(System.in).nextInt();
                        updateDeveloper(idForUpdate, enterDeveloper(), connection);
                        break;*/
                    case 5:
                        System.out.println("Thanks for using the program!");
                        break;
                    default:
                        System.out.println("Unknown option. Please enter again");
                }
            } while (actionCode == 5);
            connection.close();
        }
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
        System.out.println("1 - Register new user");
        System.out.println("2 - Add user account");
        System.out.println("3 - Account replenishment");
        System.out.println("4 - Account withdrawal");
        System.out.println("5 - quit\n");
    }
}