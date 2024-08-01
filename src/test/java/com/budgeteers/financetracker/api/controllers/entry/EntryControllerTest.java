package com.budgeteers.financetracker.api.controllers.entry;

import com.budgeteers.financetracker.api.controllers.entry.models.ProfitResponse;
import com.budgeteers.financetracker.services.entry.EntryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;
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

//    @Test
//    void addIncomeEntrySuccess() {
//        IncomeEntryRequest request = new IncomeEntryRequest(5000, BUSINESS, "Sold hot dog");
//        ResponseEntity<EntryResponse> response = entryController.addIncomeEntry(request);
//
//        verify(entryService).addIncomeEntry(5000, BUSINESS, "Sold hot dog");
//        assertTrue(response.getStatusCode().is2xxSuccessful());
//    }

//    @Test
//    void addIncomeEntryException() {
//        doThrow(IllegalArgumentException.class).when(entryService).addIncomeEntry(anyInt(), anyString(), anyString());
//
//        IncomeEntryRequest request = new IncomeEntryRequest(100, BUSINES, "Sold hot dog");
//        ResponseEntity<EntryResponse> response = entryController.addIncomeEntry(request);
//
//        verify(entryService).addIncomeEntry(100, BUSINES, "Sold hot dog");
//        assertTrue(response.getStatusCode().is4xxClientError());
//    }

//    @Test
//    void addExpenseEntrySuccess() {
//        ExpenseEntryRequest request = new ExpenseEntryRequest(200, TRANSPORTATION, "GO BUS");
//        ResponseEntity<EntryResponse> response = entryController.addExpenseEntry(request);
//
//        verify(entryService).addExpenseEntry(200, TRANSPORTATION, "GO BUS");
//        assertTrue(response.getStatusCode().is2xxSuccessful());
//    }

//    @Test
//    void addExpenseEntryException() {
//        doThrow(IllegalArgumentException.class).when(entryService).addExpenseEntry(anyInt(), anyString(), anyString());
//        ExpenseEntryRequest request = new ExpenseEntryRequest(-1, TRANS, "HELLO");
//        ResponseEntity<EntryResponse> response = entryController.addExpenseEntry(request);
//
//        verify(entryService).addExpenseEntry(-1, TRANS, "HELLO");
//        assertTrue(response.getStatusCode().is4xxClientError());
//    }

    @Test
    void getProfitSuccess() {
        ResponseEntity<ProfitResponse> response = entryController.getProfit();

        verify(entryService).getProfit();
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

//    @Test
//    void addIncomeEntryExceptionConstraintViolationException() {
//        doThrow(ConstraintViolationException.class).when(entryService).addIncomeEntry(anyInt(), anyString(), anyString());
//        IncomeEntryRequest request = new IncomeEntryRequest(-100, BUSINESS, "money from business");
//        ResponseEntity<EntryResponse> response = entryController.addIncomeEntry(request);
//
//        verify(entryService).addIncomeEntry(-100, BUSINESS, "money from business");
//        assertTrue(response.getStatusCode().is4xxClientError());
//    }

//    @Test
//    void addExpenseEntryExceptionConstraintViolationException() {
//        doThrow(ConstraintViolationException.class).when(entryService).addExpenseEntry(anyInt(), anyString(), anyString());
//        ExpenseEntryRequest request = new ExpenseEntryRequest(-100, BUSINESS, "money from business");
//        ResponseEntity<EntryResponse> response = entryController.addExpenseEntry(request);
//
//        verify(entryService).addExpenseEntry(-100, BUSINESS, "money from business");
//        assertTrue(response.getStatusCode().is4xxClientError());
//    }
}