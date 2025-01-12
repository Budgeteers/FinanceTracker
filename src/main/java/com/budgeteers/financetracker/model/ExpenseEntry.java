package com.budgeteers.financetracker.model;

public class ExpenseEntry extends Entry {

    public ExpenseEntry(String id, int amount, Category category, String notes) {
        super(id, amount, category, notes);
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
