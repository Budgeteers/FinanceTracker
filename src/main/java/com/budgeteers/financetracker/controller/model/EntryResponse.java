package com.budgeteers.financetracker.controller.model;

import lombok.Getter;

@Getter
public class EntryResponse {
    private final int amount;
    private final String category;
    private final String notes;

    public EntryResponse(int amount, String category, String notes) {
        this.amount = amount;
        this.category = category;
        this.notes = notes;
    }
}
