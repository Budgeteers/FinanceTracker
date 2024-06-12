package com.budgeteers.financetracker.services.entry.models;

public class IncomeEntry extends Entry {

    public IncomeEntry(int amount, IncomeCategory incomeCategory, String categoryNote) {
        super(amount, incomeCategory, categoryNote);
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
