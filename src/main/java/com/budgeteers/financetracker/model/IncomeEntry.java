package com.budgeteers.financetracker.model;

public class IncomeEntry extends Entry {
    public IncomeEntry(String id, int amount, Category category, String notes) {
        super(id, amount, category, notes);
    }

    public enum IncomeCategory implements Category {
        FULL_TIME_EMPLOYMENT,
        PART_TIME_EMPLOYMENT,
        TAX_RETURN,
        BUSINESS,
        CAPITAL_GAINS,
        MISCELLANEOUS,
    }
}
