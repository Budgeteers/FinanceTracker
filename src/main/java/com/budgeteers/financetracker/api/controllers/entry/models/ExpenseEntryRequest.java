package com.budgeteers.financetracker.api.controllers.entry.models;

import com.budgeteers.financetracker.services.entry.models.ExpenseEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExpenseEntryRequest {

    @JsonProperty
    @Positive
    private int amount;

    @JsonProperty
    private ExpenseEntry.ExpenseCategory category;

    @JsonProperty
    private String notes;
  
}
