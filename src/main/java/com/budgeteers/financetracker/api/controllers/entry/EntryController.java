package com.budgeteers.financetracker.api.controllers.entry;

import com.budgeteers.financetracker.api.controllers.entry.models.ExpenseEntryRequest;
import com.budgeteers.financetracker.api.controllers.entry.models.IncomeEntryRequest;
import com.budgeteers.financetracker.api.controllers.entry.models.ProfitResponse;
import com.budgeteers.financetracker.services.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entry")
public class EntryController {

    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/income")
    public ResponseEntity<Void> addIncomeEntry(@RequestBody IncomeEntryRequest incomeEntryRequest) {
        entryService.addIncomeEntry(incomeEntryRequest.getAmount(), incomeEntryRequest.getCategory());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/expense")
    public ResponseEntity<Void> addExpenseEntry(@RequestBody ExpenseEntryRequest expenseEntryRequest) {
        entryService.addExpenseEntry(expenseEntryRequest.getAmount(), expenseEntryRequest.getCategory());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profit")
    public ResponseEntity<ProfitResponse> getProfit() {
        return ResponseEntity.ok(new ProfitResponse(entryService.getProfit()));
    }
}
