package com.budgeteers.financetracker.api.controllers.entry.models;

import com.budgeteers.financetracker.services.entry.models.IncomeEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IncomeEntryRequest {

    @JsonProperty
    @Positive
    private int amount;

    @JsonProperty
    private IncomeEntry.IncomeCategory category;

    @JsonProperty
    private String notes;

}
