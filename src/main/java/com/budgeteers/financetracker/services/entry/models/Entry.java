package com.budgeteers.financetracker.services.entry.models;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

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
