package com.budgeteers.financetracker.api.controllers.entry.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IncomeEntryRequest {

    @JsonProperty
    private int amount;

    @JsonProperty
    private String category;

    @JsonProperty
    private String notes;

}
