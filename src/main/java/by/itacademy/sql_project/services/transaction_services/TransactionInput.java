package by.itacademy.sql_project.services.transaction_services;

public class TransactionInput {
    public static Transaction enterTransaction(int accountId, double amount) {
        Transaction transaction = new Transaction();
        boolean valid = true;
        do {
            try {
                transaction.setAccountId(accountId);
                transaction.setAmount(amount);
            } catch (Exception e) {
                System.out.println("Invalid data, Try again");
            }
        } while (!valid);
        return transaction;
    }
}