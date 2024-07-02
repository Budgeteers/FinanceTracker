package com.budgeteers.financetracker.services.entry.models;

import org.springframework.validation.annotation.Validated;

public class IncomeEntry extends Entry {

    public IncomeEntry(int amount, IncomeCategory incomeCategory, String notes) {
        super(amount, incomeCategory, notes);
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
