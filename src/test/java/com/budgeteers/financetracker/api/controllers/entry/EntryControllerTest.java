package com.budgeteers.financetracker.api.controllers.entry;

import com.budgeteers.financetracker.api.controllers.entry.models.EntryResponse;
import com.budgeteers.financetracker.api.controllers.entry.models.IncomeEntryRequest;
import com.budgeteers.financetracker.services.entry.EntryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EntryControllerTest {

    @Mock
    private EntryService entryService;

    private EntryController entryController;

    @BeforeEach
    void setUp() {
        entryController = new EntryController(entryService);
    }

    @Test
    void addIncomeEntrySuccess() {
        IncomeEntryRequest request = new IncomeEntryRequest(5000, "BUSINESS", "Sold hot dog");
        ResponseEntity<EntryResponse> response = entryController.addIncomeEntry(request);

        verify(entryService).addIncomeEntry(5000, "BUSINESS", "Sold hot dog");
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void addIncomeEntryException() {
        doThrow(IllegalArgumentException.class).when(entryService).addIncomeEntry(anyInt(), anyString(), anyString());

        IncomeEntryRequest request = new IncomeEntryRequest(-1, "BUSINESS", "Sold hot dog");
        ResponseEntity<EntryResponse> response = entryController.addIncomeEntry(request);

        verify(entryService).addIncomeEntry(-1, "BUSINESS", "Sold hot dog");
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void addExpenseEntry() {
    }

    @Test
    void getProfit() {
    }
}