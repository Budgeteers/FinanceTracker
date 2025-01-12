package com.budgeteers.financetracker.controller;

import com.budgeteers.financetracker.controller.model.EntryResponse;
import com.budgeteers.financetracker.controller.model.ExpenseEntryRequest;
import com.budgeteers.financetracker.controller.model.IncomeEntryRequest;
import com.budgeteers.financetracker.controller.model.ProfitResponse;
import com.budgeteers.financetracker.service.EntryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entry")
@Validated
public class EntryController {

    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/income")
    public ResponseEntity<EntryResponse> addIncomeEntry(@RequestBody @Valid IncomeEntryRequest incomeEntryRequest) {
        entryService.addIncomeEntry(incomeEntryRequest.getAmount(), incomeEntryRequest.getCategory(), incomeEntryRequest.getNotes());
        return ResponseEntity.status(HttpStatus.CREATED).body(new EntryResponse(incomeEntryRequest.getAmount(), incomeEntryRequest.getCategory().toString(), incomeEntryRequest.getNotes()));
    }

    @PostMapping("/expense")
    public ResponseEntity<EntryResponse> addExpenseEntry(@RequestBody @Valid ExpenseEntryRequest expenseEntryRequest) {
       entryService.addExpenseEntry(expenseEntryRequest.getAmount(), expenseEntryRequest.getCategory(), expenseEntryRequest.getNotes());
        return ResponseEntity.status(HttpStatus.CREATED).body(new EntryResponse(expenseEntryRequest.getAmount(), expenseEntryRequest.getCategory().toString(), expenseEntryRequest.getNotes()));
    }

    @GetMapping("/profit")
    public ResponseEntity<ProfitResponse> getProfit() {
        return ResponseEntity.ok(new ProfitResponse(entryService.getProfit()));
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity<Void> deleteExpenseEntry(@PathVariable String id) {
        entryService.deleteExpenseEntry(id);
        return ResponseEntity.accepted().build();
    }
}
