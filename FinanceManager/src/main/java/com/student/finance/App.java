package com.student.finance;

public class App {

    public static void main(String[] args) {

        System.out.println("💸 Welcome to Student Finance Manager 💸");

        // Create a sample transaction
        Transaction transaction = new Transaction(
                "Paid for lunch", 
                120.50, 
                "expense", 
                "2025-04-13"
        );

        // Initialize DAO and save transaction
        TransactionDAO dao = new TransactionDAO();
        dao.saveTransaction(transaction);

        // Display all transactions from DB
        dao.fetchAll();
    }
}
