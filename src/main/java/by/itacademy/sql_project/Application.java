package by.itacademy.sql_project;

import by.itacademy.sql_project.services.account_services.Account;
import by.itacademy.sql_project.services.transaction_services.Transaction;
import by.itacademy.sql_project.services.user_services.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static by.itacademy.sql_project.services.account_services.AccountInput.enterAccount;
import static by.itacademy.sql_project.services.account_services.AccountQuery.*;
import static by.itacademy.sql_project.services.transaction_services.TransactionInput.enterTransaction;
import static by.itacademy.sql_project.services.transaction_services.TransactionQuery.*;
import static by.itacademy.sql_project.services.user_services.UserInput.enterUser;
import static by.itacademy.sql_project.services.user_services.UserQuery.addUser;
import static by.itacademy.sql_project.services.user_services.UserQuery.getUser;

public class Application {

    public static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL =
            "jdbc:sqlite:/home/alexey/coding/It-Academy/src/main/java/by/itacademy/sql_project/database/UserDB.db";
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        boolean checkTransaction = false;
        boolean checkBalance = false;
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
                        int accountUsersId = new Scanner(System.in).nextInt();
                        System.out.println("Enter accounts currency");
                        String currency = new Scanner(System.in).nextLine();
                        Account account = enterAccount(accountUsersId, currency);
                        currencyCheck(account, accountUsersId, currency);
                        break;
                    case 3:
                        System.out.println("Users list is: ");
                        getUser();
                        System.out.println("Select an user ID to account replenishment");
                        int replUsersId = new Scanner(System.in).nextInt();
                        getAccount(replUsersId);
                        System.out.println("Select an account ID to account replenishment");
                        int replAcc = new Scanner(System.in).nextInt();
                        double replBalance = getBalance(replAcc);
                        System.out.println("account balance = " + replBalance);
                        System.out.println("enter replenishment volume");
                        double replenishmentVolume = new Scanner(System.in).nextInt();
                        checkTransaction = checkTransaction(replenishmentVolume);
                        checkBalance = checkReplenishmentBalance(replUsersId, replenishmentVolume);
                        if (checkTransaction == true && checkBalance == true) {
                            Transaction transaction = enterTransaction(replAcc, replenishmentVolume);
                            accountReplenishment(transaction, replAcc, replenishmentVolume);
                        }
                        break;
                    case 4:
                        System.out.println("Users list is: ");
                        getUser();
                        System.out.println("Select an user ID to account withdrawal");
                        int withdrUsersId = new Scanner(System.in).nextInt();
                        getAccount(withdrUsersId);
                        System.out.println("Select an account ID to account replenishment");
                        int withdrAcc = new Scanner(System.in).nextInt();
                        double balance = getBalance(withdrAcc);
                        System.out.println("account balance = " + balance);
                        System.out.println("enter replenishment volume");
                        double withdrawalVolume = new Scanner(System.in).nextInt();
                        checkTransaction = checkTransaction(withdrawalVolume);
                        checkBalance = checkWithdrawalBalance(withdrUsersId, withdrawalVolume);
                        if (checkTransaction == true && checkBalance == true) {
                            Transaction transaction = enterTransaction(withdrAcc, -withdrawalVolume);
                            accountWithdrawal(transaction, withdrAcc, withdrawalVolume);
                        }
                        break;
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