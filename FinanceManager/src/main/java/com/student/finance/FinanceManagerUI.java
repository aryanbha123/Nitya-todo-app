package com.student.finance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FinanceManagerUI extends JFrame {

    private JTextField descriptionField, amountField, dateField;
    private JComboBox<String> typeComboBox;
    private TransactionDAO dao;

    public FinanceManagerUI() {
        dao = new TransactionDAO();
        setTitle("Student Finance Manager");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Description:"));
        descriptionField = new JTextField();
        add(descriptionField);

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Type:"));
        typeComboBox = new JComboBox<>(new String[]{"income", "expense"});
        add(typeComboBox);

        add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        add(dateField);

        JButton saveButton = new JButton("Save Transaction");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTransaction();
            }
        });
        add(saveButton);

        // View Transactions button
        JButton viewButton = new JButton("View Transactions");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTransactionsTable();
            }
        });
        add(viewButton);

        setVisible(true);
    }

    private void saveTransaction() {
        try {
            String desc = descriptionField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String type = (String) typeComboBox.getSelectedItem();
            String date = dateField.getText();

            // Create a new Transaction and save it
            Transaction t = new Transaction(desc, amount, type, date);
            dao.saveTransaction(t);

            JOptionPane.showMessageDialog(this, "✅ Transaction Saved!");
            clearForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
        }
    }

    private void clearForm() {
        descriptionField.setText("");
        amountField.setText("");
        dateField.setText("");
        typeComboBox.setSelectedIndex(0);
    }

    // Method to show transactions in a JTable
    private void showTransactionsTable() {
        List<Transaction> transactions = dao.fetchAll();  // Fetch data from MongoDB
        TransactionTableModel model = new TransactionTableModel(transactions);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame tableFrame = new JFrame("All Transactions");
        tableFrame.setSize(500, 300);
        tableFrame.add(scrollPane);
        tableFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new FinanceManagerUI();
    }
}
