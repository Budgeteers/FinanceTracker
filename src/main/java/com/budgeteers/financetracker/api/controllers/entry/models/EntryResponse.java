package com.budgeteers.financetracker.api.controllers.entry.models;

import lombok.Getter;

@Getter
public class EntryResponse {
<<<<<<< 6-creating-notes
=======

>>>>>>> main
    private final int status;
    private final String message;

    public EntryResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
