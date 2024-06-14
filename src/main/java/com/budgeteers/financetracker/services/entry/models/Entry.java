package com.budgeteers.financetracker.services.entry.models;

import lombok.Getter;

@Getter
public abstract class Entry {
    private final int amount;
    private final Category category;
<<<<<<< 6-creating-notes
    private final String categoryNote;

    Entry(int amount, Category category, String categoryNote) {
        this.amount = amount;
        this.category = category;
        this.categoryNote = categoryNote;
=======

    Entry(int amount, Category category) {
        this.amount = amount;
        this.category = category;
>>>>>>> main
    }

    public interface Category {
    }
}
