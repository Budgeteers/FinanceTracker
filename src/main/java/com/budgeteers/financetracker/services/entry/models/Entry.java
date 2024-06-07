package com.budgeteers.financetracker.services.entry.models;

public abstract class Entry {
    private final int amount;

    Entry(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
