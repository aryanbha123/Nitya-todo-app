package com.student.finance;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TransactionTableModel extends AbstractTableModel {

    private final List<Transaction> transactions;
    private final String[] columnNames = {"Description", "Amount", "Type", "Date"};

    public TransactionTableModel(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public int getRowCount() {
        return transactions.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaction t = transactions.get(rowIndex);
        switch (columnIndex) {
            case 0: return t.getDescription();
            case 1: return t.getAmount();
            case 2: return t.getType();
            case 3: return t.getDate();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
