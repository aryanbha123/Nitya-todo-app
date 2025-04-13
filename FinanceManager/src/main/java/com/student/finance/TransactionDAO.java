package com.student.finance;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class TransactionDAO {

    private MongoDatabase database;

    public TransactionDAO() {
        this.database = MongoDBUtil.getDatabase();  // connect to MongoDB using your helper class
    }

    // Method to save a transaction
    public void saveTransaction(Transaction transaction) {
        MongoCollection<Document> collection = database.getCollection("transactions");

        Document doc = new Document("description", transaction.getDescription())
                .append("amount", transaction.getAmount())
                .append("type", transaction.getType())
                .append("date", transaction.getDate());

        collection.insertOne(doc);
        System.out.println("✅ Transaction saved successfully!");
    }

    // Method to fetch all transactions
    public List<Transaction> fetchAll() {
    MongoCollection<Document> collection = database.getCollection("transactions");
    List<Transaction> transactions = new ArrayList<>();

    for (Document doc : collection.find()) {
        transactions.add(new Transaction(
            doc.getString("description"),
            doc.getDouble("amount"),
            doc.getString("type"),
            doc.getString("date")
        ));
    }
    return transactions;
}

}
