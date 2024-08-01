package com.budgeteers.financetracker.database.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Entry {
    public Entry(int id, int amount, @NotNull String category, @NotNull String notes) {
        this.id = id;
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
    private String category;

    @Column
    private String notes;
}
