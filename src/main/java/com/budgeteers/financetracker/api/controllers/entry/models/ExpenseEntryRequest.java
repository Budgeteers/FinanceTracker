package com.budgeteers.financetracker.api.controllers.entry.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExpenseEntryRequest {

    @JsonProperty
    private int amount;
}