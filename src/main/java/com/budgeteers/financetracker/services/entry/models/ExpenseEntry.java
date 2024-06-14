package com.budgeteers.financetracker.services.entry.models;

public class ExpenseEntry extends Entry {
<<<<<<< 6-creating-notes
    public ExpenseEntry(int amount, ExpenseCategory expenseCategory, String categoryNote) {
        super(amount, expenseCategory, categoryNote);
=======
    public ExpenseEntry(int amount, ExpenseCategory expenseCategory) {
        super(amount, expenseCategory);
>>>>>>> main
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
