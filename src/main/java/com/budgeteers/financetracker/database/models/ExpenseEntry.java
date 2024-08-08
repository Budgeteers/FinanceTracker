package com.budgeteers.financetracker.database.models;

import com.budgeteers.financetracker.services.entry.models.Entry;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExpenseEntry {
    public ExpenseEntry(int amount, @NotNull ExpenseCategory category, @NotNull String notes) {
        this.amount = amount;
        this.category = category;
        this.notes = notes;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private int amount;

    @Column
    @NotNull(message = "category is required")
    @Enumerated
    private ExpenseCategory category;

    @Column
    private String notes;

    public enum ExpenseCategory implements Entry.Category {
        RENT,
        UTILITIES,
        HEALTHCARE,
        MISCELLANEOUS,
        INSURANCE,
        TRANSPORTATION,
        FOOD,
        ENTERTAINMENT,
        CLOTHING,
        SUBSCRIPTION,
    }
}
