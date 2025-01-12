package com.budgeteers.financetracker.controller.model;

import com.budgeteers.financetracker.model.IncomeEntry;
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
