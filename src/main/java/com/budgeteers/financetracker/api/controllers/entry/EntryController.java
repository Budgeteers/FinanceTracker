package com.budgeteers.financetracker.api.controllers.entry;

import com.budgeteers.financetracker.api.controllers.entry.models.EntryResponse;
import com.budgeteers.financetracker.api.controllers.entry.models.ExpenseEntryRequest;
import com.budgeteers.financetracker.api.controllers.entry.models.IncomeEntryRequest;
import com.budgeteers.financetracker.api.controllers.entry.models.ProfitResponse;
import com.budgeteers.financetracker.services.entry.EntryService;
import jakarta.validation.ConstraintViolationException;
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
        return ResponseEntity.ok().build();
    }

    @PostMapping("/expense")
    public ResponseEntity<EntryResponse> addExpenseEntry(@RequestBody @Valid ExpenseEntryRequest expenseEntryRequest) {
       entryService.addExpenseEntry(expenseEntryRequest.getAmount(), expenseEntryRequest.getCategory(), expenseEntryRequest.getNotes());
       return ResponseEntity.ok().build();
    }

    @GetMapping("/profit")
    public ResponseEntity<ProfitResponse> getProfit() {
        return ResponseEntity.ok(new ProfitResponse(entryService.getProfit()));
    }
}
