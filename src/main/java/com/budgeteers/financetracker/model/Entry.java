package com.budgeteers.financetracker.model;

import lombok.Getter;

@Getter
public abstract class Entry {
    private final String id;
    private final int amount;
    private final Category category;
    private final String notes;

    Entry(String id, int amount, Category category, String notes) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.notes = notes;
    }

    public interface Category {
    }
}
