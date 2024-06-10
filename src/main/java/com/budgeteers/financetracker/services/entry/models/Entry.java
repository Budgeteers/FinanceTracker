package com.budgeteers.financetracker.services.entry.models;

import lombok.Getter;

@Getter
public abstract class Entry {
    private final int amount;
    private final Category category;

    Entry(int amount, Category category) {
        this.amount = amount;
        this.category = category;
    }

    public interface Category {
    }
}
