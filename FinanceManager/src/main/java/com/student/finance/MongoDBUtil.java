package com.student.finance;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";  // Local MongoDB instance
    private static final String DATABASE_NAME = "FinanceDB";  // Your database name

    // Method to connect to the database
    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
