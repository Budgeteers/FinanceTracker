package com.budgeteers.financetracker.services.entry.models;

public class IncomeEntry extends Entry {

<<<<<<< 6-creating-notes
    public IncomeEntry(int amount, IncomeCategory incomeCategory, String categoryNote) {
        super(amount, incomeCategory, categoryNote);
=======
    public IncomeEntry(int amount, IncomeCategory incomeCategory) {
        super(amount, incomeCategory);
>>>>>>> main
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
