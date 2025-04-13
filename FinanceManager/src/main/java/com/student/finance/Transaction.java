package com.student.finance;

import org.bson.types.ObjectId;

public class Transaction {

    private ObjectId id;  // MongoDB's default ID
    private String description;
    private double amount;
    private String type;  // income or expense
    private String date;  // You can use "yyyy-MM-dd" format

    // Constructor
    public Transaction(String description, double amount, String type, String date) {
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    // Getters & Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
