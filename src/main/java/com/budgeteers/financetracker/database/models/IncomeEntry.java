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
public class IncomeEntry {
    public IncomeEntry(int amount, @NotNull IncomeCategory category, @NotNull String notes) {
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
    @Enumerated
    @NotNull(message = "category is required")
    private IncomeCategory category;

    @Column
    private String notes;

    public enum IncomeCategory implements Entry.Category {
        FULL_TIME_EMPLOYMENT,
        PART_TIME_EMPLOYMENT,
        TAX_RETURN,
        BUSINESS,
        CAPITAL_GAINS,
        MISCELLANEOUS,
    }
}
