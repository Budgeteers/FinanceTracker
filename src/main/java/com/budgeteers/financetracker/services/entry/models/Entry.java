package com.budgeteers.financetracker.services.entry.models;

import lombok.Getter;

@Getter
public abstract class Entry {
    private final int amount;
    private final Category category;
    private final String notes;

    Entry(int amount, Category category, String notes) {
        this.amount = amount;
        this.category = category;
        this.notes = notes;
    }

    public interface Category {
    }
}
