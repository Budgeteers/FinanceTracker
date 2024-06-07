package com.budgeteers.financetracker.api.controllers.entry.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfitResponse {

    @JsonProperty
    private int profit;
}
