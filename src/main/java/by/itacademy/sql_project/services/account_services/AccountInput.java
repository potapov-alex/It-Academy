package by.itacademy.sql_project.services.account_services;

import java.util.Scanner;

public class AccountInput {

    public static Account enterAccount(int userId, String currency) {
        Account account = new Account();
        boolean valid = true;
        do {
            try {
                account.setUserId(userId);
                account.setCurrency(currency);
            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
            }
        } while (!valid);
        return account;
    }
}