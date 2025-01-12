package com.budgeteers.financetracker.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfitResponse {

    @JsonProperty
    private int profit;
}
