package com.budgeteers.financetracker.services.entry.models;

public class ExpenseEntry extends Entry {

    public ExpenseEntry(int amount, ExpenseCategory expenseCategory, String notes) {
        super(amount, expenseCategory, notes);
    }

    public enum ExpenseCategory implements Category {
        RENT,
        UTILITIES,
        HEALTHCARE,
        MISCELLANEOUS,
        INSURANCE,
        TRANSPORTATION,
        FOOD,
        ENTERTAINMENT,
        CLOTHING,
        SUBSCRIPTION,
    }
}
