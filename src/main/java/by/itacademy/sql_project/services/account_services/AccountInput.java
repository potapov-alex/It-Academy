package by.itacademy.sql_project.services.account_services;

import java.util.Scanner;

public class AccountInput {

    public static Account enterAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do {
            try {
                System.out.println("Enter userId: ");
                account.setAccountId(scanner.nextInt());
                System.out.println("Enter currency: ");
                account.setCurrency(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
            }
        } while (!valid);
        return account;
    }
}